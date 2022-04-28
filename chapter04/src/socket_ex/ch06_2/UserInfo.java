package socket_ex.ch06_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;



public class UserInfo extends Thread {

	Server mContext;
	//UserInfo mContext = this;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	String nickName;
	String myCurrentRoomName;
	private Socket user_socket;
	
	private boolean roomCheck = true;
	
	Vector<UserSocket> sockets = new Vector<>();
	// 그 외 자원
	private Vector<UserInfo> vc_user = new Vector<UserInfo>();
	private Vector<RoomInfo> vc_room = new Vector<RoomInfo>();

	public UserInfo(Server mContext, Socket socket) {
		this.mContext = mContext;
		this.user_socket = socket;
		network();
	}

//	Server server = new Server();
//	UserSocket userSocket = new UserSocket(server, user_socket);
	
	
	private void network() {
		
		try {
			is = user_socket.getInputStream();
			dis = new DataInputStream(is);
			os = user_socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			// 처음 접속시 유저의 id를 입력받는다
			nickName = dis.readUTF();
			mContext.getTa().append("[[" + nickName + "]] 입장\n");
			
			// 기존 사용자들에게 신규 유저의 접속을 알린다
			mContext.broadcast("NewUser/" + nickName);
			
			// 자신에게 기존 사용자들을 알린다
			for (int i = 0; i < mContext.getVc_user().size(); i++) {
				UserInfo userInfo = mContext.getVc_user().elementAt(i);
				sendMessage("OldUser/" + userInfo.nickName);
			}
			for (int i = 0; i < mContext.getVc_room().size(); i++) {
				RoomInfo roomInfo = mContext.getVc_room().elementAt(i);
				sendMessage("OldRoom/" + roomInfo.roomName);
			}
			
			// 사용자에게 자신을 알린 후 벡터에 자신을 추가
			mContext.getVc_user().add(this);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Stream 설정에러!", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void sendMessage(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 브로드캐스트
	@Override
	public void run() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					
					try {
						String msg = dis.readUTF();
						sendMessage("[[[[" + msg + "]]]]");
						mContext.broadcast("[" + msg + "]");
						mContext.getTa().append("[[" + nickName + "]]" + msg + "\n");
						inmessage(msg);
					} catch (IOException e) {
						try {
							mContext.getTa().append(nickName + " : 사용자 접속 끊어짐\n");
							dos.close();
							dis.close();
							user_socket.close();
							mContext.getVc_user().remove(this);
							mContext.getVc_room().remove(this);
							broadCast("UserOut/" + nickName);
							broadCast("ErrorOutRoom/" + myCurrentRoomName);
							broadCast("UserData_Update/ok");
							break;
						} catch (IOException e1) {
							break;
						}
					}
				}
			}
		}).start();
		
		

	}
	
	private void inmessage(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "/");
		
		String protocol = st.nextToken();
		String message = st.nextToken();
		
		System.out.println("protocol : " + protocol);
		System.out.println("message : " + message);
		
		if(protocol.equals("Note")) {
			System.out.println(message);
			st = new StringTokenizer(message, "@");
			String user = st.nextToken();
			String note = st.nextToken();
			// 벡터에서 해당 사용자를 찾아서 쪽지를 전송한다
			for(int i = 0; i < mContext.getVc_user().size(); i++) {
				UserInfo ui = mContext.getVc_user().elementAt(i);
				//쪽지는 반드시 찾은 사용자에게 메시지를 보내줘야함
				if(ui.nickName.equals(user)) {
					ui.sendmessage("Note/" + nickName + "@" + note);
				}
			}
		} else if(protocol.equals("CreateRoom")) {
			// 1. 현재 같은방이 존재하는지 확인한다
			for(int i = 0; i < mContext.getVc_room().size(); i++) {
				RoomInfo room = mContext.getVc_room().elementAt(i);
				if(room.roomName.equals(message)) { //만들고자하는 방이름 확인
					sendmessage("CreateRoomFail/ok");
					roomCheck = false;
					break;
				}else {
					roomCheck = true;
				}
			} //end for
			if(roomCheck == true) {
				// 1. 방을 생성한다
				RoomInfo new_room = new RoomInfo(message, this);
				// 2. 전체 방 벡터에 생성된 방을 저장한다
				mContext.getVc_room().add(new_room);
				// 3. 사용자들에게 방과 방이름을 생성되었다고 알려준다
				sendmessage("CreateRoom/" + message); //자신에게 방 성공메시지를 보냄
				broadCast("new_Room/" + message);
			}
		} else if(protocol.equals("Chatting")) {
			try {
				String msg1 = st.nextToken();
				for(int i = 0; i < mContext.getVc_room().size(); i++) {
					RoomInfo ri = mContext.getVc_room().elementAt(i);
					if(ri.roomName.equals(message)) {
						ri.roomBroadcast("Chatting/" + nickName + "/" + msg1);
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "채팅 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
		} else if(protocol.equals("JoinRoom")) {
			for(int i = 0; i < mContext.getVc_room().size(); i++) {
				RoomInfo ri = mContext.getVc_room().elementAt(i);
				if(ri.roomName.equals(message)) {
					// 신규접속자를 알린다
					ri.roomBroadcast("Chatting/[[알림]]/(((" + nickName + " 입장)))");
					ri.addUser(this); // 해당 룸 객체에 자신을 추가시킨다
					sendmessage("JoinRoom/" + message);
				}
			}
		} else if(protocol.equals("OutRoom")) {
			for(int i = 0; i < mContext.getVc_room().size(); i++) {
				RoomInfo ri = mContext.getVc_room().elementAt(i);
				if(ri.roomName.equals(message)) {
					ri.removeRoom(this);
					sendmessage("OutRoom/ok");
					break;
				}
			}
		}
	}

	void sendmessage(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 전체 사용자에게 메시지를 보내는 부분
		public void broadCast(String str) {
			for (int i = 0; i < mContext.getVc_user().size(); i++) {
				UserInfo userInfo = mContext.getVc_user().elementAt(i);
				// 여기서 프로토콜의 개념을 사용
				userInfo.sendmessage(str);
			}
		}
}

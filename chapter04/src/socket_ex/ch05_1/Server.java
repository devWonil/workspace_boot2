package socket_ex.ch05_1;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel contentPane;
	private JTextField tfPort; // textFieldPort;
	private JTextArea textArea;
	private JLabel lblPortNum; // labelPortNum;
	private JButton btnServerStart; // 서버시작버튼
	private JButton btnServerStop; // 서버중단버튼

	// Network 자원
	private ServerSocket server_socket;
	private Socket socket;
	private int port;

	// 그 외 자원들
	private Vector<UserInformation> vc = new Vector<UserInformation>();
	private Vector<RoomInformation> vc_room = new Vector<RoomInformation>();

	public Server() {
		init();
		addListener();
		tfPort.requestFocus();
	}

	// GUI 초기화
	private void init() {
		setTitle("서버 동작중");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 309, 229);
		textArea = new JTextArea();
		textArea.setBounds(12, 11, 310, 230);
		scrollPane.add(textArea);
		contentPane.add(scrollPane);
		textArea.setEditable(false);
		
		lblPortNum = new JLabel("포트번호 :");
		lblPortNum.setBounds(12, 273, 82, 15);
		contentPane.add(lblPortNum);
		
		tfPort = new JTextField();
		tfPort.setBounds(98, 270, 224, 21);
		contentPane.add(tfPort);
		tfPort.setColumns(10);
		
		btnServerStart = new JButton("서버실행");
		btnServerStart.setBounds(12, 315, 154, 23);
		contentPane.add(btnServerStart);
		
		btnServerStop = new JButton("서버중지");
		btnServerStop.setBounds(168, 315, 154, 23);
		contentPane.add(btnServerStart);
		btnServerStop.setEnabled(false);
		
		setVisible(true);
	}
	
	// 이벤트 리스너
	private void addListener() {
		
		tfPort.addActionListener(this);
		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnServerStart) {
			if(tfPort.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "포트번호 입력해라", "오류", JOptionPane.ERROR_MESSAGE);
			}else if(tfPort.getText().length() != 0) {
				
				// 값을 가져와서 port변수에 저장
				port = Integer.parseInt(tfPort.getText());
				startNetwork();
				tfPort.setEditable(false);
				btnServerStart.setEnabled(false);
				btnServerStop.setEnabled(true);
			}
		}else if(e.getSource() == btnServerStop) {
			try {
				server_socket.close();
				vc.removeAllElements();
				vc_room.removeAllElements();
				tfPort.setEditable(true);
				btnServerStart.setEnabled(true);
				btnServerStop.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	private void startNetwork() {
		try {
			server_socket = new ServerSocket(port);
			textArea.append("서버를 시작하겠습니다.\n");
			connect();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다", "알림", JOptionPane.ERROR_MESSAGE);
			btnServerStart.setEnabled(true);
			btnServerStop.setEnabled(false);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void connect() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = server_socket.accept();
						
						UserInformation userInfo = new UserInformation(socket);
						userInfo.start();
					} catch (IOException e) {
						textArea.append("서버가 중지됨! 다시 스타트 버튼을 누르세요");
						break;
					}
				}
			}
		});
		thread.start();
	}
	
	// 전체 사용자에게 메시지를 보내는 부분
	public void broadCast(String str) {
		for (int i = 0; i < vc.size(); i++) {
			UserInformation userInfo = vc.elementAt(i);
			// 여기서 프로토콜의 개념을 사용
			userInfo.sendmessage(str);
		}
	}

	// 내부클래스
	class UserInformation extends Thread {
		
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		String nickName;
		String myCurrentRoomName;
		private Socket user_socket;
		
		private boolean roomCheck = true;
		
		public UserInformation(Socket socket) {
			this.user_socket = socket;
			network();
		}

		private void network() {
			try {
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				// 처음 접속시 유저의 id를 입력받는다
				nickName = dis.readUTF();
				textArea.append("[[" + nickName + "]] 입장\n");
				
				// 기존 사용자들에게 신규 유저의 접속을 알린다
				broadCast("NewUser/" + nickName);
				
				// 자신에게 기존 사용자들을 알린다
				for (int i = 0; i < vc.size(); i++) {
					UserInformation userInfo = vc.elementAt(i);
					sendmessage("OldUser/" + userInfo.nickName);
				}
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInformation roomInfo = vc_room.elementAt(i);
					sendmessage("OldRoom/" + roomInfo.roomName);
				}
				
				// 사용자에게 자신을 알린 후 벡터에 자신을 추가
				vc.add(this);
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream 설정에러!", "알림", JOptionPane.ERROR_MESSAGE);
			}
		}

		// 브로드캐스트
		@Override
		public void run() {
			while(true) {
				try {
					String msg = dis.readUTF();
					textArea.append("[[" + nickName + "]]" + msg + "\n");
					inmessage(msg);
				} catch (IOException e) {
					try {
						textArea.append(nickName + " : 사용자 접속 끊어짐\n");
						dos.close();
						dis.close();
						user_socket.close();
						vc.remove(this);
						vc_room.remove(this);
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
				for(int i = 0; i < vc.size(); i++) {
					UserInformation ui = vc.elementAt(i);
					//쪽지는 반드시 찾은 사용자에게 메시지를 보내줘야함
					if(ui.nickName.equals(user)) {
						ui.sendmessage("Note/" + nickName + "@" + note);
					}
				}
			} else if(protocol.equals("CreateRoom")) {
				// 1. 현재 같은방이 존재하는지 확인한다
				for(int i = 0; i < vc_room.size(); i++) {
					RoomInformation room = vc_room.elementAt(i);
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
					RoomInformation new_room = new RoomInformation(message, this);
					// 2. 전체 방 벡터에 생성된 방을 저장한다
					vc_room.add(new_room);
					// 3. 사용자들에게 방과 방이름을 생성되었다고 알려준다
					sendmessage("CreateRoom/" + message); //자신에게 방 성공메시지를 보냄
					broadCast("new_Room/" + message);
				}
			} else if(protocol.equals("Chatting")) {
				try {
					String msg1 = st.nextToken();
					for(int i = 0; i < vc_room.size(); i++) {
						RoomInformation ri = vc_room.elementAt(i);
						if(ri.roomName.equals(message)) {
							ri.roomBroadcast("Chatting/" + nickName + "/" + msg1);
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "채팅 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
				}
			} else if(protocol.equals("JoinRoom")) {
				for(int i = 0; i < vc_room.size(); i++) {
					RoomInformation ri = vc_room.elementAt(i);
					if(ri.roomName.equals(message)) {
						// 신규접속자를 알린다
						ri.roomBroadcast("Chatting/[[알림]]/(((" + nickName + " 입장)))");
						ri.addUser(this); // 해당 룸 객체에 자신을 추가시킨다
						sendmessage("JoinRoom/" + message);
					}
				}
			} else if(protocol.equals("OutRoom")) {
				for(int i = 0; i < vc_room.size(); i++) {
					RoomInformation ri = vc_room.elementAt(i);
					if(ri.roomName.equals(message)) {
						ri.removeRoom(this);
						sendmessage("OutRoom/ok");
						break;
					}
				}
			}
		}

		private void sendmessage(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 내부클래스
	class RoomInformation extends Thread {

		public String roomName;
		Vector<UserInformation> room_user_vc = new Vector<UserInformation>();
		
		public RoomInformation(String roomName, UserInformation ui) {
			this.roomName = roomName;
			this.room_user_vc.add(ui);
			ui.myCurrentRoomName = roomName;
		}

		public void roomBroadcast(String str) { //현재방의 모든 사람들에게 알린다
			for (int i = 0; i < room_user_vc.size(); i++) {
				UserInformation ui = room_user_vc.elementAt(i);
				ui.sendmessage(str);
			}
		}
		
		public void addUser(UserInformation ui) {
			room_user_vc.add(ui);
		}
		
		@Override
		public String toString() {
			return roomName;
		}
		
		public void removeRoom(UserInformation ui) {
			room_user_vc.remove(ui);
			boolean empty = room_user_vc.isEmpty();
			if(empty) {
				for(int i = 0; i < vc_room.size(); i++) {
					RoomInformation ri = vc_room.elementAt(i);
					if(ri.roomName.equals(roomName)) {
						vc_room.remove(this);
						broadCast("EmptyRoom/" + roomName);
						broadCast("UserData_Update/ok");
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}

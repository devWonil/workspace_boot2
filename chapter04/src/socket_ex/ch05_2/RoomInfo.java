package socket_ex.ch05_2;

import java.util.Vector;



public class RoomInfo extends Thread implements Room, Network{

	RoomInfo mContext;
	public String roomName;
	private Vector<UserInfo> vc = new Vector<UserInfo>();
	private Vector<RoomInfo> vc_room = new Vector<RoomInfo>();
	Vector<UserInfo> room_user_vc = new Vector<UserInfo>();
	
	public RoomInfo(String roomName, UserInfo ui) {
		this.roomName = roomName;
		this.room_user_vc.add(ui);
		ui.myCurrentRoomName = roomName;
	}
	
	@Override
	public void roomBroadcast(String str) {
		for (int i = 0; i < room_user_vc.size(); i++) {
			UserInfo ui = room_user_vc.elementAt(i);
			ui.sendmessage(str);
		}
	}
	
	@Override
	public void addUser(UserInfo ui) {
		room_user_vc.add(ui);
	}
	
	@Override
	public String toString() {
		return roomName;
	}
	
	@Override
	public void removeRoom(UserInfo ui) {
		room_user_vc.remove(ui);
		boolean empty = room_user_vc.isEmpty();
		if(empty) {
			for(int i = 0; i < vc_room.size(); i++) {
				RoomInfo ri = vc_room.elementAt(i);
				if(ri.roomName.equals(roomName)) {
					vc_room.remove(this);
					broadCast("EmptyRoom/" + roomName);
					broadCast("UserData_Update/ok");
					break;
				}
			}
		}
	}

	@Override
	public void broadCast(String str) {
		for (int i = 0; i < vc.size(); i++) {
			UserInfo userInfo = vc.elementAt(i);
			// 여기서 프로토콜의 개념을 사용
			userInfo.sendmessage(str);
		}
	}
	
	@Override
	public void startNetwork() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectServer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void network() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}
	
	
}

package socket_ex.ch06_2;

import java.util.Vector;

public class RoomInfo extends Thread {

	public String roomName;
	Vector<UserInfo> room_user_vc = new Vector<UserInfo>();

	Server server = new Server();

	public RoomInfo(String roomName, UserInfo ui) {
		this.roomName = roomName;
		this.room_user_vc.add(ui);
		ui.myCurrentRoomName = roomName;
	}

	public void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다
		for (int i = 0; i < room_user_vc.size(); i++) {
			UserInfo ui = room_user_vc.elementAt(i);
			// UserSocket userSocket = new UserSocket(server, null);
			ui.sendMessage(str);
		}
	}

	public void addUser(UserInfo ui) {
		room_user_vc.add(ui);
	}

	@Override
	public String toString() {
		return roomName;
	}

	public void removeRoom(UserInfo ui) {
		room_user_vc.remove(ui);
		boolean empty = room_user_vc.isEmpty();
		if (empty) {
			for (int i = 0; i < server.getVc_room().size(); i++) {
				RoomInfo ri = server.getVc_room().elementAt(i);
				if (ri.roomName.equals(roomName)) {
					server.getVc_room().remove(this);
					server.broadcast("EmptyRoom/" + roomName);
					server.broadcast("UserData_Update/ok");
					break;
				}
			}
		}
	}

}

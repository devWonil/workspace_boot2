package socket_ex.ch05_2;

public interface Room {

	void roomBroadcast(String str);
	void addUser(UserInfo ui);
	void removeRoom(UserInfo ui);
}

package socket_ex.ch07;

import java.net.Socket;

public class Client {

	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}

	// 클라이언트로부터 메시지를 전달받는 메소드
	private void receive() {
		// TODO Auto-generated method stub
		
	}
	
	private void send(String message) {
		// TODO Auto-generated method stub

	}
}

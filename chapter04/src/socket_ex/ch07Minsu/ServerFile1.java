package socket_ex.ch07Minsu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerFile1 {

	ServerFile1 mContext = this;
	ServerSocket serverSocket;
	Vector<UserSocket1> sockets = new Vector();
	
	public ServerFile1() {
		System.out.println("1. 서버소켓 시작");
		try {
			serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						UserSocket1 userSocket = new UserSocket1(mContext, socket);
						userSocket.start();
						sockets.add(userSocket);
						System.out.println("계속도나요?");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void broadcast(String msg) {
		for(int i =0; i < sockets.size(); i++) {
			sockets.get(i).sendMessage(msg);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerFile1();
	}

}

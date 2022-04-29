package socket_ex.ch07Minsu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserSocket1 extends Thread{

	ServerFile1 mContext;
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	
	public UserSocket1(ServerFile1 mContext, Socket socket) {
		
		this.mContext = mContext;
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String msg = br.readLine();
					System.out.println("서버 --> UserSocket : msg : " + msg);
					mContext.broadcast(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void sendMessage(String msg) {
		try {
			bw.write(msg + "\n");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

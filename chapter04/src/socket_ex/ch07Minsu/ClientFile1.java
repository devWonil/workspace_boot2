package socket_ex.ch07Minsu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile1 {

	Socket socket;
	BufferedWriter bw;
	final String IP = "localhost";
	final int PORT = 10000;
	
	BufferedReader kbr;
	BufferedReader br;
	
	public ClientFile1() {
		
		try {
			System.out.println("1. 클라이언트 소켓시작");
			socket = new Socket(IP, PORT);
			
			System.out.println("2. 버퍼 연결");
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.println("3. 키보드 버퍼 연결");
			kbr = new BufferedReader(new InputStreamReader(System.in));
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
			
			while(true) {
				System.out.println("4. 키보드 입력 대기");
				String msg = kbr.readLine();
				
				bw.write(msg + "\n");
				bw.flush();
				
				bw.write(msg);
				bw.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				kbr.close();
				br.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private class ReadThread implements Runnable {

		@Override
		public void run() {
			
			while(true) {
				try {
					String msg = br.readLine();
					System.out.println("서버로부터 받은 메시지 : " + msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public static void main(String[] args) {
		new ClientFile();
	}

}

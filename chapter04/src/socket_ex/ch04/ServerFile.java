package socket_ex.ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;
	
	
	/////////////////
	BufferedWriter bufferedWriter; //클라이언트 쪽으로 데이터를 보내는 녀석
	BufferedReader keyboardBufferedReader;
	
	public ServerFile() {
		System.out.println("1. >>>> 서버 소켓 시작 <<<< ");
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("2. 서버 소켓 생성 완료");
			
			socket = serverSocket.accept(); // 클라이언트 연결 대기중 ...
			System.out.println("3. 클라이언트 연결완료");
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 초기화 처리
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			// 클라이언트에게 보낼 스트림 연결 (outputStream)
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// 스레드 처리
			WriteThread writeThread = new WriteThread();
			Thread thread = new Thread(writeThread);
			thread.start();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true)); //추가
			while(true) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메시지 : " + msg);
				
				bw.write(msg + "\n"); // 추가
				bw.flush(); // 추가
				bw.close(); // 추가
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생 : " + e.getMessage());
		} finally {
			try {
				bufferedReader.close();
				keyboardBufferedReader.close();
				bufferedWriter.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	// 내부 클래스 생성
	private class WriteThread implements Runnable {

		@Override
		public void run() {
			// 키보드에서 데이터를 읽어 줌
			while(true) {
				try {
					String msg = keyboardBufferedReader.readLine();
					// 클라이언트로 데이터 보내기 --> 소켓
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		new ServerFile();
	}
}

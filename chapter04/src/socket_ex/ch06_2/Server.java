package socket_ex.ch06_2;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Server extends JFrame implements ActionListener {

	//GUI
	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;
	private JLabel lbl;
	private JButton serverStart;
	private JButton serverStop;
	private JButton save;
	
	// Network
	private int port;
	Server mContext = this;
	private ServerSocket serverSocket; // 다른 클라이언트 연결 대기 (1000 포트 번호 설정)
	
	Vector<UserSocket> sockets = new Vector<>();
	Client client = new Client();
	// 그 외 자원
	private Vector<UserInfo> vc_user = new Vector<UserInfo>();
	private Vector<RoomInfo> vc_room = new Vector<RoomInfo>();
	
	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}

	public JTextArea getTa() {
		return ta;
	}

	public void setTa(JTextArea ta) {
		this.ta = ta;
	}

	public Vector<UserInfo> getVc_user() {
		return vc_user;
	}

	public void setVc_user(Vector<UserInfo> vc_user) {
		this.vc_user = vc_user;
	}

	public Vector<RoomInfo> getVc_room() {
		return vc_room;
	}

	public void setVc_room(Vector<RoomInfo> vc_room) {
		this.vc_room = vc_room;
	}

	public Server() {
		init();
		addListener();
	}
	
	private void init() {
		setTitle("선생님 살려주세요ㅠ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ScrollPane sp = new ScrollPane();
		sp.setBounds(10, 10, 350, 270);
		ta = new JTextArea();
		ta.setBounds(12, 11, 350, 270);
		sp.add(ta);
		contentPane.add(sp);
		ta.setEditable(false);
		
		lbl = new JLabel("포트번호 : ");
		lbl.setBounds(50, 267, 130, 65);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(110, 290, 224, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		serverStart = new JButton("서버시작");
		serverStart.setBounds(120, 315, 154, 23);
		contentPane.add(serverStart);
		
		serverStop = new JButton("서버중지");
		serverStop.setBounds(120, 345, 154, 23);
		contentPane.add(serverStop);
		serverStop.setEnabled(false);
		
		save = new JButton("기록저장");
		save.setBounds(120, 375, 154, 23);
		contentPane.add(save);
		
		setVisible(true);
		
	}
	
	// 이벤트 리스너
	private void addListener() {
		tf.addActionListener(this);
		serverStart.addActionListener(this);
		serverStop.addActionListener(this);
		save.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == serverStart) {
			if(tf.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "클라이언트의 포트번호 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
			}else {
				
				// 값을 가져와서 port 변수에 저장
				port = Integer.parseInt(tf.getText());
				startNetwork();
				tf.setEditable(false);
				serverStart.setEnabled(false);
				serverStop.setEnabled(true);
			}
		}else if(e.getSource() == serverStop){
			try {
				serverSocket.close();
				vc_user.removeAllElements();
				vc_room.removeAllElements();
				tf.setEditable(true);
				serverStart.setEnabled(true);
				serverStop.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else { // 저장 버튼 누르면
			
		}
	}
	
	private void startNetwork() {
		System.out.println("1. >>> 서버 소켓 시작 <<<");
		try {
			serverSocket = new ServerSocket(port);
			ta.append("[서버시작]\n");
			connect();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다", "알림", JOptionPane.ERROR_MESSAGE);
			serverStart.setEnabled(true);
			serverStop.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다", "알림", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	private void connect() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 새로운 소켓 생성 (실제 통신할 부분)
				while(true) {
					try {
						ta.append("[사용자 접속 대기]\n");
						Socket socket = serverSocket.accept();
						UserInfo userInfo = new UserInfo(mContext, socket);
						
						vc_user.add(userInfo);
						System.out.println("사용연결됨!!");
						userInfo.start();
						
					} catch (IOException e) {
						ta.append("[서버 중지!! 재시작해라]");
						break;
					}
				}
			}
		});
		thread.start();
	}

	// 생성된 UserSocket에 접근해서 하나씩 메시지 보내기
	// 방송하다 (전체방송)
	public void broadcast(String msg) {
		for(int i = 0; i < vc_user.size(); i++) {
			vc_user.elementAt(i).sendMessage(msg);
			UserInfo userInfo = vc_user.elementAt(i);
			//UserSocket userSocket = new UserSocket(mContext, null);
			userInfo.sendMessage(msg);
		}
	}
	
	
	public static void main(String[] args) {
		new Server();
	}

	
}

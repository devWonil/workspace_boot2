package socket_ex.ch05_2;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lombok.Data;

@Data
public class Server extends JFrame implements ActionListener, Network {

	// GUI
	private JPanel contentPane;
	private JTextField tfPort; // textFieldPort
	private JTextArea textArea;
	private JLabel lblPortNum;
	private JButton btnServerStart; // 서버시작버튼
	private JButton btnServerStop; // 서버중단버튼

	// Network
	private ServerSocket server_socket;
	private Socket socket;
	private int port;

	private Vector<UserInfo> vc = new Vector<UserInfo>();
	private Vector<RoomInfo> vc_room = new Vector<RoomInfo>();

	// 생성자
	public Server() {
		init();
		addListener();
		tfPort.requestFocus();
	}

	// GUI 초기세팅
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

		lblPortNum = new JLabel("포트번호 : ");
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
		contentPane.add(btnServerStop);
		// btnServerStop.setEnabled(false);

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
		if (e.getSource() == btnServerStart) {
			if (tfPort.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "포트를 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
			} else {
				port = Integer.parseInt(tfPort.getText());
				startNetwork();
				tfPort.setEditable(false);
				btnServerStart.setEnabled(false);
				btnServerStop.setEnabled(true);
			}
		} else {
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

	@Override
	public void startNetwork() {
		try {
			server_socket = new ServerSocket(port);
			textArea.append("서버를 시작하겠습니다.\n");
			connect();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다", "알림", JOptionPane.ERROR_MESSAGE);
			btnServerStart.setEnabled(true);
			btnServerStop.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void connect() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = server_socket.accept();

						UserInfo userInfo = new UserInfo(socket);
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
	@Override
	public void broadCast(String str) {
		for (int i = 0; i < vc.size(); i++) {
			UserInfo userInfo = vc.elementAt(i);
			// 여기서 프로토콜의 개념을 사용
			userInfo.sendmessage(str);
		}
	}
	
	// 유저인포
	UserInfo userInfo = new UserInfo(socket); //?
	
	
	// 룸인포
	RoomInfo roomInfo = new RoomInfo(getTitle(), userInfo);

	@Override
	public void connectServer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void network() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Server();
	}
}

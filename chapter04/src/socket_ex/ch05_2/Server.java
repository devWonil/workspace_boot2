package socket_ex.ch05_2;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener{

	// GUI
	private JPanel contentPane;
	private JTextField tfPort; // textFieldPort
	private JTextArea textArea;
	private JLabel lblPortNum;
	private JButton btnServerStart; //서버시작버튼
	private JButton btnServerStop; //서버중단버튼
	
	// Network
	private ServerSocket server_socket;
	private Socket socket;
	private int port;
	
	//생성자
	public Server() {
		init();
		addListener();
	}
	
	//GUI 초기세팅
	private void init() {
		setTitle("서버 동작중");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		contentPane = new JPanel();
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
		//btnServerStop.setEnabled(false);
		
		setVisible(true);
	}
	
	//이벤트 리스너
	private void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new Server();
	}
}

package diary;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextArea extends JFrame {

	private static JTextArea textArea;
	private JPanel jPanel;
	private JButton jButton;
	
	String text;
	JTextField jTextField;
	
	public TextArea() {
		setInitData();
		setInitLayout();
		setEventListener();
	}
	
	private void setInitData() {
		setTitle("일기장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		
		jPanel = new JPanel();
		textArea = new JTextArea("오늘 하루는 어땠나요", 25, 30);
		jButton = new JButton("저장");
	}

	private void setInitLayout() {
		setVisible(true);
		jPanel.add(textArea);
		jPanel.add(jButton);
		
		add(jPanel, FlowLayout.LEFT);
	}

	private void setEventListener() {
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				System.out.println(textArea.getText());
				
				Calendar calendar = Calendar.getInstance();
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
				String date = dateFormat.format(calendar.getTimeInMillis());
				
				String text = textArea.getText();
				String fileName = date;
				// 버퍼는 자기 공간이 다 채워지면 자동으로 전달한다
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)); // 임시창고 buffer
					bw.write(text);
					bw.flush(); // 강제집행
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
	
	public static void main(String[] args) {
		
		new TextArea();
	}

}



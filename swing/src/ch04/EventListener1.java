package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener1 extends JFrame implements ActionListener{

	private JButton button1;
	
	public EventListener1() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("이벤트 리스너 연습1");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
		add(button1);
	}
	
	private void addEventListener() {
		// 액션이 일어나면 나에게 알려줘 --> 이벤트를 등록했다
		// 등록하다
		button1.addActionListener(this);
	}

	// 메소드 호출 되어진다
	// 콜백되어진다 --> 콜백메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		// actionPerformed 메소드를 통해서 동작을 처리한다
		System.out.println("버튼이 클릭되었습니다");
		
	}
}

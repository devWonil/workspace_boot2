package ch01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 호출자(콜리) : 멤버변수로 징검다리 역할을 하는 인터페이스를 멤버변수로 먼저 선언한다
public class SubActivity extends JFrame {

	JButton button1;
	
	// 마이너스 버튼 +1
	JButton button2;
	
	// 값을 전달받는 버튼 +1
	JButton button3;
	
	JButton button4;
	
	int result = 999;
	
	ICallbackBtnAction callbackBtnAction;
	
	// 콜리는 콜백받는 객체의 주소값을 알고 있어야 메소드가 호출되었다고 알릴 수 있다
	public SubActivity(ICallbackBtnAction iCallbackBtnAction) {
		
		this.callbackBtnAction = iCallbackBtnAction; // 주소값 받기 nullPointerExepction 해결
		
		setSize(300, 300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		button1 = new JButton("더하기 버튼 + ");
		button2 = new JButton("빼기 버튼 - ");
		button3 = new JButton("100");
		button4 = new JButton("값을 전달하는 버튼");
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("더하기 버튼 클릭!");
				
				// 하지만 (new X) --> nullPointerExepction 발생
				callbackBtnAction.clickedAddBtn();
			}
			
		});
		
		
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("빼기 버튼 클릭!");;
				
				callbackBtnAction.clickedMinusBtn();
			}
			
		});
		
		
		
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("값이 100이 되었습니다");
				
				callbackBtnAction.turnOut100Btn();
			}
			
		});
		
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callbackBtnAction.passValue(result);
			}
		});
	}
}

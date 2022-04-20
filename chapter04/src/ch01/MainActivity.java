package ch01;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 콜백 받는 객체 : ICallbackBtnAction 인터페이스를 구현해서 정의
public class MainActivity extends JFrame implements ICallbackBtnAction{

	int count;
	JLabel label;
	
	public MainActivity() {
		count = 0;
		label = new JLabel("count : " + count);
		setSize(300, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new SubActivity(this); //this 매개변수로 삽입
	}

	@Override
	public void clickedAddBtn() {
		System.out.println("+ 버튼 콜백받았습니다");
		count++;
		label.setText("count : " + count);
	}

	// - 버튼의 동작을 콜백 메소드 정의
	@Override
	public void clickedMinusBtn() {
		System.out.println("- 버튼 콜백받았습니다");
		count--;
		label.setText("count : " + count);
	}

	// - 값을 전달받는 콜백 메소드 정의
	@Override
	public void turnOut100Btn() {
		System.out.println("100 버튼 콜백받았습니다");
		count = 100;
		label.setText("count : " + count);
	}

	@Override
	public void passValue(int result) {
		label.setText("전달받은 값 : " + result);
	}
	
}

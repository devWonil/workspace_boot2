package tenco.com.test_16_1;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tenco.com.test_16.Bubble;

public class BubbleFrame extends JFrame{ // JFrame 상속

	// 1단계
	private BubbleFrame mContext = this;
	
	private JLabel backgroundMap; // JLabel 클래스 멤버변수 선언
	public Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgropundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player(); //플레이어 객체
		add(player);
	}
	
	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // absolute (좌표값으로 자유롭게 그림을 그릴 수 있다)
		
		setLocationRelativeTo(null); //JFrame 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initListener() {
		addKeyListener(new KeyAdapter() {
			// 키보드 누름 이벤트 처리
			@Override
			public void KeyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					break;
					}
				case KeyEvent.VK_SPACE:
					Bubble bubble = new Bubble(mContext);
					add(bubble);
					break;
				}
			} // end of keyPressed
			
			// 키보드 해제 이벤트 처리
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;
				default:
					break;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}

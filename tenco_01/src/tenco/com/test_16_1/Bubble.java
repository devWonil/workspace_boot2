package tenco.com.test_16_1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;
import tenco.com.test_16.PlayerWay;

@Data //롬복 라이브러리 활용 (Getters, Setters 선언하지 않아도 돼서 코드를 줄여줌)
public class Bubble extends JLabel implements Moveable {

	// 1단계
	private BubbleFrame mContext;

	// 의존성 컴포지션
	private Player player;
	private BackgroundBubbleObserver backgroundBubbleObserver;

	// 위치상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state;

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	public Bubble() {
		this.mContext = mContext;
		this.player = mContext.player;
		initObject();
		initSetting();
		initThread();
	}

	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");
		backgroundBubbleObserver = new BackgroundBubbleObserver(this);
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;
		
		x = player.getX();
		y = player.getY();
		
		setIcon(bubble);
		setSize(50, 50);
		
		state = 0;
	}

	private void initThread() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if(player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				}else {
					right();
				}
			}
			
		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			// 현재 색상 체크 (메소드 호출)
			if(backgroundBubbleObserver.checkLeftWall()) {
				left = false; //초기화
				break;
			}
			threadSleep(1);
		}
		left = false; //초기화
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkRightWall()) {
				right = false;// 초기화
				break;
			}
			threadSleep(1);
		}
		right = false; //초기화
		up();
	}

	@Override
	public void up() {
		up = true;
		while(up) {
			y--;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkTopWall()) {
				up = false; // 초기화
				break;
			}
			threadSleep(1);
		}
		up = false;
		removeBubble();
	}

	public void removeBubble() {
		
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			// 다시 그림 그려라
			
			mContext.remove(this); // 메모리에서 제거
			mContext.repaint(); // 도화지에서 그림을 다시 그려라
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

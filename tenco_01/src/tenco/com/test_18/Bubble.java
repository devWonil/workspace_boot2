<<<<<<< HEAD
package tenco.com.test_18;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Bubble extends JLabel implements Moveable {

	// 2단계
	private Bubble bubbleContext = this;
	
	// 의존성 컴포지션
	private Player player;
	// --------
	private BackgroundBubbleObserver backgroundBubbleObserver;
	
	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0 기본 1 적을 가둔 상태

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	
	// 의존 주입 --> 생성자에 주입을 받는다
	public Bubble(Player player) {
		this.player = player;
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
				if (player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				} else {
					right();
				}
			}

		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 250; i++) {
			x--;
			setLocation(x, y);
			// 현재 색상 체크 (메소드 호출)
			if(backgroundBubbleObserver.checkLeftWall()) {
				left = false; // 상태변수 초기화
				break;
			}
			threadSleep(1);
		}
		left = false; // 상태변수 초기화
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 250; i++) {
			x++;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkRightWall()) {
				right = false; // 상태변수 초기화
				break;
			}
			threadSleep(1);
		}
		right = false; // 상태변수 초기화
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkTopWall()) {
				up = false; // 상태변수 초기화
				break;
			}
			threadSleep(1);
		}
		up = false; // 상태변수 초기화
		removeBubble();
	}

	private void removeBubble() {
		
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			bubbleContext = null;
			setIcon(null);
			// 다시 그림을 그려라
//			mContext.remove(this); // 메모리에서 제거
//			mContext.repaint(); // 도화지에서 그림을 다시 그려라
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
=======
package tenco.com.test_18;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Bubble extends JLabel implements Moveable {

	// 2단계
	private Bubble bubbleContext = this;
	
	// 의존성 컴포지션
	private Player player;
	// --------
	private BackgroundBubbleObserver backgroundBubbleObserver;
	
	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0 기본 1 적을 가둔 상태

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	
	// 의존 주입 --> 생성자에 주입을 받는다
	public Bubble(Player player) {
		this.player = player;
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
				if (player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				} else {
					right();
				}
			}

		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 250; i++) {
			x--;
			setLocation(x, y);
			// 현재 색상 체크 (메소드 호출)
			if(backgroundBubbleObserver.checkLeftWall()) {
				left = false; // 상태변수 초기화
				break;
			}
			threadSleep(1);
		}
		left = false; // 상태변수 초기화
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 250; i++) {
			x++;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkRightWall()) {
				right = false; // 상태변수 초기화
				break;
			}
			threadSleep(1);
		}
		right = false; // 상태변수 초기화
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkTopWall()) {
				up = false; // 상태변수 초기화
				break;
			}
			threadSleep(1);
		}
		up = false; // 상태변수 초기화
		removeBubble();
	}

	private void removeBubble() {
		
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			bubbleContext = null;
			setIcon(null);
			// 다시 그림을 그려라
//			mContext.remove(this); // 메모리에서 제거
//			mContext.repaint(); // 도화지에서 그림을 다시 그려라
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
>>>>>>> f387059aedb0ba26e67604abb4a430ff086cc0af

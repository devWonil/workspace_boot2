package ver1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel implements Moveable {

	// 위치상태
	private int x;
	private int y;

	// 플레이어의 방향
	private PlayerWay playerWay;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean jumpUp;
	private boolean jumpDown;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 이미지 저장
	private ImageIcon kitPlayerF; // 키친에서의 앞모습
	// 일단 뒤(Top)으로 갈땐 뒷면말고 left/right모습으로 가기로
	private ImageIcon kitPlayerL; // 키친에서의 왼쪽모습
	private ImageIcon kitPlayerR; // 키친에서의 오른쪽모습

	private ImageIcon delPlayerL; // 배달맵에서의 왼쪽모습
	private ImageIcon delPlayerR;// 배달맵에서의 오른쪽모습
	// 배달맵에서는 앞모습뒷모습 둘 다 없음

	// TODO 나중에 객체랑 상호작용해주는 부분 구현필요할 듯
	// 예를들어 벽에 충돌한 상태

	
	
	public Player() {
		initObject();
		initSetting();
	}


	private void initObject() {
		kitPlayerF = new ImageIcon("images/LoopyKit_front.png");
		kitPlayerL = new ImageIcon("images/LoopyKit_left.png");
		kitPlayerR = new ImageIcon("images/LoopyKit_right.png");

		delPlayerL = new ImageIcon("images/LoopyDel_left.png");
		delPlayerR = new ImageIcon("images/LoopyDel_right.png");

	}

	private void initSetting() {
		x = 500;
		y = 700;

		left = false;
		right = false;
		up = false;
		down = false;
		jumpUp = false;
		jumpDown = false;

		leftWallCrash = false;
		rightWallCrash = false;

		playerWay = PlayerWay.RIGHT;
		setIcon(kitPlayerF);
		setSize(60, 80); // 사이즈 통일
		setLocation(x, y);

	}
	@Override
	public void left() {
		System.out.println("left");
		playerWay = PlayerWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					setIcon(kitPlayerL);
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void right() {
		System.out.println("right");
		playerWay = playerWay.RIGHT;
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {

				while (right) {
					setIcon(kitPlayerR);
					x = x + SPEED;
					setLocation(x, y);

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (up) {
					y = y - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();

	}

	@Override
	public void down() {
		System.out.println("down");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					setIcon(kitPlayerF);
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}).start();

	}

	@Override
	public void jumpUp() {
		System.out.println("jumpUp");
		jumpUp = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 120 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				jumpUp = false;
				jumpDown();

			}
		}).start();

	}

	@Override
	public void jumpDown() {
		System.out.println("jumpDown");
		jumpDown = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (jumpDown) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				jumpDown = false;
			}
		}).start();

	}

	public static void main(String[] args) {

	}
} // end of class

package tenco.com.test_16_1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;
@Data //롬복 라이브러리 활용 (Getters, Setters 선언하지 않아도 돼서 코드를 줄여줌)
public class Player extends JLabel implements Moveable {

	//위치 상태
	private int x;
	private int y;
	
	//플레이어 상태
	PlayerWay playerWay; // enum 활용
	
	//움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	//플레이어 속도 상태
	private final int SPEED = 3; //파이널 변수 (값을 바꾸지 않겠다)
	private final int JUMPSPEED = 2;
	
	//벽에 충돌한 상태
	private boolean leftWallCrash; // 왼쪽벽
	private boolean rightWallCrash; //오른쪽벽
	
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	// 게터 세터
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public PlayerWay getPlayerWay() {
		return playerWay;
	}

	public void setPlayerWay(PlayerWay playerWay) {
		this.playerWay = playerWay;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	//생성자
	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();
	}
	
	private void initBackgroundPlayerService() {
		new Thread(new BackgroundPlayerService(this)).start(); //익명 구현객체
	}
	
	private void initObject() {
		playerL = new ImageIcon("images/playerL.png"); //이미지 파일
		playerR = new ImageIcon("images/playerR.png");
	}
	
	private void initSetting() { //초기값 세팅
		x = 80; // x좌표
		y = 535; // y좌표
		
		left = false;
		right = false;
		up = false;
		down= false;
		
		leftWallCrash = false;
		rightWallCrash = false;
		
		playerWay = PlayerWay.RIGHT;
		
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// 이벤트 핸들러
	@Override
	public void left() {
		playerWay = PlayerWay.LEFT;
		System.out.println("left");
		left = true;
		new Thread(new Runnable() {

			@Override //메소드 오버라이딩 (자동)
			public void run() {
				while(left) {
					setIcon(playerL);
					x -= SPEED;  // 플레이어 속도만큼 x좌표 왼쪽으로 이동
					setLocation(x, y);
					try {
						Thread.sleep(10); // 0.01s
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
		playerWay = PlayerWay.RIGHT;
		System.out.println("right");
		right = true;

		new Thread(new Runnable() {

			@Override //메소드 오버라이딩 (자동)
			public void run() {
				while (right) {
					setIcon(playerR);
					x += SPEED; // 플레이어 속도만큼 x좌표 오른쪽으로 이동
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
				for (int i = 0; i < (130 / JUMPSPEED); i++) {
					y -= JUMPSPEED; // 점프스피드만큼 y좌표 위로 이동
					setLocation(x, y);
					
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				up = false;
				down();
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
				while(down) {
					y += JUMPSPEED; // 점프스피드만큼 y좌표 아래로 이동
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				down = false;
			}
			
		}).start();
	}

}

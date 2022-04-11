package tenco.com.test_16;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 메인스레드 바쁨 -> 키보드 이벤트 처리하기 때문에
// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable{

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// 도전과제 !! 던지거나 처리
		// 색상 확인
		while(true) {
			Color leftColor = new Color(image.getRGB(player.getX() + 5, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			
//			Color bottomColor = new Color(image.getRGB(player.getX() + 25, player.getY() + 50 + 10));
			int bottomColor = image.getRGB(player.getX() + 10 + 25, player.getY() + 50) // -1
					+ image.getRGB(player.getX() + 25, player.getY() + 50); // -1
			// -1이 아니라는 것은 빨간색 이거나 파란색이다
			System.out.println(bottomColor);
			// -2가 아니라면 바닥충돌 확인
			if(bottomColor != -2) { 
				//System.out.println("바닥 컬러 : " + bottomColor);
				player.setDown(false);
				
			} else {
				// 점프하는 순간 down 메소드 호출
				if(!player.isUp() && !player.isDown()) { // 내려가다가 끝까지 내려감
					// 버그 (무한 호출) : 백그라운드서비스는 계속 실행 됨
					// Player에서 down == false 일 경우에만 한번 실행되게 수정해야 함
					player.down();
					//System.out.println("아래로");
				}
			}
			
			// 외벽충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				//System.out.println("왼쪽 벽 충돌");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			}else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				//System.out.println("오른쪽 벽 충돌");
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				//System.out.println("11111111111111");
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
//			System.out.println("-------------------------------");
//			System.out.println("왼쪽 색상 : " + leftColor);
//			System.out.println("오른쪽 색상 : " + rightColor);
//			System.out.println("-------------------------------");
			
			try {
				// 캐릭터가 이동될 때 컬러값을 못 찾는 경우가 있다
				// 이동 속도보다 더 빠르게 움직여야 해결가능
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

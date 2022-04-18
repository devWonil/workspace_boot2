package tenco.com.test_16_1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// 색상확인
		while(true) {
			Color leftColor = new Color(image.getRGB(player.getX() + 5, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			
			int bottomColor = image.getRGB(player.getX() + 10 + 25, player.getY() + 50) // -1
					+ image.getRGB(player.getX() + 25, player.getY() + 50); //-1
			// -1이 아니라는 것은 빨간색이거나 파란색이다
			System.out.println(bottomColor);
			// -2가 아니라면 바닥충돌 확인
			if(bottomColor != -2) {
				player.setDown(false);
			}else {
				// 점프하는 순간 down 메소드 호출
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
			
			// 외벽충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
			}else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

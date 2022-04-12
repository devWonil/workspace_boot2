package ver1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapServiceFrame implements Runnable{

	private BufferedImage image;
	private Player player;
	
	public BackgroundMapServiceFrame(Player player) {
		this.player = player;
		
		try {
			image  = ImageIO.read(new File("images/kitService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// 색상 확인
		while(true) {
			// 주문(노란색) RGB(0 225 0)
			// 반죽(연두색) RGB(0 225 0)
			// 튀김기(파란색) RGB(0 225 0)
			// 튀김 (분홍색) RGB(0 225 0)
			// 양념 (금색) RGB(200 200 0)
			// 포장 (진한금색) RGB(150 150 0)
			// 냉장고 RGB(92 156 109)
			// 입구 RGB(0 225 225)
		}
	}

}

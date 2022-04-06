package thread_ex;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMiniGame extends JFrame implements KeyListener{
	
	private BufferedImage bgImage;
	private BufferedImage image2;
	private BufferedImage image3;
	private CustomJpanel imagePanel;
	
	private String bgImageFileName = "stadium.png";
	private String image2FileName = "football.png";
	private String image3FileName = "icon2.png";
	
	int xPoint = 0;
	int yPoint = 0;
	int image3xPoint = 0;
	
	
	public MyMiniGame() {
		initData();
		setInitLayout();
		addEventListener();
		
		// 생성자에서 Thread start 처리
		Thread thread = new Thread(imagePanel);
		thread.start();
	}
	
	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//파일 가져오기 todo
		try {
			bgImage = ImageIO.read(new File(bgImageFileName));
			image2 = ImageIO.read(new File(image2FileName));
			image3 = ImageIO.read(new File(image3FileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다");
		}
		imagePanel = new CustomJpanel();
		
		
		
	}
	
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		
		add(imagePanel);
		
		
	}
	
	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 여기서는 이미지 2번을 키 이벤트를 받아서 동작
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_UP) {
					// yPoint -= 10;
					yPoint = (yPoint < 0) ? 0 : yPoint - 10;
				}else if(keyCode == KeyEvent.VK_DOWN) {
					// yPoint += 10;
					yPoint = (yPoint > bgImage.getHeight()) ? bgImage.getHeight() : yPoint + 10;
				}else if(keyCode == KeyEvent.VK_LEFT) {
					xPoint = (xPoint < 0) ? 0 : xPoint - 10;
				}else if(keyCode == KeyEvent.VK_RIGHT) {
					xPoint = (xPoint > bgImage.getHeight()) ? bgImage.getHeight() : xPoint + 10;
				}
				
				repaint();
			}
		});
		//버튼 동작
		
	}
	
	
	
	
	private class CustomJpanel extends JPanel implements Runnable{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지를 3개 그리기
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(image2, xPoint, yPoint, 100, 100, null);
			g.drawImage(image3, image3xPoint, 430, 100, 100, null);
		}

		@Override
		public void run() {
			boolean direction = true;
			// 이미지 3번을 좌 우
			// while(true) {} <<-- 이미지 하나를 >>>>>>>  <<<<<<<<<
			while(true) {
				// x좌표값을 +
				if (direction) {
					image3xPoint += 10;
					
				}else {
					image3xPoint -= 10;
					
				}
				
				if(image3xPoint == 500) {
					direction = false;
				}
				if(image3xPoint == 100) {
					direction = true;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
			
			// max좌표값 확인하고
			// x좌표값을 -
			// 그림을 다시 그려주세요 repaint()
			
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new MyMiniGame();
	}
}

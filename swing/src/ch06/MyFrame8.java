package ch06;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame8 extends JFrame implements KeyListener{

	private BufferedImage bgImage;
	private BufferedImage imageIcon;
	private ImagePanel imagePanel;
	
	int xPoint = 200;
	int yPoint = 200;
	// 이벤트 리스너 등록 1, 2, 3
	public MyFrame8() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("축구장에서 움직이는 공");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			bgImage = ImageIO.read(new File("stadium.png"));
			imageIcon = ImageIO.read(new File("football.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다");
		}
		
		imagePanel = new ImagePanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(imagePanel);
	}

	private void addEventListener() {
		this.addKeyListener(this);

	}
	
	private class ImagePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지 2개를 그려주는 기능을 완료
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(imageIcon, xPoint, yPoint, 100, 100, null);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MyFrame8();
	}
	
}

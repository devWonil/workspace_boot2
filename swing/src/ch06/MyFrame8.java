package ch06;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
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
	
	// 이벤트 리스너 등록 1, 2, 3
	public MyFrame8() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("축구장에서 움직이는 공");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			bgImage = ImageIO.read(new File("stadium.png"));
			imageIcon = ImageIO.read(new File("football.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다");
		}
		
		imagePanel = new MyImagePanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
		add(imagePanel);
	}

	private class MyImagePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지 2개를 그려주는 기능을 완료
			g.drawImage(bgImage, 0, 0, 600, 600, null);
			g.drawImage(imageIcon, 0, 0, 100, 100, null);
		}
	}

	private void addEventListener() {
		this.add(label);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					label.setLocation(label.getX(), label.getY() - 10);
					break;

				case KeyEvent.VK_DOWN:
					label.setLocation(label.getX(), label.getY() + 10);
					break;
				case KeyEvent.VK_LEFT:
					label.setLocation(label.getX() - 10, label.getY());
					break;
				case KeyEvent.VK_RIGHT:
					label.setLocation(label.getX() + 10, label.getY());
					break;

				}

			}
		});

	}

	// 내부클래스 선언 - paintComponent
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);

	}

	public static void main(String[] args) {
		new MyFrame8();
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

	
}

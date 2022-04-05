package ch06;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame9 extends JFrame {
	static BufferedImage icon;
	static BufferedImage bgImage;
	JLabel k = new JLabel();

	public MyFrame9() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("축구장에서 움직이는 공");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			bgImage = ImageIO.read(new File("stadium.png"));
			icon = ImageIO.read(new File("football.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다");
		}
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(new MyImagePanel());
	}

	private class MyImagePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지 2개를 그려주는 기능을 완료
			g.drawImage(bgImage, 0, 0, 600, 600, null);
			g.drawImage(icon, 0, 0, 100, 100, null);
		}
	}

	private void addEventListener() {
		BufferedImage icon = new BufferedImage(null, null, rootPaneCheckingEnabled, null);
		this.add(k);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					k.setLocation(k.getX(), k.getY() - 10);
					break;

				case KeyEvent.VK_DOWN:
					k.setLocation(k.getX(), k.getY() + 10);
					break;
				case KeyEvent.VK_LEFT:
					k.setLocation(k.getX() - 10, k.getY());
					break;
				case KeyEvent.VK_RIGHT:
					k.setLocation(k.getX() + 10, k.getY());
					break;

				}

			}
		});

	}

	public static void main(String[] args) {
		new MyFrame9();

	}
}

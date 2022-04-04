package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class MyPaint extends JFrame{

	MyPanel myPanel;
	
	public MyPaint() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("집 그려보기");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel();
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(myPanel);
	}
	
	public static void main(String[] args) {
		new MyPaint();
	}
	
	// 내부 클래스
	class MyPanel extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(50, 50, 250, 250);
			
			g.drawLine(150, 20, 50, 50);
			g.drawLine(150, 20, 300, 50);
		}
	}
}

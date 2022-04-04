package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(50, 50, 250, 250);
		g.drawRect(70, 70, 100, 100);
		
		g.drawLine(70, 120, 170, 120);
		g.drawLine(120, 70, 120, 170);
		g.drawLine(200, 170, 300, 170);
		g.drawLine(200, 170, 200, 300);
		g.drawLine(175, 20, 50, 50);
		g.drawLine(175, 20, 300, 50);
		
		g.drawArc(210, 235, 20, 20, ALLBITS, ABORT);
	}
}

public class MyHouseFrame extends JFrame{

	MyPanel myPanel;
	
	public MyHouseFrame() {
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
		new MyHouseFrame();
	}

	
}

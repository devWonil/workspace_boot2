package ch02;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {

	private BorderLayout borderLayout;
	private ArrayList<JButton> buttons = new ArrayList<>();
	private ArrayList<String> titles = new ArrayList<>();
	private ArrayList<String> directions = new ArrayList<>();

	public MyFrame2() {

		
		titles.add("북");
		titles.add("센터");
		titles.add("남");
		titles.add("동");
		titles.add("서");

		directions.add(BorderLayout.NORTH);
		directions.add(BorderLayout.CENTER);
		directions.add(BorderLayout.SOUTH);
		directions.add(BorderLayout.EAST);
		directions.add(BorderLayout.WEST);

		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("BorderLayout TEST");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();

		for (int i = 0; i < titles.size(); i++) {
			// buttons[i] = new JButton(titles[i]);
			buttons.add(new JButton(titles.get(i)));
		}
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(borderLayout);

		for (int i = 0; i < titles.size(); i++) {
			// add(buttons[i], directions[i]);
			add(buttons.get(i), directions.get(i));
		}
	}

	public static void main(String[] args) {
		new MyFrame2();
	}
}

package ch03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyComponents extends JFrame{

	private JPanel jPanel;
	private JButton jButton;
	private JLabel jLabel;
	JTextField jTextField;
	private JPasswordField jPasswordField;
	private JCheckBox jCheckBox;
	
	public MyComponents() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("컴포넌트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		
		jPanel = new JPanel();
		
		Dimension dimension = new Dimension(300, 300);
		
		jPanel.setPreferredSize(dimension);
		
		
		jButton = new JButton("button");
		jLabel = new JLabel("label");
		jTextField = new JTextField("hint", 20);
		jPasswordField = new JPasswordField(20);
		jCheckBox = new JCheckBox("checkBoard", true);
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 300, 200));
		
		add(jPanel);
		jPanel.setBackground(Color.BLACK);
		jPanel.add(jButton);
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jPasswordField);
		jPanel.add(jCheckBox);
	}
	
	public static void main(String[] args) {
		new MyComponents();
		// 메인함수 코딩
	}
	
}

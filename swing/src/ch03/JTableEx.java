package ch03;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableEx extends JFrame{

	JTable jTable = new JTable();
	
	public JTableEx() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("JTable 쓰기");
		setSize(800, 800);
		
		String[][] d = { { "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, };
		
		String[] cn = { "Name", "Age", "House Address" };
		
		jTable = new JTable(d, cn);
		JScrollPane jsp = new JScrollPane(jTable);
		add(jsp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setInitLayout() {
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableEx();
	}
}

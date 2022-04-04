package ch03;

//Java program to demonstrate JTable
//import the following swing packages
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//sample class
public class JavaTableExample {
// declare frame
	JFrame fr;
// declare Table
	JTable jt;

// Constructor of the class
	JavaTableExample() {
// initiallization of the frame
		fr = new JFrame();
// set Title for the frame
		fr.setTitle("JTable Sample");
// Data that will be displayed in JTable
		String[][] d = { { "Sam", "29", " Twinkle House" }, { "Anna Sam", " 27 ", "Happy Villa" },
				{ "Iza Norah", " 4 ", "Happy house" }, };
// Names of the column
		String[] cn = { "Name", "Age", "House Address" };
// JTable initialization
		jt = new JTable(d, cn);
//set bounds for JTable
		jt.setBounds(30, 40, 200, 300);
// add it to the JScrollPane
		JScrollPane jsp = new JScrollPane(jt);
		fr.add(jsp);
// set the Size of frame
		fr.setSize(500, 200);
//set the frame visibility as true
		fr.setVisible(true);
	}

// main method
	public static void main(String[] args) {
		new JavaTableExample();
	}
}
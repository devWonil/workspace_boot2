package ver1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundMapFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JButton changeBtn;
	
	public BackgroundMapFrame() {
		initObject();
		initSetting();
		initListener();
		
		setVisible(true);

	}
	
	private void initObject() {
		
	}
	
	private void initSetting() {
		
	}
	
	private void initListener() {
		
	}
	
	private void changePanel() {
		changeBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
			}
		});
	}

}

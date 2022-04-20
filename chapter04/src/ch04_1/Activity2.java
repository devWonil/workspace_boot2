package ch04_1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Activity2 extends BaseActivity {

	CallbackCheckPosition callbackCheckPosition;
	
	public void setCallbackCheckPosition(CallbackCheckPosition callbackCheckPosition) {
		this.callbackCheckPosition = callbackCheckPosition;
	}

	public Activity2(String name) {
		super(name);
		
		addEventListener();
	}

	private void addEventListener() {
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				callbackCheckPosition.checkPosition(x, y);
			}
		});
	}
	
}

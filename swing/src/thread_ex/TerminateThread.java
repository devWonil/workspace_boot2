package thread_ex;

import java.io.IOException;

public class TerminateThread extends Thread {

	private boolean flag = false;
	int i;
	
	public TerminateThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while(!flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " end ");
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	public static void main(String[] args) {

		TerminateThread terminateThreadA = new TerminateThread("A");
		TerminateThread terminateThreadB = new TerminateThread("B");
		TerminateThread terminateThreadC = new TerminateThread("C");
		
		terminateThreadA.start();
		terminateThreadB.start();
		terminateThreadC.start();
		
		int in;
		while(true) {
			
			try {
				in = System.in.read();
				
				if(in == 'A') {
					terminateThreadA.setFlag(true);
				}else if(in == 'B') {
					terminateThreadB.setFlag(true);
				}else if(in == 'C') {
					terminateThreadC.setFlag(true);
				}else if(in == 'M') {
					terminateThreadA.setFlag(true);
					terminateThreadB.setFlag(true);
					terminateThreadC.setFlag(true);
				}else {
					System.out.println("type again");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end of while
		
//		System.out.println("main end");
	}

}

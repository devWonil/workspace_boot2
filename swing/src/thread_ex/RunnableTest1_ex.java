package thread_ex;

import javax.swing.JFrame;

class MyRunnable1_ex extends JFrame implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
	}
}




public class RunnableTest1_ex {

	public static void main(String[] args) {
		// 사용법
		MyRunnable1_ex myRunnable1_ex = new MyRunnable1_ex();
		// Runnable을 구현한 객체는 스레드를 생성해서 매개 변수에 담고 스레드를 시작하면 된다
		
		Thread thread1 = new Thread(myRunnable1_ex);
		thread1.start();
		
		Thread thread2 = new Thread(myRunnable1_ex);
		thread2.start();
	}

}

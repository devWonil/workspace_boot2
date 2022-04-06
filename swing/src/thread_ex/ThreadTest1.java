package thread_ex;

public class ThreadTest1 {

	// 메인 함수 코드의 시작점
	// 메인스레드
	public static void main(String[] args) {
		for(int i = 0; i <50; i++) {
			System.out.println(i + "\t");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

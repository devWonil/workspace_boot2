package ch04;

public class MainTest {

	public static void main(String[] args) {
		
		Television television = new Television();
		
		RemoteController[] remoteController = new RemoteController[3];
		remoteController[0] = television;
		
		remoteController[0].turnOn();

	}

}

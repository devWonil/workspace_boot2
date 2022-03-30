package ch03;

public class MainTest1 {

	public static void main(String[] args) {
		
		Television television = new Television();
		Refrigerator refrigerator = new Refrigerator();
		ToyRobot toyRobot = new ToyRobot();
		
//		television.turnOn();
//		refrigerator.turnOn();
//		toyRobot.turnOn();
//		System.out.println("----------");
//		television.turnOff();
//		refrigerator.turnOff();
//		toyRobot.turnOff();
		
		// 다형성
		
		RemoteController[] remoteController = new RemoteController[3];
		remoteController[0] = television;
		remoteController[1] = refrigerator;
		remoteController[2] = toyRobot;

		for(int i = 0; i < remoteController.length; i++) {
			remoteController[i].turnOn();
		}
		System.out.println("----------");
		
		for(int i = 0; i < remoteController.length; i++) {
			remoteController[i].turnOff();
		}
	}

}

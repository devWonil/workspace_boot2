package ch04;

public class ToyRobot implements RemoteController {

	String name;

	public ToyRobot() {
		this.name = "터닝메카드";
	}

	@Override
	public void turnOff() {
		System.out.println("로봇 ON");
	}

	@Override
	public void turnOn() {
		System.out.println("로봇 OFF");
	}

}

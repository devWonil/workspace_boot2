package thread_ex;

class SharedComputer {
	
	private boolean computer = true;

	public boolean isComputer() {
		return computer;
	}

	public void setComputer(boolean computer) {
		this.computer = computer;
	}
	
	// 사용시
	public void ocuppied(boolean computer) {
		
		boolean currentStatus = isComputer();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setComputer(currentStatus);
		System.out.println("컴퓨터 사용중");
	}
	
	// 비어있을시
	public void vacant(boolean computer) {
		
		boolean currentStatus = isComputer();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setComputer(!currentStatus);
		System.out.println("컴퓨터 사용가능");
	}
}

class StudentA extends Thread {
	SharedComputer computer;
	
	public StudentA(SharedComputer computer) {
		this.computer = computer;
	}
	
	@Override
	public void run() {
		computer.ocuppied(isDaemon());
	}
}

class StudentB extends Thread {
	SharedComputer computer;
	
	public StudentB(SharedComputer computer) {
		this.computer = computer;
	}
	
	@Override
	public void run() {
		computer.vacant(isDaemon());
	}
}

public class SharedResource_Ex {

	public static void main(String[] args) {
		// 현재 컴퓨터 사용중
		SharedComputer computer = new SharedComputer();
		
		StudentA studentA = new StudentA(computer);
		StudentB studentB = new StudentB(computer);
		
		studentB.start();
		studentA.start();
	}

}

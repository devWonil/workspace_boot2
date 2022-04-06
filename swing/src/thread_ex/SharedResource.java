package thread_ex;

class BankAccount {
	
	private int money = 100_000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	// 입금 기능
	// synchronized 키워드 사용
	public synchronized void deposit(int money) {
		// 10만원
		int currentMoney = getMoney();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setMoney(currentMoney + money);
		System.out.println("입금 후 계좌잔액 : " + getMoney());
	}
	
	// 출금 기능
	// synchronized 키워드 사용
	public void withdraw(int money) {
		
		synchronized (this) {
			int currentMoney = getMoney();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			setMoney(currentMoney - money);
			System.out.println("출금 후 계좌잔액 : " + getMoney());
		}
	}
}

// 아버지 세종시 입금합니다 (네트워크가 느려서 시간이 조금 걸림)
class Father extends Thread {
	BankAccount account;
	
	public Father(BankAccount account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.deposit(10_000);
	}
	
}

// 엄마
class Mother extends Thread {
	BankAccount account;
	
	public Mother(BankAccount account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.withdraw(5000);
	}
}

public class SharedResource {

	public static void main(String[] args) {
		// 현재 10만원 저금되어있음
		BankAccount account = new BankAccount();
		
		Father father = new Father(account);
		Mother mother = new Mother(account);
		
		// 아버지가 입금합니다
		father.start();
		// 어머니가 출금합니다
		mother.start();
		
		// 10만5천원
		// 정상 처리금액 : 10 + 1 - 0.5 = 10.5
		
		// 공유되는 자원을 활용할 때 의도치 않은 결과를 생성할 수 있다
		// 해결방법 --> 동기화
	}

}

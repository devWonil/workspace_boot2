package ch07;

public class Car {

	private int carNumber;
	private String carName;

	public Car(int carNumber, String carName) {
		super();
		this.carNumber = carNumber;
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", carName=" + carName + "]";
	}

	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car tempCar = (Car)obj; //다운캐스팅
			String carName = tempCar.carName;
			if(this.carName == carName) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}

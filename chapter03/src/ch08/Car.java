package ch08;

public class Car {

	private int carPlate;
	private String carName;
	private String carOwner;

	public Car(int carPlate, String carName, String carOwner) {
		super();
		this.carPlate = carPlate;
		this.carName = carName;
		this.carOwner = carOwner;
	}

	public int getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(int carPlate) {
		this.carPlate = carPlate;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	@Override
	public String toString() {
		return "Car [차량번호=" + carPlate + ", 차종=" + carName + ", 소유주=" + carOwner + "]";
	}

}

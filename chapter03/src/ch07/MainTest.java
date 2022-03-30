package ch07;

public class MainTest {

	public static void main(String[] args) {
		
		Car car1 = new Car(534064, "BMW");
		Car car2 = new Car(534065, "벤츠");
		Car car3 = new Car(534066, "BMW");

		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
		
		if(car1.equals(car3)) {
			System.out.println("같은 차종입니다");
		}else {
			System.out.println("다른 차종입니다");
		}
	}

}

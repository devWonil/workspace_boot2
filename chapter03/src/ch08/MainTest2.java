package ch08;

import java.util.ArrayList;

public class MainTest2 {

	public static void main(String[] args) {
		
		Car car1 = new Car(238954, "제네시스", "홍원일");
		Car car2 = new Car(238955, "BMW", "홍원일");
		Car car3 = new Car(238956, "벤츠", "홍원일");
		Car car4 = new Car(238957, "아우디", "홍원일");
		Car car5 = new Car(238958, "벤틀리", "홍원일");
		
		// ArrayList 사용
		ArrayList<Car> cargo = new ArrayList<>();
		
		// data추가
		cargo.add(car1);
		cargo.add(car2);
		cargo.add(car3);
		cargo.add(car4);
		cargo.add(car5);
		
		// data 꺼내기
		
		
		// data 삭제
		cargo.remove(0);
		
		for (Car car : cargo) {
			System.out.println(car);
		}
		
		// data 수정
		cargo.set(0, car5);
		System.out.println(cargo.size());
		System.out.println(cargo.isEmpty());
		
		cargo.removeAll(cargo);
		
		for (Car car : cargo) {
			System.out.println(car);
		}
	}

}

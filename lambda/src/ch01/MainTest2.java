package ch01;

public class MainTest2 {

	public static void main(String[] args) {

		ICalc iCalAdd = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a + b + c;
			}

		};

		ICalc iCalMinus = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a - b - c;
			}
		};

		ICalc iCalMulti = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a * b * c;
			}
		};

		System.out.println(iCalAdd.calc(1, 1, 1));
		System.out.println(iCalMinus.calc(1, 1, 1));
		System.out.println(iCalMulti.calc(1, 1, 1));
		
		// 문제 1 -> 람다 표현식으로 만들어서 사용해 주세요
		// 1
		
	}

}

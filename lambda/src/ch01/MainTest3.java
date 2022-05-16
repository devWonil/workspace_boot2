package ch01;

public class MainTest3 {

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
		ICalc iAddLambda = (x, y, z) -> {
			return x + y + z;
		};
		
		ICalc iMinusLambda = (x, y, z) -> {
			return x - y - z;
		};
		
		// 실행문이 한 문장인 경우 중괄호와 return 키워드를 생략할 수 있다
		ICalc iMultiLambda = (x, y, z) -> {
			return x * y * z;
		};
		
		System.out.println(iAddLambda.calc(1, 2, 3));
		System.out.println(iMinusLambda.calc(1, 2, 3));
		System.out.println(iMultiLambda.calc(1, 2, 3));
	}

}

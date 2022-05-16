package ch01_ex;

public class MainTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICalc iCalAdd = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				// TODO Auto-generated method stub
				return a + b + c;
			}
		};
		
		ICalc iCalMinus = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				// TODO Auto-generated method stub
				return a - b - c;
			}
		};
		
		ICalc iCalMulti = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				// TODO Auto-generated method stub
				return a * b * c;
			}
		};
		
		System.out.println(iCalAdd.calc(0, 0, 0));
		System.out.println(iCalMinus.calc(0, 0, 0));
		System.out.println(iCalMulti.calc(0, 0, 0));
		
		ICalc iAddLambda = (x, y, z) -> x + y + z;
		ICalc iMinusLambda = (x, y, z) -> x - y - z;
		ICalc iMultiLambda = (x, y, z) -> x * y * z;
		
		System.out.println(iAddLambda.calc(1, 2, 3));
		System.out.println(iMinusLambda.calc(1, 2, 3));
		System.out.println(iMultiLambda.calc(1, 2, 3));
	}

}

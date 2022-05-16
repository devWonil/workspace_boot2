package ch01_ex;

public class MainTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICalc iCalcAdd = new ICalc() {
			
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
		
		System.out.println(iCalcAdd.calc(1, 1, 1));
		System.out.println(iCalMinus.calc(1, 1, 1));
		System.out.println(iCalMulti.calc(1, 1, 1));
	}

}

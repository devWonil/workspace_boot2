package tenco.com.test_02;

public class WrapperClass1 {

	public static void main(String[] args) {
		
		Integer num = new Integer(100); // boxing
		Number n1 = 10;
		
		int n = num.intValue(); // unboxing
		System.out.println(n);
		System.out.println("----------");
		
		Integer num1 = 200; // 컴파일러가 자동 boxing (new Integer(200);)
		int num2 = num1; // 자동 unboxing (num1.intValue();)
	}

}

package ch02;

public class MainTest2 {

	public static void main(String[] args) {
		
		IMax iMax = (x , y) -> x > y ? x : y;
		System.out.println(iMax.maxN(100, 1000));
	}

}

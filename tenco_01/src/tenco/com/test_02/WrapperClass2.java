package tenco.com.test_02;

public class WrapperClass2 {

	public static void main(String[] args) {

		String str = "100ds";
		String str2 = "100.5";
		String str3 = "true";

		try {
			int i = Integer.parseInt(str);
			System.out.println("문자열 int 값 변환 : " + i);
		} catch (Exception e) {
			System.out.println("잘못된 데이터타입입니다");
		}

		try {
			double d = Double.parseDouble(str2);
			System.out.println("문자열 double 값 변환 : " + d);
		} catch (Exception e) {
			System.out.println("잘못된 데이터타입입니다");
		}

		try {
			boolean b = Boolean.parseBoolean(str3);
			System.out.println("문자열 boolean 값 변환 : " + b);
		} catch (Exception e) {
			System.out.println("잘못된 데이터타입입니다");
		}
		
		
		
		
		
	}
}

package ch03_ex;

public class StringConcatImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";
		String s2 = "Java";
		
		// oop 방식
		StringConcatImpl impl = new StringConcatImpl();
		impl.makeString(s1, s2);
		
		// 익명 구현 클래스 활용
		IStringConcat iStringConcat = new IStringConcat() {

			@Override
			public void makeString(String s1, String s2) {
				// TODO Auto-generated method stub
				System.out.println("[[[" + s1 + " : " + s2 + "]]]");
			}
			
		};
		// 클래스 설계없이 바로 사용가능한 람다 표현식
		IStringConcat iStringConcat2 = (s3, s4) -> {
			System.out.println("..." + s3 + " : " + s4 + "...");
		};
		iStringConcat.makeString(s1, s2);
		iStringConcat2.makeString(s1, s2);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}

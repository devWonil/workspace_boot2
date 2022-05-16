package ch03;

public class StringConcatImplTest {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "Java";
		
		// OOP 방식
		StringConcatImpl impl = new StringConcatImpl();
		impl.makeString(s1, s2);
		
		// 익명 구현 클래스 활용
		IStringConcat iStringConcat = new IStringConcat() {
			
			@Override
			public void makeString(String s1, String s2) {
				System.out.println("[[[" + s1 + " : " + s2 +"]]]");
			}
		};
		// 클래스 설계없이 바로 사용 가능
		
		// 람다 표현식으로 설계해서 사용해주세요
		IStringConcat iStringConcat2 = (s3, s4) -> {
			System.out.println("..." + s3 + " : " + s4 +"...");
		};
		iStringConcat.makeString(s1, s2);
		iStringConcat2.makeString(s1, s2);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		})
		{
			
		};
	}

}

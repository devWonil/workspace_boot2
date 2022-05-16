package ch01_ex;

public class MainTest1 {

	public static void main(String[] args) {
		// 익명 구현 클래스
		IAdd iAdd = new IAdd() {
			
			@Override
			public int add(int x, int y) {
				// TODO Auto-generated method stub
				return x + y;
			}
		};
		
		// 사용방법
		System.out.println(iAdd.add(10, 20));
		
		// 람다식으로 변경하면
		// 타입추론이 가능하다
		IAdd iAddLamda = (x, y) -> x + y;
		
		System.out.println(iAddLamda.add(10, 10));
	}

}

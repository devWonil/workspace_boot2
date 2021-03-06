package ch08;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		
		Book book1 = new Book(1, "흐르는 강물처럼", "파울로코엘료");
		Book book2 = new Book(2, "플러터UI실전", "김근호");
		Book book3 = new Book(3, "무궁화꽃이피었습니다", "김진명");
		Book book4 = new Book(4, "리딩으로리드하라", "이진성");
		Book book5 = new Book(5, "사피엔스", "유발하라리");
		
		// how , why
		
		// 사용방법 (어떠한 데이터 타입을 담을지 미리 지정해 준다)
		ArrayList<Book> cart = new ArrayList<>();
		
		// 데이터를 추가하는 방법 1 add 메소드
		cart.add(book1);
		cart.add(book2);
		cart.add(book3);
		
		// 데이터를 꺼내는 방법
//		System.out.println(cart.get(0).getTitle());
//		System.out.println(cart.get(1).getTitle());
//		System.out.println(cart.get(2).getTitle());
		
		// 데이터를 꺼내는 방법 get 메소드
//		System.out.println(cart.get(0));
//		System.out.println(cart.get(1));
//		System.out.println(cart.get(2));
		
		for (Book book : cart) {
			System.out.println(book);
		}
		
		// 데이터를 삭제하는 방법
		cart.remove(0);
		
		// 사이즈 출력
		System.out.println(cart.size());
		System.out.println("-------");
		System.out.println(cart.get(0));
		
		// 수정하기
		cart.set(0, book5);
		System.out.println(cart.size());
		System.out.println(cart.isEmpty());
		
		for (Book book : cart) {
			System.out.println(book);
		}
		
		// 데이터를 전부 삭제하고 싶다면
		cart.removeAll(cart);
		System.out.println("--------");
		for (Book book : cart) {
			System.out.println(book);
		}
		
		// C R U D
	}

}

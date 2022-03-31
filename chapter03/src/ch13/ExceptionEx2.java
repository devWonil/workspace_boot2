package ch13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx2 {

	public static void main(String[] args) {
		
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("b.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("파일없음");
		}finally {
			System.out.println("반드시 실행되는 영역입니다");
		}
		System.out.println("코드가 실행이 되면 이 문구가 나옵니다");
	}

}

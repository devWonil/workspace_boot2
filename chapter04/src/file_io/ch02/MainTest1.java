package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * @author ITPS
 * 입력 스트림
 * 파일에서 한 바이트씩 데이터를 읽기 - 1
 * */
public class MainTest1 {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("boot_a.txt");
			System.out.println((char)fis.read()); //97
			System.out.println((char)fis.read()); //98
			System.out.println((char)fis.read()); //99
			System.out.println((char)fis.read()); //-1
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

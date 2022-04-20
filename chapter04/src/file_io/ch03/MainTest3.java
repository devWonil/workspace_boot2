package file_io.ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
 * @author ITPS
 * 바이트 단위 출력
 * 파일에 한 바이트씩 쓰기
 * byte[] 배열 A-Z 까지 넣고
 * 한꺼번에 파일에 쓰기 -2
 * */

// D - X 까지만 파일에 쓰기
public class MainTest3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("output_c.txt", true);
		
		try(fos) {
		
			byte[] bs = new byte[21];
			byte data = 68; // D
			// 배열 D ~ X 까지 데이터를 담는다
			for(int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			// 배열에 담겨 있는 데이터를 한꺼번에 출력
			fos.write(bs);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(">>>> 출력처리가 끝 <<<<");
	}

}

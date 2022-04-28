package ch01_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpMainTest1 {

	public static void main(String[] args) {
		
		try {
			// 준비물1
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/20");
			// 준비물2
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 부가적인 정보를 추가해서 보내기
			connection.setRequestMethod("GET");
			connection.connect();
			
			int statusCode = connection.getResponseCode();
			System.out.println("statusCode : " + statusCode); //200
			
			// http 통신할 때 스트림을 달아야함
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String line = null;
			
			if(statusCode == 200) {
				while((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}
			
			String str = sb.toString();
			System.out.println(str);
			System.out.println("---------------------");
			System.out.println(str.substring(5, 11));
			System.out.println(str.substring(14, 15));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

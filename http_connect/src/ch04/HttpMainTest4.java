package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import ch05.Yts;

public class HttpMainTest4 {

	public static void main(String[] args) {
		
		try {
			// 준비물1
			URL url = new URL("https://yts.mx/api/v2/list_movies.json");
			// 준비물2
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 부가적인 정보를 추가해서 보내기
			connection.setRequestMethod("GET");
			connection.connect();
			
			int statusCode = connection.getResponseCode();
//			System.out.println("statusCode : " + statusCode); //200
			
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
			// 
			//Post post = new Gson().fromJson(str, Post.class);
			System.out.println(str);
			
			Yts yts = new Gson().fromJson(str, Yts.class);
			System.out.println(yts.getData().getMovieCount());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Todo1;

public class HttpMainTest3 {

	public static void main(String[] args) {
		
		try {
			// 준비물1
			URL url = new URL("https://jsonplaceholder.typicode.com/todos");
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
			
			// 파싱처리 해라
			Type todo1ListType = new TypeToken<ArrayList<Todo1>>() {}.getType();
			ArrayList<Todo1> arrayList = new Gson().fromJson(str, todo1ListType);
			for (Todo1 todo1 : arrayList) {
				System.out.println(todo1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

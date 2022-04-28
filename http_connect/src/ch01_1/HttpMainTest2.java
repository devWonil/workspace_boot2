package ch01_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dto.Post;

public class HttpMainTest2 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/20");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); // REST API
			
			connection.connect();
			
			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			StringBuffer buffer = new StringBuffer();
			String line = null;
			
			if(statusCode == 200) {
				while((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			}else if(statusCode == 404) {
				System.out.println("요청한 페이지를 찾을 수 없습니다");
			}
			
			String str = buffer.toString();
			System.out.println(str);
			System.out.println("-------------------------");
			
			Post post = new Post();
			
			System.out.println(str.substring(4,10));
			System.out.println(str.substring(18,20));
			System.out.println(str.substring(29,34));
			System.out.println(str.substring(38,72));
			System.out.println(str.substring(77,81));
			System.out.println(str.substring(85,301));
			
			post.userId = Integer.parseInt(str.substring(13, 14));
			System.out.println(post.userId);
			
			post.id = Integer.parseInt(str.substring(23, 25));
			System.out.println(post.id);
			
			post.title = str.substring(38,72);
			System.out.println(post.title);
			
			post.body = str.substring(85,301);
			System.out.println(post.body);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

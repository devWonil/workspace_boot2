package ch02;

import com.google.gson.JsonObject;

public class MainTest2 {

	public static void main(String[] args) {
		
		JsonObject jo1 = new JsonObject();
		
		jo1.addProperty("이름", "홍원일");
		jo1.addProperty("나이", 11);
		jo1.addProperty("직업", "무직");
		jo1.addProperty("취미", "음악감상");
		jo1.addProperty("혼인유무", false);
		
		JsonObject a = jo1;
		a.addProperty("안녕", "hi");
		System.out.println(jo1);
	}

}

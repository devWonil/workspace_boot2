package ch03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Person;

public class MainTest {

	public static void main(String[] args) {
		// 문제1
		JsonArray ja1 = new JsonArray(); 
		
		JsonObject jo1 = new JsonObject();
		JsonObject jo2 = new JsonObject();
		JsonObject jo3 = new JsonObject();
		
		jo1.addProperty("name", "홍길동");
		jo1.addProperty("age", 20);
		jo1.addProperty("address", "부산");
		
		jo2.addProperty("name", "이순신");
		jo2.addProperty("age", 33);
		jo2.addProperty("address", "서울");
		
		jo3.addProperty("name", "세종대왕");
		jo3.addProperty("age", 59);
		jo3.addProperty("address", "세종");
		
		JsonObject a = jo1;
		JsonObject b = jo2;
		JsonObject c = jo3;
		
		ja1.add(a);
		ja1.add(b);
		ja1.add(c);
		System.out.println(ja1);
		
		Gson gson = new Gson();
		Person person = gson.fromJson(ja1.get(0), Person.class);
		
		System.out.println(person);
		
		//문제2
		JsonObject jo6 = new JsonObject();
		JsonArray ja3 = new JsonArray();
		
		JsonObject jo4 = new JsonObject();
		JsonObject jo5 = new JsonObject();
		
		jo4.addProperty("id", 1);
		jo4.addProperty("title", "청소");
		jo4.addProperty("complete", false);
		
		jo5.addProperty("id", 2);
		jo5.addProperty("title", "영어공부");
		jo5.addProperty("complete", true);
		
		JsonObject d = jo4;
		JsonObject e = jo5;
		
		ja3.add(d);
		ja3.add(e);
		
		jo6.add("todoList", ja3);
		jo6.addProperty("server_name","server_1");
		
		System.out.println(jo6);
	}

}

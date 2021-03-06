package ch03;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest4 {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		Student[] students = new Student[3];
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 20, "서울");
		Student student3 = new Student("세종대왕", 20, "세종");
		
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		
		String studentArr = gson.toJson(students);
		System.out.println(studentArr);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		String jsonArrayStr = gson.toJson(list);
		Type studentType = new TypeToken<ArrayList<Student>>() {}.getType();
		
		ArrayList<Student> arrayList = gson.fromJson(jsonArrayStr, studentType);
		for (Student student : arrayList) {
			System.out.println(student);
		}
	}
}

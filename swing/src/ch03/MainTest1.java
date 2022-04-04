package ch03;

import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) {
		// 1. MyComponent 화면에 띄우세요
		MyComponents myComponents = new MyComponents();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("글자를 입력하세요");
		String userInput = scn.nextLine();
		// 2. textField 안녕하세요 라는 글자를 코드로 셋팅
		myComponents.jTextField.setText(userInput);
		
		scn.close();
	}
	
	
}

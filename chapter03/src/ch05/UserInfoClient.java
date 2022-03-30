package ch05;

import java.util.Scanner;

public class UserInfoClient {

	public static final String MYSQL = "mysql";
	public static final String MYORACLE = "myoracle";

	public static void main(String[] args) {
		
		// UserInfo 스캐너로 받아서 흐름을 만들어주세요
		Scanner scn = new Scanner(System.in);
		
		// 사용자에게 userInfo 정보 받는다
		UserInfo info = new UserInfo();
		
//		info.setUserId("devWonil");
//		info.setPassword("qwer123!");
//		info.setUserName("홍길동");
		System.out.print("ID를 입력하세요 : ");
		info.setUserId(scn.nextLine());
		
		System.out.print("비밀번호를 입력하세요 : ");
		info.setPassword(scn.nextLine());

		System.out.print("이름를 입력하세요 : ");
		info.setUserName(scn.nextLine());
		// 인터페이스 활용
		
		// 1. A
//		UserInfoMySqlDao mySqlDao = new UserInfoMySqlDao();
//		mySqlDao.inserUserInfo(info);
		
		// 2. B
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.inserUserInfo(info);
		String str = scn.nextLine();
		
		// equls는 문자열의 값을 비교합니다
		// == 객체의 주소값을 비교합니다
		// 문자열을 비교 할때는 무조건 equals라는 것을 사용한다
//		if("mysql".equals(MYSQL)) {
//		if(str == MYSQL) {
//			System.out.println("문자열이 같습니다");
//		}else {
//			System.out.println("문자열이 다릅니다");
//		} // 문자열이 다릅니다 출력
		
		// 1. mysql 문자열이면 --> UserInfoMySqlDao 동작
		
		// 2. oracle 문자열이면 --> UserIngoOracleDao 동작
		
		UserInfoDao userInfoDao;
		
		if(str.equals(MYSQL)) {
			userInfoDao = new UserInfoMySqlDao();
		}
		else {
			userInfoDao = new UserInfoOracleDao();
		}
		
		userInfoDao.insertUserInfo(info);
		// 단, 다형성을 사용해서
	}
}

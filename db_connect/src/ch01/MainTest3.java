package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest3 {

	// DB 서버와 연결하기 위한 준비물
	private Connection conn; // DB 커넥션 연결객체
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt; // String --> 쿼리구문으로 변경해줌
	private ResultSet rs; // 결과값을 받아줌

	// 생성자
	public MainTest3() {

		try {
			// reflection 기법 : 컴파일 시점 문자열 -> 런타임 시점에 실제 클래스가 존재하는지 확인
			// 메모리 (heap) 영역에 올라간다
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();

			String sql3 = "select * from producttbl";
			rs = stmt.executeQuery(sql3);

			while(rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				String cost = rs.getString("cost");
				String company = rs.getString("company");
				String amount = rs.getString("amount");
				System.out.println("상품ID : " + productId + ", 상품명 : " + productName + ", 가격  : " + cost + ", 제조사  : " + company + ", 수량 : " + amount);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 코드의 시작점
	public static void main(String[] args) {
		new MainTest3();
	} // end of main

}

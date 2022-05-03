package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest3_1 {

	// DB 서버와 연결하기 위한 준비물
	private Connection connection;
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
	
	private Statement statement; //String -> 쿼리문으로 변경해줌
	private ResultSet resultSet; // 결과값을 받아줌
	
	//생성자
	public MainTest3_1() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			
			String sql = "select * from producttbl";
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				String productId = resultSet.getString("productId");
				String productName = resultSet.getString("productName");
				String cost = resultSet.getString("cost");
				String company = resultSet.getString("company");
				String amount = resultSet.getString("amount");
				System.out.println("상품ID : " + productId + ", 상품명 : " + productName + ", 가격  : " + cost + ", 제조사  : " + company + ", 수량 : " + amount);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MainTest3_1();
	}

}

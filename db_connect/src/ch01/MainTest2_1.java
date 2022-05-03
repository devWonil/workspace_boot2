package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest2_1 {

	// DB 서버와 연결하기 위한 준비물
	private Connection connection; // DB 커넥션 연결객체
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
	
	private Statement statement;
	private ResultSet resultSet;
	
	// 생성자
	public MainTest2_1() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			
			String sql = "select * from buytbl";
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				String userName = resultSet.getString("userName");
				String prodName = resultSet.getString("prodName");
				String price = resultSet.getString("price");
				String amount = resultSet.getString("amount");
				System.out.println("고객 이름 : " + userName + ", 상품명 : " + prodName + ", 가격 : " + price + ", 수량 : " + amount);
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
		new MainTest2_1();
	}

}

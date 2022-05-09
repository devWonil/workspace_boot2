package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Data;

@Data
public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "employees";
	private static final String DB_USER_NAME = "root";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_PASSWORD = "asd123";
	
	//
	private Connection conn;
	
	// 싱글톤 처리
	private static DBClient dbClient;
	
	public DBClient() {
		
	}
	
	public static DBClient getInstance() {
		if(dbClient == null) {
			dbClient = new DBClient();
		}
		return dbClient;
	}
	
	public Connection getConnection() {
		if(conn == null) {
			// "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);
			
			// MySQL JDBC 드라이버 클래스를 로딩해서 DriverManager 클래스에 등록한다
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// DriverManager 객체를 사용하여 DB에 접근
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");
				
			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	private void connectionClose() {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}

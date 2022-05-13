package ch06.dbDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "movie";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";
	
	private Connection conn;
	
	private static DBClient client;
	
	private DBClient() {}
	
	public static DBClient getInstance() { 
		if(client == null) {
			client = new DBClient();
		}
		return client;
	}
	
	public Connection getConnection() {
		if(conn == null) {
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST,DB_PORT, DB_DATABASE_NAME,DB_CHARSET);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// DriverManager 객체를 사용하여 DB서버에 접근 할수있다.
				conn = DriverManager.getConnection(url, DB_USER_NAME,DB_PASSWORD); // 커넥션 녀석에 url이랑 데이터베이스 이름 패스워드가 담겼다
				System.out.println("!!!Connection Success!!!");
				
			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return conn;
	}
	public void connectionClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
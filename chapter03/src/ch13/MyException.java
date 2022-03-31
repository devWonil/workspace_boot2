package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyException {

	String fileName;
	
	public MyException(String fileName) {
		this.fileName = fileName;
	}
	
	public String readFile() throws IOException{
		
		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis);
		String dbType = properties.getProperty("DBTYPE");
		
		return dbType;
	}
	
	public static void main(String[] args) {
		
		String dbType = null;
		MyException myException = new MyException("b.txt");
		
		try {
			dbType = myException.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("결과값 : " + dbType);
	} // end of main
	
}

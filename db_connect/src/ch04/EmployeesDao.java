package ch04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;

public class EmployeesDao implements IEmployees{

	private DBClient dbClient;
	private Connection conn;
	
	public EmployeesDao() {
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	}
	
	@Override
	public ArrayList<EmployeesDto> innerJoin1() {
		
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from employees as e "
				+ "inner join dept_emp as d "
				+ "on e.emp_no = d.emp_no ";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				EmployeesDto dto = new EmployeesDto();
				
				System.out.print(rs.getInt("emp_no"));
				System.out.print("\t");
				System.out.print(rs.getString("birth_date"));
				System.out.print("\t");
				System.out.print(rs.getString("first_name"));
				System.out.print("\t");
				System.out.print(rs.getString("last_name"));
				System.out.print("\t");
				System.out.print(rs.getString("gender"));
				System.out.print("\t");
				System.out.print(rs.getString("hire_date"));
				System.out.print("\t");
				System.out.print(rs.getString("dept_no"));
				System.out.print("\t");
				System.out.print(rs.getString("from_date"));
				System.out.print("\t");
				System.out.println(rs.getString("to_date"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------------------------");
		return dataResult;
	}
	
	public static void main(String[] args) {
		EmployeesDao employeesDao = new EmployeesDao();
		ArrayList<EmployeesDto> list = employeesDao.innerJoin1();
	}
}

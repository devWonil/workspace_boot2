package ch04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	@Override
	public ArrayList<EmployeesDto> innerJoin2() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from departments as a "
				+ "inner join dept_emp as b "
				+ "on a.dept_no = b.dept_no "; 

		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				EmployeesDto dto = new EmployeesDto();
				
				System.out.print(rs.getString("dept_no"));
				System.out.print("\t");
				System.out.print(rs.getString("dept_name"));
				System.out.print("\t");
				System.out.print(rs.getInt("emp_no"));
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

	@Override
	public ArrayList<EmployeesDto> leftJoin1() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from dept_manager as a "
				+ "left join dept_emp as b "
				+ "on a.emp_no = b.emp_no ";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				EmployeesDto dto = new EmployeesDto();
				
				System.out.print(rs.getInt("emp_no"));
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

	@Override
	public ArrayList<EmployeesDto> leftJoin2() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from employees as e "
				+ "left join titles as t "
				+ "on e.emp_no = t.emp_no ";
		
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
				System.out.print(rs.getString("title"));
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

	@Override
	public ArrayList<EmployeesDto> rightJoin() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from employees as e "
				+ "right join salaries as s "
				+ "on e.emp_no = s.emp_no ";
		
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
				System.out.print(rs.getInt("salary"));
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
		// ????????? 
		// swing 
		// ??? ???????????? 
		// ????????? 
		
		ArrayList<EmployeesDto> list1 = employeesDao.innerJoin1();
		ArrayList<EmployeesDto> list2 = employeesDao.innerJoin2();
		ArrayList<EmployeesDto> list3 = employeesDao.leftJoin1();
		ArrayList<EmployeesDto> list4 = employeesDao.leftJoin2();
		ArrayList<EmployeesDto> list5 = employeesDao.rightJoin();
	}
}

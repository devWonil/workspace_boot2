package ch05;

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
	
	// 개발팀 manager 중 2000년 1월 1일 이전 퇴사자
	@Override
	public ArrayList<EmployeesDto> nestedSubQuery1() {
		
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from employees as e "
				+ "where e.emp_no = (select emp_no "
				+ "					from dept_manager "
				+ "                    where to_date < '2000-01-01' and dept_no = (select dept_no "
				+ "																from departments "
				+ "																where dept_name = 'development'))";
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
				System.out.println(rs.getString("hire_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------------------------");
		return dataResult;
	}

	// 직급이 Senior Engineer 인 직원의 정보만 출력하기
	@Override
	public ArrayList<EmployeesDto> nestedSubQuery2() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from employees "
				+ "where emp_no in (select emp_no "
				+ "                    from titles "
				+ "                    where title = 'Senior Engineer') ";
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
				System.out.println(rs.getString("hire_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------------------------");
		return dataResult;
	}
	
	// 직원 테이블에서 2000년 1월 1일 이전 퇴사한 부서 팀장만 출력
	@Override
	public ArrayList<EmployeesDto> inlineView() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select * "
				+ "from employees as e, (select * "
				+ "						from dept_manager "
				+ "                        where to_date < '2000-01-01') as b "
				+ "where e.emp_no = b.emp_no ";
		
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

	// 직원 테이블에서 emp_no, first_name 출력하고 알맞은 부서번호 dept_emp 테이블에서 출력
	@Override
	public ArrayList<EmployeesDto> scalarSubQuery1() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select e.emp_no, e.first_name, (select d.dept_no "
				+ "								from dept_emp as d "
				+ "								where e.emp_no = d.emp_no "
				+ "                                group by emp_no) as 부서번호 "
				+ "from employees as e ";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				EmployeesDto dto = new EmployeesDto();
				
				System.out.print(rs.getInt("emp_no"));
				System.out.print("\t");
				System.out.print(rs.getString("first_name"));
				System.out.print("\t");
				System.out.println(rs.getString("부서번호"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------------------------");
		return dataResult;
	}

	//스칼라 서브쿼리 (직원 평균연봉)
	@Override
	public ArrayList<EmployeesDto> scalarSubQuery2() {
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		String sql = "select *, (select avg(s.salary) "
				+ "			from salaries as s "
				+ "            where e.emp_no = s.emp_no "
				+ "            group by emp_no) as 평균연봉 "
				+ "from employees as e ";
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
				System.out.println(rs.getDouble("평균연봉"));
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
		ArrayList<EmployeesDto> list1 = employeesDao.nestedSubQuery1();
		ArrayList<EmployeesDto> list2 = employeesDao.nestedSubQuery2();
		ArrayList<EmployeesDto> list3 = employeesDao.inlineView();
		ArrayList<EmployeesDto> list4 = employeesDao.scalarSubQuery1();
		ArrayList<EmployeesDto> list5 = employeesDao.scalarSubQuery2();
	}
}

package ch04;

import java.util.ArrayList;

public interface IEmployees {

	// employees, dept_emp 결과 *
	ArrayList<EmployeesDto> innerJoin1();
	ArrayList<EmployeesDto> innerJoin2();
	ArrayList<EmployeesDto> leftJoin1();
	ArrayList<EmployeesDto> leftJoin2();
	ArrayList<EmployeesDto> rightJoin();
}

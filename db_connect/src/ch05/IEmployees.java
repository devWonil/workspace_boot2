package ch05;

import java.util.ArrayList;

public interface IEmployees {

	ArrayList<EmployeesDto> nestedSubQuery1();
	ArrayList<EmployeesDto> nestedSubQuery2();
	ArrayList<EmployeesDto> inlineView();
	ArrayList<EmployeesDto> scalarSubQuery1();
	ArrayList<EmployeesDto> scalarSubQuery2();
}

package ch04_2;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		EmployeesDao employeesDao = new EmployeesDao();
		ArrayList<EmployeesDto> data;
		
		data = employeesDao.showTitleEmpInfo("Engineer");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		
		data = employeesDao.showManagerInfo("Marketing");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		
		// Mary가 연봉 받은 횟수
		System.out.println(employeesDao.showSalaryCount("Mary", "Sluis"));
		
		// Engineer 직함의 현재 직원 수
		System.out.println("Engineer 직원 수 : " + employeesDao.showTitleEmpNumber("Engineer") + "명");
		
		// Gergi Facello가 최근에 받은 연봉
		System.out.println(employeesDao.showSalary("Georgi", "Facello"));
	}

}

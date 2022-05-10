package ch05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesDto {

	@NonNull
	private String dept_no;
	private String dept_name;
	private int emp_no;
	private String from_date;
	private String to_date;
	private String birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private String hire_date;
	private String title;
	private int salary;
}

package dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Person {

	String name;
	int age;
	String address;
	
	class Todos {
		
	}
}

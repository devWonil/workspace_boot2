package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Todo1 {

	int userId;
	int id;
	String title;
	boolean completed;
}

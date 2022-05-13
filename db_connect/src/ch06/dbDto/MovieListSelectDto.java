package ch06.dbDto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieListSelectDto {
	
	private String movieName;
	private Date year;
	private String role_actor;
	private double starRating;
	
}

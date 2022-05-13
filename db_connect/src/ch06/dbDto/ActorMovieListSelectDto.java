package ch06.dbDto;

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
public class ActorMovieListSelectDto {

	private String actorName;
	private String movieName;
	private String role;
	private String roleName;
		
}

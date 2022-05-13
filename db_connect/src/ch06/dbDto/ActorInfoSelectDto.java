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
public class ActorInfoSelectDto {

	private String actorName;
	private int actorYear;
	private int height;
	private int weight;
	private String spouse;
	
}

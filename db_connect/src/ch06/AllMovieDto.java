package ch06;

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
public class AllMovieDto {
	
	private int movieNumber;
	
	private String movieName;
	// 개봉년도
	private int year;
	// 매출액
	private int sales;
	// 관객수
	private int audience;
	// 평점
	private double rating;
	
}

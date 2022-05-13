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
public class AllMovieDto {
	
	private int movieNumber;
	
	private String movieName;
	// 개봉년도
	private String year;
	// 매출액
	private long sales;
	// 관객수
	private int audience;
	// 스크린수
	private int screen;
	// 평점
	private double rating;
	
}

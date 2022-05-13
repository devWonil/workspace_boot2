package ch06;

import lombok.Data;

@Data
public class InsertMovieDto {
	private int movieNumber;
	private String movieName;
	private String releasedDate;
	private long revenue;
	private int audience;
	private int screen;
	private double starRating;
}
package ch06.dbInterface;

public interface Iinsert {
	
	/*
	 * 
	 * int movieNumber, String movieName, String releasedDate, long revenue, int audience, int screen, double starRating
	 * 
	 * clss Moview
	 * requestMoviewDto
	 * responseMoview
	 * */
	//영화추가
//	void insertMovie(InsertMovieDto insertMovieDto);
	
	void insertMovie(int movieNumber, String movieName, String releasedDate, long revenue, int audience, int screen, double starRating);
	//배우추가
	void insertActor(int actorNumber, String actor, int birthYear, double height, double weight, String spouse);
	//영화금액 추가
	void insertMoviePrice(int movieNumber, long productionCost, long sales, long revenue, int ticketPrice);
	//출연 추가
	void insertrole(int movieNumber, int actorNumber, String role, String roleName);
	
}

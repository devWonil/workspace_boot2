package ch06.dbInterface;

public interface IUpdate {
	
	// 영화 이름 수정
	void movieNameUpdate(String movieName, int movieNumber);
	// 영화 평점 수정
	void movieratingUpdate(double starRating, int movieNumber);
	// 영화 개봉년도 수정
	void movieYearUpdate(String releasedDate, int movieNumber);
	// 영화 매출액 수정
	void movieRevenueUpdate(long revenue, int movieNumber);
	// 영와 스크린 수정
	void movieScreenUpdate(int screen, int movieNumber);
	// 영화 관객수 수정
	void movieAudienceUpdate(int audience, int movieNumber);
	
	
	//배우 이름 수정
	void actorNameUpdate(String actor, int atorNumber);
	// 배우 출생 수정
	void actorYearUpdate(int birthYear, int atorNumber);
	// 배우 키 수정
	void actorHeightUpdate(double height, int atorNumber);
	// 배우 몸무게 수정
	void actorWeightUpdate(double weight, int atorNumber);
	// 배우 배우자 수정
	void actorSpouseUpdate(String spouse, int atorNumber);
	
	//cost 수정
	// prodcost 수정
	void costProdCost(long prodCost, int movieNuber);
	// sales수정
	void costSales(long sales, int movieNuber);
	// Revenue
	void costRevenue(long revenue, int movieNuber);
	// ticketprice수정
	void costPriceUpdate(int price, int movieNuber);
	
	// 출연쪽 배우 번호 수정
	void AppearActorNumUpdate(int actorNumber, String roleName, int movieNumber);
	// 출연쪽 영화 번호 수정
	void AppearMoiveNumUpdate(int movieNumber, String roleName, int actorNumber);
	// 출연쪽 한숫자의 영화번호를 전부 수정
	void AppearMovieNumAllUpdate(int setmovieNumber, int movieNumber);
	// 출연쪽 배우의 출연 수정
	void AppearRoleUpdate(String role, String roleName, int actorNumber);
	// 출연쪽 배우의 출연이름 수정
	void AppearRoluNameUpdate(String roleName, int movieNumber, int actorNumber);
	
}

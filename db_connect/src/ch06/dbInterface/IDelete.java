package ch06.dbInterface;

public interface IDelete {
	
	// 출연쪽 삭제
	void RoleDelete1(int movieNumber, int actorNumber);
	// 영화 삭제
	void movieDelete(int movieNumber);
	// 배우 삭제
	void actorDelete(int actorNumber);
	// 영화금액 삭제
	void moviePriceDelete(int movieNumber);
	
}
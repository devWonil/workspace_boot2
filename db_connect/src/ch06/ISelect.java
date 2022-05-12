package ch06;

import java.util.ArrayList;

public interface ISelect {

	//모든 영화 리스트 출력
	void AllMovieList();
	// 영화에대한 정보리스트 출력 OK
	ArrayList<MovieListSelectDto> movieList(String movieName);
	// 영화티켓 금액 출력 OK
	ArrayList<MovieTicketPriceDto> movieTicketPrice(String movieName);
	//모든 배우 리스트 출력
	ArrayList<AllactorListDto> AllActorInfo();
	// 배우에대한 정보리스트 출력 OK
	ArrayList<ActorInfoSelectDto> actorInfo(String actorName);
	// 배우가 찍은 영화 리스트 출력 OK
	ArrayList<ActorMovieListSelect> actorMovieList(String actorName);
	
	// 
	ArrayList<AllMovieDto> movieInfo1(String movieName);
	ArrayList<AllMovieDto> movieInfo2(int movieYear);
}

package ch06.dbInterface;

import java.util.ArrayList;

import ch06.dbDto.ActorInfoSelectDto;
import ch06.dbDto.ActorMovieListSelectDto;
import ch06.dbDto.AllMovieDto;
import ch06.dbDto.AllactorListDto;
import ch06.dbDto.MovieListSelectDto;
import ch06.dbDto.MovieTicketPriceDto;
import ch06.dbDto.RoleDto;

public interface ISelect {

	
	
	// 영화에대한 정보리스트 출력 OK
	ArrayList<MovieListSelectDto> movieList(String movieName);
	// 영화티켓 금액 출력 OK
	ArrayList<MovieTicketPriceDto> movieTicketPrice(String movieName);
	//모든 배우 리스트 출력
	ArrayList<AllactorListDto> AllActorInfo();
	// 배우에대한 정보리스트 출력 OK
	ArrayList<ActorInfoSelectDto> actorInfo(String actorName);
	// 배우가 찍은 영화 리스트 출력 OK
	ArrayList<ActorMovieListSelectDto> actorMovieList(String actorName);
	
	// 모든role 리스트 출력
	ArrayList<RoleDto> roleList1(int movieNumber);
	ArrayList<RoleDto> roleList2(int actorNumber);

	// 모든 영화 리스트 출력
	ArrayList<AllMovieDto> movieInfo1(String movieName);
	ArrayList<AllMovieDto> movieInfo2(String movieYear);
}


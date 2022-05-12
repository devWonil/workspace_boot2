package ch06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SelectDao implements ISelect{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null;

	@Override
	public ArrayList<MovieListSelectDto> movieList(String movieName) {
		// 영화정보의 영화이름으로 영화정보 출력 (영화이름,개봉년도,역할: 배우, 평점)
		ArrayList<MovieListSelectDto> movieList = new ArrayList<MovieListSelectDto>();
		try {
			String movieList1 = "SELECT b.이름, b.개봉년도, CONCAT_WS(':', a.역할, c.배우) AS '주연배우', b.평점\r\n"
					+ "FROM 출연 as a\r\n"
					+ "INNER JOIN 영화정보 AS b\r\n"
					+ "ON a.영화번호 = b.영화번호\r\n"
					+ "INNER JOIN 배우정보 AS c\r\n"
					+ "ON a.배우번호 = c.배우번호\r\n"
					+ "WHERE b.이름 = ?\r\n"
					+ "AND a.역할 = '주연'\r\n"
					+ "GROUP BY a.영화번호";
			PreparedStatement preparedStatement = connection.prepareStatement(movieList1);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				MovieListSelectDto movieListSelectDto = new MovieListSelectDto();
				movieListSelectDto.setMovieName(resultSet.getString("이름"));
				movieListSelectDto.setYear(resultSet.getInt("개봉년도"));
				movieListSelectDto.setRole_actor(resultSet.getString("주연배우"));
				movieListSelectDto.setRating(resultSet.getDouble("평점"));
//				System.out.println("movieName : " + resultSet.getString("이름"));
//				System.out.println("year : " + resultSet.getString("개봉년도"));
//				System.out.println("actor : " + resultSet.getString("주연배우"));
//				System.out.println("rating : " + resultSet.getString("평점"));
				movieList.add(movieListSelectDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
				
	}

	@Override
	public ArrayList<MovieTicketPriceDto> movieTicketPrice(String movieName) {
		ArrayList<MovieTicketPriceDto> ticketPrice = new ArrayList<MovieTicketPriceDto>();
		try {
			String movieTicketPrice1 = "SELECT a.이름, b.영화표금액\r\n"
					+ " FROM 영화정보 as a\r\n"
					+ " INNER JOIN 영화금액 as b\r\n"
					+ " ON a.영화번호 = b.영화번호\r\n"
					+ " WHERE a.이름 = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieTicketPrice1);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				MovieTicketPriceDto movieTicketPriceDto = new MovieTicketPriceDto();
				movieTicketPriceDto.setMovieName(resultSet.getString("이름"));
				movieTicketPriceDto.setPrice(resultSet.getInt("영화표금액"));
//				System.out.println("movieName : " + resultSet.getString("이름"));
//				System.out.println("ticketPrice : " + resultSet.getString("영화표금액"));
			ticketPrice.add(movieTicketPriceDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketPrice;
		
	}

	@Override
	public ArrayList<ActorInfoSelectDto> actorInfo(String actorName) {
		ArrayList<ActorInfoSelectDto> actorInfoSelect = new ArrayList<ActorInfoSelectDto>();
		try {
			String actorInfo1 = "SELECT 배우, 출연자출생, 키, 몸무게, 배우자 \r\n"
					+ "FROM 배우정보\r\n"
					+ "WHERE 배우 = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(actorInfo1);
			preparedStatement.setString(1, actorName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ActorInfoSelectDto actorInfoSelectDto = new ActorInfoSelectDto();
				actorInfoSelectDto.setActorName(resultSet.getString("배우"));
				actorInfoSelectDto.setActorYear(resultSet.getInt("출연자출생"));
				actorInfoSelectDto.setHeight(resultSet.getInt("키"));
				actorInfoSelectDto.setWeight(resultSet.getInt("몸무게"));
				actorInfoSelectDto.setSpouse(resultSet.getString("배우"));
//				System.out.println("movieName : " + resultSet.getString("배우"));
//				System.out.println("actoryear : " + resultSet.getString("출연자출생"));
//				System.out.println("height : " + resultSet.getString("키"));
//				System.out.println("wieght : " + resultSet.getString("몸무게"));
//				System.out.println("spouse: " + resultSet.getString("배우자"));
			
			actorInfoSelect.add(actorInfoSelectDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actorInfoSelect;
	}

	@Override
	public ArrayList<ActorMovieListSelect> actorMovieList(String actorName) {
		ArrayList<ActorMovieListSelect> actorMovieList = new ArrayList<ActorMovieListSelect>();
		try {
			String actorMovieList1 = "SELECT c.배우, b.이름, a.역할, a.역할명\r\n"
					+ "FROM 출연 as a\r\n"
					+ "INNER JOIN 영화정보 as b\r\n"
					+ "ON a.영화번호 = b.영화번호\r\n"
					+ "INNER JOIN 배우정보 as c\r\n"
					+ "ON a.배우번호 = c.배우번호\r\n"
					+ "WHERE c.배우 = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(actorMovieList1);
			preparedStatement.setString(1, actorName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ActorMovieListSelect actorMovieListSelect = new ActorMovieListSelect();
				actorMovieListSelect.setActorName(resultSet.getString("배우"));
				actorMovieListSelect.setMovieName(resultSet.getString("이름"));
				actorMovieListSelect.setRole(resultSet.getString("역할"));
				actorMovieListSelect.setRoleName(resultSet.getString("역할명"));
				
				actorMovieList.add(actorMovieListSelect);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actorMovieList;
		
	}

	@Override
	public void AllMovieList() {
		try {
			String allMovieList1 = "SELECT * FROM 영화정보";
			PreparedStatement preparedStatement = connection.prepareStatement(allMovieList1);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
//				
				System.out.println("movieNumber : " + resultSet.getString("영화번호"));
				System.out.println("movieName : " + resultSet.getString("이름"));
				System.out.println("year : " + resultSet.getString("개봉년도"));
				System.out.println("sales : " + resultSet.getString("매출액"));
				System.out.println("audience : " + resultSet.getString("관객수"));
				System.out.println("rating : " + resultSet.getString("평점"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<AllactorListDto> AllActorInfo() {
		ArrayList<AllactorListDto> allActor = new ArrayList<AllactorListDto>();
		try {
			String allActorList1 = "SELECT * FROM 배우정보";
			PreparedStatement preparedStatement = connection.prepareStatement(allActorList1);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AllactorListDto allActorselect = new AllactorListDto();
				
				allActorselect.setActorNumber(resultSet.getString("배우번호"));
				allActorselect.setActorName(resultSet.getString("배우"));
				allActorselect.setActorYear(resultSet.getInt("출연자출생"));
				allActorselect.setHeight(resultSet.getInt("키"));
				allActorselect.setWeight(resultSet.getInt("몸무게"));
				allActorselect.setSpouse(resultSet.getString("배우자"));
				
				
				allActor.add(allActorselect);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allActor;
		
		
	}

	@Override
	public ArrayList<AllMovieDto> movieInfo1(String movieName) {
		
		ArrayList<AllMovieDto> allMovieInfo = new ArrayList<AllMovieDto>();
		try {
			String allMovieInfo1 = "SELECT * FROM 영화정보 WHERE 이름 = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(allMovieInfo1);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AllMovieDto movieInfo = new AllMovieDto();
				movieInfo.setMovieNumber(resultSet.getInt("영화번호"));
				movieInfo.setMovieName(resultSet.getString("이름"));
				movieInfo.setYear(resultSet.getInt("개봉년도"));
				movieInfo.setSales(resultSet.getInt("매출액"));
				movieInfo.setAudience(resultSet.getInt("관객수"));
				movieInfo.setRating(resultSet.getDouble("평점"));
				
				allMovieInfo.add(movieInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMovieInfo;
	}
	@Override
	public ArrayList<AllMovieDto> movieInfo2(int movieYear) {
		
		ArrayList<AllMovieDto> allMovieInfo2 = new ArrayList<AllMovieDto>();
		try {
			String allMovieInfo = "SELECT * FROM 영화정보 WHERE 개봉년도 = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(allMovieInfo);
			preparedStatement.setInt(1, movieYear);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AllMovieDto movieInfo = new AllMovieDto();
				movieInfo.setMovieNumber(resultSet.getInt("영화번호"));
				movieInfo.setMovieName(resultSet.getString("이름"));
				movieInfo.setYear(resultSet.getInt("개봉년도"));
				movieInfo.setSales(resultSet.getInt("매출액"));
				movieInfo.setAudience(resultSet.getInt("관객수"));
				movieInfo.setRating(resultSet.getDouble("평점"));
				
				allMovieInfo2.add(movieInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMovieInfo2;
	}
	
}

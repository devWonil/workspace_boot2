package ch06.dbDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch06.dbDto.*;
import ch06.dbInterface.*;


public class SelectDao implements ISelect{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null; 

	@Override
	public ArrayList<MovieListSelectDto> movieList(String movieName) {
		// 영화정보의 영화이름으로 영화정보 출력 (영화이름,개봉년도,역할: 배우, 평점)
		ArrayList<MovieListSelectDto> movieList = new ArrayList<MovieListSelectDto>();
		try {
			String movieList1 = "select b.movieName, b.releasedDate, concat_ws(':', a.role, c.actor) as '주연배우', b.starRating\r\n"
					+ "from roletbl as a\r\n"
					+ "inner join movietbl as b\r\n"
					+ "on a.movieNumber = b.movieNumber\r\n"
					+ "inner join actortbl as c\r\n"
					+ "on a.actorNumber = c.actorNumber\r\n"
					+ "where b.movieName =  ? \r\n"
					+ "and a.role = '주연'\r\n"
					+ "group by a.movieNumber";
			PreparedStatement preparedStatement = connection.prepareStatement(movieList1);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				MovieListSelectDto movieListSelectDto = new MovieListSelectDto();
				movieListSelectDto.setMovieName(resultSet.getString("movieName"));
				movieListSelectDto.setYear(resultSet.getDate("releasedDate"));
				movieListSelectDto.setRole_actor(resultSet.getString("주연배우"));
				movieListSelectDto.setStarRating(resultSet.getDouble("starRating"));
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
			String movieTicketPrice1 = "SELECT a.movieName, b.ticketPrice\r\n"
					+ " FROM movieTbl as a\r\n"
					+ " INNER JOIN costTbl as b\r\n"
					+ " ON a.movieNumber = b.movieNumber\r\n"
					+ " WHERE a.movieName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieTicketPrice1);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				MovieTicketPriceDto movieTicketPriceDto = new MovieTicketPriceDto();
				movieTicketPriceDto.setMovieName(resultSet.getString("movieName"));
				movieTicketPriceDto.setPrice(resultSet.getInt("ticketPrice"));

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
			String actorInfo1 = "SELECT actor, birthYear, height, weight, spouse \r\n"
					+ "FROM actorTbl\r\n"
					+ "WHERE actor = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(actorInfo1);
			preparedStatement.setString(1, actorName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ActorInfoSelectDto actorInfoSelectDto = new ActorInfoSelectDto();
				actorInfoSelectDto.setActorName(resultSet.getString("actor"));
				actorInfoSelectDto.setActorYear(resultSet.getInt("birthYear"));
				actorInfoSelectDto.setHeight(resultSet.getInt("height"));
				actorInfoSelectDto.setWeight(resultSet.getInt("weight"));
				actorInfoSelectDto.setSpouse(resultSet.getString("spouse"));

			
			actorInfoSelect.add(actorInfoSelectDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actorInfoSelect;
	}

	@Override
	public ArrayList<ActorMovieListSelectDto> actorMovieList(String actorName) {
		ArrayList<ActorMovieListSelectDto> actorMovieList = new ArrayList<ActorMovieListSelectDto>();
		try {
			String actorMovieList1 = "SELECT c.actor, b.movieName, a.role, a.roleName\r\n"
					+ "FROM roleTbl as a\r\n"
					+ "INNER JOIN movieTbl as b\r\n"
					+ "ON a.movieNumber = b.movieNumber\r\n"
					+ "INNER JOIN actorTbl as c\r\n"
					+ "ON a.actorNumber = c.actorNumber\r\n"
					+ "WHERE c.actor = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(actorMovieList1);
			preparedStatement.setString(1, actorName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ActorMovieListSelectDto actorMovieListSelect = new ActorMovieListSelectDto();
				actorMovieListSelect.setActorName(resultSet.getString("actor"));
				actorMovieListSelect.setMovieName(resultSet.getString("movieName"));
				actorMovieListSelect.setRole(resultSet.getString("role"));
				actorMovieListSelect.setRoleName(resultSet.getString("roleName"));
				
				actorMovieList.add(actorMovieListSelect);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actorMovieList;
		
	}

	

	@Override
	public ArrayList<AllactorListDto> AllActorInfo() {
		ArrayList<AllactorListDto> allActor = new ArrayList<AllactorListDto>();
		try {
			String allActorList1 = "SELECT * FROM actorTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(allActorList1);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AllactorListDto allActorselect = new AllactorListDto();
				
				allActorselect.setActorNumber(resultSet.getString("actorNumber"));
				allActorselect.setActorName(resultSet.getString("actorName"));
				allActorselect.setActorYear(resultSet.getInt("birthYear"));
				allActorselect.setHeight(resultSet.getInt("height"));
				allActorselect.setWeight(resultSet.getInt("weight"));
				allActorselect.setSpouse(resultSet.getString("spouse"));
				
				
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
			String allMovieInfo1 = "SELECT * FROM movieTbl WHERE movieName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(allMovieInfo1);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AllMovieDto movieInfo = new AllMovieDto();
				movieInfo.setMovieNumber(resultSet.getInt("movieNumber"));
				movieInfo.setMovieName(resultSet.getString("movieName"));
				movieInfo.setYear(resultSet.getString("releasedDate"));
				movieInfo.setSales(resultSet.getLong("revenue"));
				movieInfo.setAudience(resultSet.getInt("audience"));
				movieInfo.setScreen(resultSet.getInt("screen"));
				movieInfo.setRating(resultSet.getDouble("starRating"));
				
				allMovieInfo.add(movieInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMovieInfo;
	}
	@Override
	public ArrayList<AllMovieDto> movieInfo2(String movieYear) {
		
		ArrayList<AllMovieDto> allMovieInfo2 = new ArrayList<AllMovieDto>();
		try {
			String allMovieInfo = "SELECT * FROM movieTbl WHERE releasedDate = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(allMovieInfo);
			preparedStatement.setString(1, movieYear);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AllMovieDto movieInfo = new AllMovieDto();
				movieInfo.setMovieNumber(resultSet.getInt("movieNumber"));
				movieInfo.setMovieName(resultSet.getString("movieName"));
				movieInfo.setYear(resultSet.getString("releasedDate"));
				movieInfo.setSales(resultSet.getLong("revenue"));
				movieInfo.setAudience(resultSet.getInt("audience"));
				movieInfo.setScreen(resultSet.getInt("screen"));
				movieInfo.setRating(resultSet.getDouble("starRating"));
				
				allMovieInfo2.add(movieInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMovieInfo2;
	}

	@Override
	public ArrayList<RoleDto> roleList1(int movieNumber) {
		ArrayList<RoleDto> roleList1_1 = new ArrayList<RoleDto>();
		try {
			String roleList1_2 = "SELECT * FROM roleTbl WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(roleList1_2);
			preparedStatement.setInt(1, movieNumber);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RoleDto roleDto = new RoleDto();
				roleDto.setMovieNumber(resultSet.getInt("movieNumber"));
				roleDto.setActorNumber(resultSet.getInt("actorNumber"));
				roleDto.setRole(resultSet.getString("role"));
				roleDto.setRoleName(resultSet.getString("roleName"));
				
				roleList1_1.add(roleDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList1_1;
	}

	@Override
	public ArrayList<RoleDto> roleList2(int actorNumber) {
		ArrayList<RoleDto> roleList2_1 = new ArrayList<RoleDto>();
		try {
			String roleList2_2 = "SELECT * FROM roleTbl WHERE   actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(roleList2_2);
			preparedStatement.setInt(1, actorNumber);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RoleDto roleDto = new RoleDto();
				roleDto.setMovieNumber(resultSet.getInt("movieNumber"));
				roleDto.setActorNumber(resultSet.getInt("actorNumber"));
				roleDto.setRole(resultSet.getString("role"));
				roleDto.setRoleName(resultSet.getString("roleName"));
				
				roleList2_1.add(roleDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList2_1;
	}
	
}

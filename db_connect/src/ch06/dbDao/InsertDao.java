package ch06.dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch06.dbInterface.Iinsert;


public class InsertDao implements Iinsert{
	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	
	ResultSet resultSet = null; 
	@Override
	public void insertMovie(int movieNumber, String movieName, String releasedDate, long revenue, int audience, int screen, double starRating) {
		try {
			String insertMovie = "INSERT INTO movieTbl VALUES(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertMovie);
			preparedStatement.setInt(1, movieNumber);
			preparedStatement.setString(2, movieName);
			preparedStatement.setString(3, releasedDate);
			preparedStatement.setLong(4, revenue);
			preparedStatement.setInt(5, audience);
			preparedStatement.setInt(6, screen);
			preparedStatement.setDouble(7, starRating);
			int insertMovieCount = preparedStatement.executeUpdate();
			System.out.println("insertMovieCount :" + insertMovieCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

	@Override
	public void insertActor(int actorNumber, String actor, int birthYear, double height, double weight, String spouse) {
		try {
			String insertActor = "INSERT INTO actorTbl VALUES(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertActor);
			preparedStatement.setInt(1, actorNumber);
			preparedStatement.setString(2, actor);
			preparedStatement.setInt(3, birthYear);
			preparedStatement.setDouble(4, height);
			preparedStatement.setDouble(5, weight);
			preparedStatement.setString(6, spouse);
			int insertActorCount = preparedStatement.executeUpdate();
			System.out.println("insertActorCount :" + insertActorCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void insertMoviePrice(int movieNumber, long productionCost, long sales, long revenue, int ticketPrice) {
		try {
			String insertMoviePrice = "INSERT INTO costTbl VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertMoviePrice);
			preparedStatement.setInt(1, movieNumber);
			preparedStatement.setLong(2, productionCost);
			preparedStatement.setLong(3, sales);
			preparedStatement.setLong(4, revenue);
			preparedStatement.setInt(5, ticketPrice);
			int insertMoviePriceCount = preparedStatement.executeUpdate();
			System.out.println("insertMoviePriceCount :" + insertMoviePriceCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void insertrole(int movieNumber, int actorNumber, String role, String roleName) {
		try {
			String insertAppear1 = "INSERT INTO roleTbl VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertAppear1);
			preparedStatement.setInt(1, movieNumber);
			preparedStatement.setInt(2, actorNumber);
			preparedStatement.setString(3, role);
			preparedStatement.setString(4, roleName);
			int insertAppear1Count = preparedStatement.executeUpdate();
			System.out.println("insertAppear1Count :" + insertAppear1Count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

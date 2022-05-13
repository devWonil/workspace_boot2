package ch06.dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch06.dbInterface.IUpdate;

public class UpdateDao implements IUpdate{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null;

	
	@Override
	public void movieNameUpdate(String movieName, int movieNumber) {
		try {
			String movieNameUpdate1 = "UPDATE movieTbl SET movieName = ? WHERE movieNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(movieNameUpdate1);
			preparedStatement.setString(1, movieName);
			preparedStatement.setInt(2, movieNumber);
			
			int movieNameupdateCount = preparedStatement.executeUpdate();
			System.out.println("updateCount : " + movieNameupdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void movieratingUpdate(double starRating, int movieNumber) {
		try {
			String movieRatingUpdate1 = "UPDATE movieTbl set starRating = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieRatingUpdate1);
			preparedStatement.setDouble(1, starRating);
			preparedStatement.setInt(2, movieNumber);
			
			int movieRatingUpdateCount = preparedStatement.executeUpdate();
			System.out.println("ratingUpdateCount : " + movieRatingUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void movieYearUpdate(String releasedDate, int movieNumber) {
		try {
			String movieYearUpdate1 = "UPDATE movieTbl SET releasedDate = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieYearUpdate1);
			preparedStatement.setString(1, releasedDate);
			preparedStatement.setInt(2, movieNumber);
			
			int movieYearUpdateCount = preparedStatement.executeUpdate();
			System.out.println("yearUpdateCount : " + movieYearUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void movieRevenueUpdate(long revenue, int movieNumber) {
		try {
			String movieSalesUpdate1 = "UPDATE movieTbl SET revenue = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieSalesUpdate1);
			preparedStatement.setLong(1, revenue);
			preparedStatement.setInt(2, movieNumber);
			
			int movieSalesUpdateCount = preparedStatement.executeUpdate();
			System.out.println("SalesUpdateCount : " + movieSalesUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void movieScreenUpdate(int screen, int movieNumber) {
		try {
			String movieScreenUpdate1 = "UPDATE movieTbl SET screen = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieScreenUpdate1);
			preparedStatement.setInt(1, screen);
			preparedStatement.setInt(2, movieNumber);
			
			int movieScreenUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + movieScreenUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void movieAudienceUpdate(int audience, int movieNumber) {
		try {
			String movieAudienceUpdate1 = "UPDATE movieTbl SET audience = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieAudienceUpdate1);
			preparedStatement.setInt(1, audience);
			preparedStatement.setInt(2, movieNumber);
			
			int movieAudienceUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + movieAudienceUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// ======================================================
	
	
	@Override
	public void actorNameUpdate(String actor, int atorNumber) {
		try {
			String actorNameUpdate1 = "UPDATE actorTbl SET actor = ? WHERE actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(actorNameUpdate1);
			preparedStatement.setString(1, actor);
			preparedStatement.setInt(2, atorNumber);
			
			int actorNameUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + actorNameUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actorYearUpdate(int birthYear, int atorNumber) {
		try {
			String actorYearUpdate1 = "UPDATE actorTbl SET birthYear = ? WHERE actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(actorYearUpdate1);
			preparedStatement.setInt(1, birthYear);
			preparedStatement.setInt(2, atorNumber);
			
			int actorYearUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + actorYearUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void actorHeightUpdate(double height, int atorNumber) {
		try {
			String actorHeightUpdate1 = "UPDATE actorTbl SET height = ? WHERE actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(actorHeightUpdate1);
			preparedStatement.setDouble(1, height);
			preparedStatement.setInt(2, atorNumber);
			
			int actorHeightUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + actorHeightUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void actorWeightUpdate(double weight, int atorNumber) {
		try {
			String actorWeightUpdate1 = "UPDATE actorTbl SET weight = ? WHERE actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(actorWeightUpdate1);
			preparedStatement.setDouble(1, weight);
			preparedStatement.setInt(2, atorNumber);
			
			int actorWeightUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + actorWeightUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actorSpouseUpdate(String spouse, int atorNumber) {
		try {
			String actorSpouseUpdate1 = "UPDATE actorTbl SET spouse = ? WHERE actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(actorSpouseUpdate1);
			preparedStatement.setString(1, spouse);
			preparedStatement.setInt(2, atorNumber);
			
			int actorSpouseUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + actorSpouseUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	// ======================================================
	
	
	@Override
	public void costProdCost(long prodCost, int movieNuber) {
		try {
			String costProdCostUpdate1 = "UPDATE costTbl SET productionCost = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(costProdCostUpdate1);
			preparedStatement.setLong(1, prodCost);
			preparedStatement.setInt(2, movieNuber);
			
			int costProdCostUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + costProdCostUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void costSales(long sales, int movieNuber) {
		try {
			String costSalesUpdate1 = "UPDATE costTbl SET sales = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(costSalesUpdate1);
			preparedStatement.setLong(1, sales);
			preparedStatement.setInt(2, movieNuber);
			
			int costSalesUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " +costSalesUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void costRevenue(long revenue, int movieNuber) {
		try {
			String costRevenueUpdate1 = "UPDATE costTbl SET revenue = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(costRevenueUpdate1);
			preparedStatement.setLong(1, revenue);
			preparedStatement.setInt(2, movieNuber);
			
			int costRevenueUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + costRevenueUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void costPriceUpdate(int price, int movieNuber) {
		try {
			String costPriceUpdate1 = "UPDATE costTbl SET ticketPrice = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(costPriceUpdate1);
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, movieNuber);
			
			int costPriceUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " +costPriceUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	
	// ======================================================
	
	
	@Override
	public void AppearActorNumUpdate(int actorNumber, String roleName, int movieNumber) {
		try {
			String appearActorNumUpdate1 = "UPDATE roleTbl SET actorNumber = ? WHERE roleName = ? AND movieNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearActorNumUpdate1);
			preparedStatement.setInt(1, actorNumber);
			preparedStatement.setString(2, roleName);
			preparedStatement.setInt(3, movieNumber);
			
			int appearActorNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearActorNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void AppearRoleUpdate(String role, String roleName, int actorNumber) {
		try {
			String appearActorNumUpdate1 = "UPDATE roleTbl SET role = ? WHERE roleName = ? AND actorNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearActorNumUpdate1);
			preparedStatement.setString(1, role);
			preparedStatement.setString(2, roleName);
			preparedStatement.setInt(3, actorNumber);
			
			int appearActorNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearActorNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void AppearRoluNameUpdate(String roleName, int movieNumber, int actorNumber) {
		try {
			String appearActorNumUpdate1 = "UPDATE roleTbl SET roleName = ? WHERE movieNumber = ? AND actorNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearActorNumUpdate1);
			preparedStatement.setString(1, roleName);
			preparedStatement.setInt(2, movieNumber);
			preparedStatement.setInt(3, actorNumber);
			
			int appearActorNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearActorNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void AppearMoiveNumUpdate(int movieNumber, String roleName, int actorNumber) {
		try {
			String appearMoiveNumUpdate1 = "UPDATE roleTbl SET movieNumber = ? WHERE roleName = ? AND actorNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearMoiveNumUpdate1);
			preparedStatement.setInt(1, movieNumber);
			preparedStatement.setString(2, roleName);
			preparedStatement.setInt(3, actorNumber);
			
			int appearMoiveNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearMoiveNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void AppearMovieNumAllUpdate(int setmovieNumber, int movieNumber) {
		try {
			String appearMoiveNumAllUpdate1 = "UPDATE roleTbl SET movieNumber = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(appearMoiveNumAllUpdate1);
			preparedStatement.setInt(1, setmovieNumber);
			preparedStatement.setInt(2, movieNumber);
			
			
			int appearMoiveNumAllUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearMoiveNumAllUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	
}

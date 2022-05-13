package ch06.dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch06.dbInterface.IDelete;

public class DeleteDao implements IDelete{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null;

	@Override
	public void RoleDelete1(int movieNumber, int actorNumber) {	
		//배우번호,영화번호 로 출연정보 삭제
		try {
			String roleDelete1 = "DELETE FROM roleTbl WHERE actorNumber = ? AND movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(roleDelete1);
			preparedStatement.setInt(1, actorNumber);
			preparedStatement.setInt(2, movieNumber);
			
			int roleDelete1Count = preparedStatement.executeUpdate();
			System.out.println(roleDelete1Count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	@Override
	public void movieDelete(int movieNumber) {
		// 영화번호로 영화정보 삭제
		try {
			String movieDelete = "DELETE FROM movieTbl WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieDelete);
			preparedStatement.setInt(1, movieNumber);
			
			int movieDeleteCount = preparedStatement.executeUpdate();
			System.out.println(movieDeleteCount);
			if(movieDeleteCount <= 0) {
				System.out.println("잘못입력했습니다. 출연쪽확인");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void actorDelete(int actorNumber) {
		// 배우번호로 배우정보 삭제
		try {
			String  actorDelete = "DELETE FROM actorTbl WHERE actorNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement( actorDelete);
			preparedStatement.setInt(1, actorNumber);
			
			int  actorDeleteCount = preparedStatement.executeUpdate();
			System.out.println( actorDeleteCount);
			if( actorDeleteCount <= 0) {
				System.out.println("잘못입력했습니다. 출연쪽확인");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	// 영화번호로 영화금액 삭제
	public void moviePriceDelete(int movieNumber) {
		try {
			String  moviePriceDelete = "DELETE FROM costTbl WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement( moviePriceDelete);
			preparedStatement.setInt(1, movieNumber);
			
			int  moviePriceDeleteCount = preparedStatement.executeUpdate();
			System.out.println( moviePriceDeleteCount);
			if( moviePriceDeleteCount <= 0) {
				System.out.println("잘못입력했습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

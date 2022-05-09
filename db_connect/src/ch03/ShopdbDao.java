package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;

public class ShopdbDao implements IShopdbDao {

	private DBClient dbClient;
	private Connection conn;

	public ShopdbDao() {
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	}

	// userTBL, buyTBL 결과 *
	@Override
	public ArrayList<ShopdbDto> innerJoin1() {

		ArrayList<ShopdbDto> dataResult = new ArrayList<ShopdbDto>();
		String sql = "select * " + "from userTBL as u " + "inner join buyTBL as b " + "on u.userName = b.userName ";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ShopdbDto dto = new ShopdbDto();

				System.out.print(rs.getString("userName"));
				System.out.print("\t");
				System.out.print(rs.getInt("birthYear"));
				System.out.print("\t");
				System.out.print(rs.getString("addr"));
				System.out.print("\t");
				System.out.print(rs.getString("mobile"));
				System.out.print("\t");
				System.out.print(rs.getString("prodName"));
				System.out.print("\t");
				System.out.print(rs.getInt("price"));
				System.out.print("\t");
				System.out.println(rs.getInt("amount"));

//				dto.setUserName(rs.getString("userName"));
//				dataResult.add(dto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------");
		return dataResult;

	}

	// userTBL, buyTBL null 제거 , 결과 *
	@Override
	public ArrayList<ShopdbDto> leftJoin1() {

		ArrayList<ShopdbDto> dataResult = new ArrayList<ShopdbDto>();
		String sql = "select * " + "from userTBL as u " + "left join buyTBL as b " + "on u.userName = b.userName "
				+ "where b.userName is not null ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ShopdbDto dto = new ShopdbDto();
				System.out.print(rs.getString("userName"));
				System.out.print("\t");
				System.out.print(rs.getInt("birthYear"));
				System.out.print("\t");
				System.out.print(rs.getString("addr"));
				System.out.print("\t");
				System.out.print(rs.getString("mobile"));
				System.out.print("\t");
				System.out.print(rs.getString("prodName"));
				System.out.print("\t");
				System.out.print(rs.getInt("price"));
				System.out.print("\t");
				System.out.println(rs.getInt("amount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------");
		return dataResult;

	}

	// buyTBL, userTBL , 결과 *
	@Override
	public ArrayList<ShopdbDto> leftJoin2() {

		ArrayList<ShopdbDto> dataResult = new ArrayList<ShopdbDto>();
		String sql = "select * " + "from userTBL as u " + "left join buyTBL as b " + "on u.userName = b.userName ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs;

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ShopdbDto dto = new ShopdbDto();
				System.out.print(rs.getString("userName"));
				System.out.print("\t");
				System.out.print(rs.getInt("birthYear"));
				System.out.print("\t");
				System.out.print(rs.getString("addr"));
				System.out.print("\t");
				System.out.print(rs.getString("mobile"));
				System.out.print("\t");
				System.out.print(rs.getString("prodName"));
				System.out.print("\t");
				System.out.print(rs.getInt("price"));
				System.out.print("\t");
				System.out.println(rs.getInt("amount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataResult;

	}

	public static void main(String[] args) {
		ShopdbDao shopdbDao = new ShopdbDao();
		ArrayList<ShopdbDto> buyList = shopdbDao.innerJoin1();
		ArrayList<ShopdbDto> buyList2 = shopdbDao.leftJoin1();
		ArrayList<ShopdbDto> buyList3 = shopdbDao.leftJoin2();
	}
}

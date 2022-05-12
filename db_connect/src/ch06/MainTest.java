package ch06;

public class MainTest {

	public static void main(String[] args) {

		MovieInfoDao dao = new MovieInfoDao();
		
		System.out.println(dao.select());
		
	}

}


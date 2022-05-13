package ch06.dbDao;

public class MainTest {

	public static void main(String[] args) {
		
		SelectDao selectDao = new SelectDao();
//		ArrayList<MovieListSelectDto> movielist = selectDao.movieList("국제시장"); 
//		System.out.println(movielist); OK
		
//		ArrayList<MovieTicketPriceDto> ticketPrice = selectDao.movieTicketPrice("국제시장");
//		System.out.println(ticketPrice); OK
		
//		ArrayList<ActorInfoSelectDto> actorInfo = selectDao.actorInfo("로버트 다우니 주니어");
//		System.out.println(actorInfo); OK
		
//		ArrayList<ActorMovieListSelect> actormoive = selectDao.actorMovieList("로버트 다우니 주니어");
//		System.out.println(actormoive); OK
		
//		ArrayList<AllMovieDto> allMovie = selectDao.movieInfo1("명량");
//		System.out.println(allMovie); OK
		
//		ArrayList<AllMovieDto> allMovie = selectDao.movieInfo2("2014,7,30");
//		System.out.println(allMovie); OK
		
		
//		ArrayList<RoleDto> roleDto = selectDao.roleList1(1);
//		System.out.println(roleDto); OK
		
//		ArrayList<RoleDto> roleDto = selectDao.roleList2(1);
//		System.out.println(roleDto); OK
		
		UpdateDao updateDao = new UpdateDao();
		// 영화쪽
//		updateDao.movieNameUpdate("프로젝트", 1); OK
//		updateDao.movieRevenueUpdate(1111111111, 1); OK 근데 왜 10억밖에 안됨?
//		updateDao.movieYearUpdate("2022,05,13", 1); OK
//		updateDao.movieAudienceUpdate(9, 1); OK
//		updateDao.movieratingUpdate(7.77, 1); OK
//		updateDao.movieScreenUpdate(10000, 1); OK

		//  배우쪽
//		updateDao.actorNameUpdate("최만식", 1); OK
//		updateDao.actorYearUpdate(2000, 1); OK
//		updateDao.actorHeightUpdate(182.7, 1); OK
//		updateDao.actorWeightUpdate(77.8, 1); OK
//		updateDao.actorSpouseUpdate("누구임?", 1); OK
		
//		updateDao.AppearActorNumUpdate(14, "이순신1", 1); OK
//		updateDao.AppearRoleUpdate("주연", "구루지마", 2); OK
//		updateDao.AppearRoluNameUpdate("나는나다", 1, 3); OK
//		updateDao.AppearMoiveNumUpdate(3, "이순신1", 14); OK
//		updateDao.AppearMovieNumAllUpdate(4, 5); OK
		
		
		
//		updateDao.costProdCost(333333333, 1); OK
//		updateDao.costSales(777777777, 5); OK
//		updateDao.costRevenue(999999999, 3); OK;
//		updateDao.costPriceUpdate(4500, 4); OK;
		
		
		
		InsertDao insertDao = new InsertDao();
//		insertDao.insertMovie(10, "들어감?", "2022,05,12", 1111111111, 120, 2, 7.21); OK
//		insertDao.insertActor(20, "임모씨", 1997, 170.8, 78.2, null);  OK
//		insertDao.insertMoviePrice(10, 111111, 22222, 333333333, 15000); OK
//		insertDao.insertrole(10, 20, "주연", "망나니"); 
		
		DeleteDao deleteDao = new DeleteDao();
//		deleteDao.RoleDelete1(10, 20);  OK
//		deleteDao.RoleDelete2(10); OK
//		deleteDao.movieDelete(10); OK
//		deleteDao.actorDelete(20); OK
//		deleteDao.moviePriceDelete(10); OK

	}

}

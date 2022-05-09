package ch03;

import java.util.ArrayList;

public interface IShopdbDao {

	// userTBL, buyTBL 결과 *
	ArrayList<ShopdbDto> innerJoin1();
	
	// userTBL, buyTBL null 제거 , 결과 *
	ArrayList<ShopdbDto> leftJoin1();
	
	// buyTBL, userTBL , 결과 *
	ArrayList<ShopdbDto> leftJoin2();
	
	
}

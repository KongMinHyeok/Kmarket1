package kr.co.kmarket1.db;

public class MainSQL {
	// 메인화면
	public static final String SELECT_KM_PRODUCT_CATE1 = "select * from `km_product_cate1`";
	public static final String SELECT_KM_PRODUCT_CATE2 = "select * from `km_product_cate2`";
	
	public static final String SELECT_KM_PRODUCT_SOLD_COUNT = "select `prodNo`, `prodName`, `thumb1`, `price`, `discount` from `km_product`"
															+ "order by `sold` DESC "
															+ "limit 0, 5";
	
	public static final String SELECT_KM_PRODUCT_HIT_COUNT = "select `prodNo`, `prodName`, `descript`, `thumb2`, `price`, `discount` from `km_product`"
															+ "order by `hit` DESC "
															+ "limit 0, 8";
													
	public static final String SELECT_KM_PRODUCT_SCORE_COUNT = "select `prodNo`, `prodName`, `descript`,`thumb1`, `price`, `discount` from `km_product`"
															+ "order by `score` DESC "
															+ "limit 0, 8";
	
	public static final String SELECT_KM_PRODUCT_NEW_COUNT = "select `prodNo`, `prodName`, `descript`,`thumb1`, `price`, `discount` from `km_product`"
															+ "order by `prodNo` DESC "
															+ "limit 0, 8";
														
	public static final String SELECT_KM_PRODUCT_DISCOUNT_COUNT = "select `prodNo`, `prodName`, `descript`, `thumb1`, `price`, `discount` from `km_product`"
																	+ "order by `discount` DESC "
																	+ "limit 0, 8";

}

package kr.co.kmarket1.db;

public class MainSQL {
	// 메인화면
	public static final String SELECT_KM_PRODUCT_CATE1 = "select * from `km_product_cate1`";
	public static final String SELECT_KM_PRODUCT_CATE2 = "select * from `km_product_cate2`";
	
	public static final String SELECT_KM_PRODUCT_SOLD_COUNT = "select * from `km_product `"
															+ "order by `sold` DESC "
															+ "limit ?, 5";
	

}

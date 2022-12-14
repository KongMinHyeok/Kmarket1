
package kr.co.kmarket1.db;

public class ProductSQL {
	public static final String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo`=?";
	// 판매량순 정렬
	public static final String SELECT_PRODUCTS1 = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate1` =? AND `prodCate2` =? "
												+ "ORDER BY `sold` DESC limit ?, 10";
	// 낮은 가격순 정렬
	public static final String SELECT_PRODUCTS2 = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate1` =? AND `prodCate2` =? "
												+ "ORDER BY `price` ASC limit ?, 10";
	// 높은 가격순 정렬
	public static final String SELECT_PRODUCTS3 = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate1` =? AND `prodCate2` =? "
												+ "ORDER BY `price` DESC limit ?, 10";
	// 평점 높은순 정렬
	public static final String SELECT_PRODUCTS4 = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate1` =? AND `prodCate2` =? "
												+ "ORDER BY `score` DESC limit ?, 10";
	// 후기 많은순 정렬
	public static final String SELECT_PRODUCTS5 = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate1` =? AND `prodCate2` =? "
												+ "ORDER BY `review` DESC limit ?, 10";
	// 최근 등록순 정렬
	public static final String SELECT_PRODUCTS6 = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate1` =? AND `prodCate2` =? "
												+ "ORDER BY `rdate` DESC limit ?, 10";

										
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` "
													+ "where `prodCate1`=? AND `prodCate2`=?";

}
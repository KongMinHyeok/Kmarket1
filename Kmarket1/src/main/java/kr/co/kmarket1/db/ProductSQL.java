package kr.co.kmarket1.db;

public class ProductSQL {
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate2` =? "
												+ "ORDER BY `prodNo` DESC limit ?, 10";
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` "
													+ "where `prodCate`=?";
}

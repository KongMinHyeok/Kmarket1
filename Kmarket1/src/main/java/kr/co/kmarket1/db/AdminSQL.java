package kr.co.kmarket1.db;

public class AdminSQL {

	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` "
												+ "WHERE `prodCate2` =? "
												+ "ORDER BY `prodNo` DESC limit ?, 10";

	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` "
												+ "where `prodCate`=?";
	
	public static final String INSERT_PRODUCT = "INSERT INTO `km_product` set "
												+ "`prodName`=? "
												+ "`descript`=? "
												+ "`company`=? "
												+ "`price`=? "
												+ "`discount`=? "
												+ "`point`=? "
												+ "`stock`=? "
												+ "`delivery`=? "
												+ "`thumb1`=? "
												+ "`thumb2`=? "
												+ "`thumb3`=? "
												+ "`detail`=? "
												+ "`status`=? "
												+ "`duty`=? "
												+ "`receipt`=? "
												+ "`bizType`=? "
												+ "`origin`=?";
}

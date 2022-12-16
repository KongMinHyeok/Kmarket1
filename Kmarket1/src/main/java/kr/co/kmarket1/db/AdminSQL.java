package kr.co.kmarket1.db;

public class AdminSQL {
	//product_register
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
											   + "order by `sold` desc limit ?, 10";
	
	public static final String INSERT_PRODUCT = "INSERT INTO `km_product` SET "
											  + "`prodCate1` = ?, "
											  + "`prodCate2` = ?, "
											  + "`prodName` = ?, "
											  + "`descript` = ?, "
											  + "`company` = ?, "
											  + "`seller` = ?, "
											  + "`price` = ?, "
											  + "`discount` = ?, "
											  + "`point` = ?, "
											  + "`stock` = ?, "
											  + "`delivery` = ?, "
											  + "`thumb1` = ?, "
											  + "`thumb2` = ?, "
											  + "`thumb3` = ?, "
											  + "`detail` = ?, "
											  + "`status` = ?, "
											  + "`duty` = ?, "
											  + "`receipt` = ?, "
											  + "`bizType` = ?, "
											  + "`origin` = ?, "
											  + "`ip` = ?, "
											  + "`rdate`=NOW()";
	
}

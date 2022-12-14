package kr.co.kmarket1.db;

public class AdminSQL {
	//product_register
	public static final String INSERT_PRODUCT_REGISTER = "INSERT INTO `km_product` SET "
													   + "`prodName`=?, `descript`=?, `company`=?, `price`=?, `discount`=?, "
													   + "`point`=?, `stock`=?, `delivery`=?, `thumb1`=?, `thumb2`=?, `thumb3`=?, "
													   + "`detail`=?, `status`=?, `duty`=?, `receipt`=?, `bizType`=?, `origin`=?";
}

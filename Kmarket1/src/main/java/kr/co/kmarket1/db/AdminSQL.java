package kr.co.kmarket1.db;

public class AdminSQL {
	
	//Admin List DAO\\
	public static final String SELECT_ADMIN_LIST = "SELECT * FROM `km_product` ORDER BY `prodNo` DESC LIMIT ?,10";
	//Admin 상품 갯수 출력
	public static final String SELECT_COUNT_TOTAL_LIST = "SELECT COUNT(*) FROM `km_product`";
	//Admin List 삭제
	public static final String DELETE_ADMIN_LIST = "DELETE FROM `km_product` WHERE `prodNo`=?";
	
	
	
	
	//Admin Register DAO\\
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
											   + "order by `sold` desc limit ?, 10";
	
	public static final String INSERT_ADMIN_REGISTER = "INSERT INTO `km_product` SET "
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
	
	public static final String SELECT_PRODUCT_LIST = "SELECT * FROM `km_product` ";
	
	public static final String UPDATE_ADMIN_REGISTER = "UPDATE `km_product` SET "
													 + "`prodName`=?, `descript`=?, `company`=?, "
													 + "`seller`=?, `price`=?, `point`=?, "
													 + "`discount`=?, `stock`=?, `delivery`=?, "
													 + "`thumb1`=?, `thumb2`=?, `thumb3`=?, "
													 + "`detail`=?, `rdate`=now() "
													 + "WHERE `prodNo` = ?";
	
	//Admin List 수정
	public static final String MODIFY_ADMIN_LIST = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
}

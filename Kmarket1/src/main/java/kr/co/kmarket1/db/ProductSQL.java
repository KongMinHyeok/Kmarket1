
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
	
	// direct: 장바구니에 들어가는 거는 0, 바로 구매는 1
	public static final String INSERT_PRODUCT_CART = "INSERT INTO `km_product_cart` SET "
													+ "`uid`=?, `prodNo`=?, `count`=?, `price`=?, `discount`=?, `point`=?, `delivery`=?, `total`=?, `rdate`=?, `direct`=? ";
	
	public static final String SELECT_REVIEWS = "SELECT a.*, b.`prodName` FROM `km_product_review` AS a "
												+"JOIN `km_product` as b ON a.prodNo = b.prodNo "
												+"where a.`prodNo`=? "
												+"ORDER BY `rdate` desc LIMIT ?, 5";
	// 리뷰 총갯수
	public static final String SELECT_REVIEW_COUNT_TOTAL = "SELECT COUNT(`revNo`) FROM `km_product_review` "
												+ "where `prodNo`=?";
	// 장바구니 불렁기
	public static final String SELECT_PRODUCT_CARTS = "SELECT a.*, b.`prodName`,`descript`,`thumb1` FROM `km_product_cart` AS a "
													+ "JOIN `km_product` AS b ON a.prodNo = b.prodNo WHERE `uid`=? AND `direct`=0 AND `cartNo`=?";
	
	// view에서 장바구니 불러오기
	public static final String SELECT_PRODUCT_CARTS2 = "SELECT a.*, b.`prodName`,`descript`,`thumb1` FROM `km_product_cart` AS a "
														+ "JOIN `km_product` AS b ON a.prodNo = b.prodNo WHERE `uid`=? AND `direct`=0";

	// 장바구니 선택 삭제
	public static final String DELETE_PRODUCT_CART = "DELETE FROM `km_product_cart` WHERE `cartNo` = ? ";
	// order페이지 벗어나면 삭제
	public static final String DELETE_PRODUCT_DIRECT = "DELETE FROM `km_product_cart` WHERE `direct` = 1 ";
	/*  ----------------------------- 이거 어캐써야하지?------------------------------*/
	public static final String SELECT_PRODUCT_ORDERS = "SELECT a.*, b.proName, b.descript, b.thumb3FROM `km_product_cart` AS a "
															+ "JOIN `km_product` AS b ON a.proNo = b.proNo WHERE cartNo = ? ";
	// 상품 상세 정보에서 바로 구매창
	public static final String SELECT_PRODUCT_CART = "SELECT a.*, b.`prodName`,`descript`,`thumb1` FROM `km_product_cart` AS a "
													+ "JOIN `km_product` AS b ON a.prodNo = b.prodNo WHERE `uid`=? AND `direct`=1";
	public static final String FIND_DIRECT = "SELECT COUNT('cartNo') FROM `km_product_cart` WHERE `uid` = ? AND `direct`=1";
}


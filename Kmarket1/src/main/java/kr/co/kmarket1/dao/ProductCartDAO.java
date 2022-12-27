package kr.co.kmarket1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.ProductSQL;

public class ProductCartDAO extends DBHelper{
	private static ProductCartDAO instance = new ProductCartDAO();
	public static ProductCartDAO getInstance() {
		return instance;
	}
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private ProductCartDAO() {}
	
	// 장바구니에서 선택 상품삭제
	public int deleteProductCart(String cartNo) {
		int result = 0;
		try {
			logger.info("deleteProductCart start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.DELETE_PRODUCT_CART);
			psmt.setString(1, cartNo);
			
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	

}

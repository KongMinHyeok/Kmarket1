package kr.co.kmarket1.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.AdminSQL;
import kr.co.kmarket1.db.DBHelper;


import kr.co.kmarket1.vo.ProductVO;

public class AdminDAO extends DBHelper{
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public void insertProductRegister(ProductVO vo) {
		
		try {
			logger.info("insertProductRegister...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.INSERT_PRODUCT_REGISTER);
			
			psmt.setInt(1, vo.getProdCate1());
			psmt.setInt(2, vo.getProdCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setInt(6, vo.getPrice());
			psmt.setInt(7, vo.getDiscount());
			psmt.setInt(8, vo.getPoint());
			psmt.setInt(9, vo.getStock());
			psmt.setInt(10, vo.getDelivery());
			psmt.setString(11, vo.getThumb1());
			psmt.setString(12, vo.getThumb2());
			psmt.setString(13, vo.getThumb3());
			psmt.setString(14, vo.getDetail());
			psmt.setString(15, vo.getStatus());
			psmt.setString(16, vo.getDuty());
			psmt.setString(17, vo.getReceipt());
			psmt.setString(18, vo.getBizType());
			psmt.setString(19, vo.getOrigin());
			
			psmt.executeUpdate();
				
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
}

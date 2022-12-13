package kr.co.kmarket1.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;


import kr.co.kmarket1.db.ProductSQL;
import kr.co.kmarket1.vo.ProductVO;

public class AdminDAO extends DBHelper{
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}


	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public void insertProduct(ProductVO vo) {
		
		try {
			logger.info("insertProduct...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.INSERT_PRODUCT);
			
			psmt.setString(1, vo.getProdName());
			psmt.setString(2, vo.getDescript());
			psmt.setString(3, vo.getCompany());
			psmt.setInt(4, vo.getPrice());
			psmt.setInt(5, vo.getDiscount());
			psmt.setInt(6, vo.getPoint());
			psmt.setInt(7, vo.getStock());
			psmt.setInt(8, vo.getDelivery());
			psmt.setString(9, vo.getThumb1());
			psmt.setString(10, vo.getThumb2());
			psmt.setString(11, vo.getThumb3());
			psmt.setString(12, vo.getDetail());
			psmt.setString(13, vo.getStatus());
			psmt.setString(14, vo.getDuty());
			psmt.setString(15, vo.getReceipt());
			psmt.setString(16, vo.getBizType());
			psmt.setString(17, vo.getOrigin());
			
			psmt.executeUpdate();
				
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	

	
}

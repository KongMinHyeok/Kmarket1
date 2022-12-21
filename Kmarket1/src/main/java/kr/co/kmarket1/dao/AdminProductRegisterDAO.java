package kr.co.kmarket1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.AdminSQL;
import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.vo.ProductVO;

public class AdminProductRegisterDAO extends DBHelper {
	
	private static AdminProductRegisterDAO instance = new AdminProductRegisterDAO();
	public static AdminProductRegisterDAO getInstance(){
		return instance;
	}
	
	private AdminProductRegisterDAO() {}
	
	//로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void selectAdminRegister() {}
	public void selectAdminRegisters() {}
	
	//AdminProductRegisterController doPost 데이터베이스
	public int insertAdminRegister(ProductVO vo) {
		int result = 0;
		try {
			logger.info("insertAdminRegister...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.INSERT_ADMIN_REGISTER);
			psmt.setInt(1, vo.getProdCate1());
			psmt.setInt(2, vo.getProdCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setString(6, vo.getSeller());
			psmt.setInt(7, vo.getPrice());
			psmt.setInt(8, vo.getDiscount());
			psmt.setInt(9, vo.getPoint());
			psmt.setInt(10, vo.getStock());
			psmt.setInt(11, vo.getDelivery());
			psmt.setString(12, vo.getThumb1());
			psmt.setString(13, vo.getThumb2());
			psmt.setString(14, vo.getThumb3());
			psmt.setString(15, vo.getDetail());
			psmt.setString(16, vo.getStatus());
			psmt.setString(17, vo.getDuty());
			psmt.setString(18, vo.getReceipt());
			psmt.setString(19, vo.getBizType());
			psmt.setString(20, vo.getOrigin());
			psmt.setString(21, vo.getIp());
			
			result = psmt.executeUpdate();
			
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	public void updateAdminRegister(String prodName, String descript, String company, String seller, String price, String discount, String point, String stock, String delivery, String thumb1, String thumb2, String thumb3, String detail, String prodNo) {
		try {
			logger.info("상품내용 수정 : " + prodNo);
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.UPDATE_ADMIN_REGISTER);
			psmt.setString(1, prodName);
			psmt.setString(2, descript);
			psmt.setString(3, company);
			psmt.setString(4, seller);
			psmt.setString(5, price);
			psmt.setString(6, discount);
			psmt.setString(7, point);
			psmt.setString(8, stock);
			psmt.setString(9, delivery);
			psmt.setString(10, thumb1);
			psmt.setString(11, thumb2);
			psmt.setString(12, thumb3);
			psmt.setString(13, detail);
			psmt.setString(14, prodNo);
			
			psmt.executeUpdate();
			
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// 상품 삭제
	public void deleteAdminList(String prodNo) {
		logger.info("상품삭제 : " + prodNo);
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.DELETE_ADMIN_LIST);
			psmt.setString(1, prodNo);
			
			psmt.executeUpdate();
			
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//상품 수정
	public ProductVO ModifyAdminList(String prodNo) {
		logger.info("ModifyAdminList...");
		ProductVO vo = new ProductVO(); 
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.MODIFY_ADMIN_LIST);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18)); 
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
			}
			
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
}

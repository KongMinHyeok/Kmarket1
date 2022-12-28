package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.AdminSQL;
import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.vo.ProductVO;

public class AdminProductListDAO extends DBHelper {
	
	private static AdminProductListDAO instance = new AdminProductListDAO();
	public static AdminProductListDAO getInstance(){
		return instance;
	}
	
	private AdminProductListDAO() {}
	
	//로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// List 상품출력
	public List<ProductVO> selectAdminList(int start) {
		logger.info("selectAdminProductList...");
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("상품 리스트");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.SELECT_ADMIN_LIST);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	
	// List 상품출력 - 판매자용
	public List<ProductVO> selectAdminList(String seller, int start) {
		logger.info("selectAdminProductList...");
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("상품 리스트");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.SELECT_ADMIN_LIST);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	
	public void selectAdminLists() {}
	public void insertAdminList() {}
	public void updateAdminList() {}
	
	//페이지 리스트
	public int selectCountTotal() {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(AdminSQL.SELECT_COUNT_TOTAL_LIST);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public List<ProductVO> searchAdminList(String cate, String search) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("상품 리스트 검색 : " + cate + search);
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE `"+cate+"` LIKE ? ORDER BY `prodNo` DESC LIMIT 10");
			psmt.setString(1, "%"+search+"%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("상품 리스트 검색 : " + products.size());
		return products;
	}
	
	public List<ProductVO> searchAdminList(String seller, String cate, String search) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("상품 리스트 검색 : " + cate + search);
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE `"+cate+"` LIKE ? ORDER BY `prodNo` DESC LIMIT 10");
			psmt.setString(1, "%"+search+"%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("상품 리스트 검색 : " + products.size());
		return products;
	}
	
	//페이지 리스트 - 판매자용
	public int selectCountTotalSeller(String seller) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.COUNT_LIST_TOTAL_SELLER);
			psmt.setString(1, seller);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
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
	
	// 선택삭제
	public int selectDelete(String prodNo) {
		int result = 0;
		
		try {
			logger.info("선택삭제");
			conn = getConnection();
			
			psmt = conn.prepareStatement(AdminSQL.SELECT_DELETE);
			psmt.setString(1, prodNo);
			result = psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
}

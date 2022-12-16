package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	private AdminDAO() {}
	
	//logger
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void selectProduct() {}
	//메인 상품 리스트
	public List<ProductVO> selectProducts(String prodCate1, String prodCate2, int start) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProducts start...");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.SELECT_PRODUCTS);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
			
				products.add(product);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public int insertProduct(ProductVO vo) {
		int result = 0;
		try {
			logger.info("insertProduct...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSQL.INSERT_PRODUCT);
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
	public void updateProduct() {}
	public void deleteProduct() {}
	
}

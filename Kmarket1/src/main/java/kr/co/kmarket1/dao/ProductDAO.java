package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;

import kr.co.kmarket1.db.MainSQL;
import kr.co.kmarket1.vo.Cate1VO;

import kr.co.kmarket1.db.ProductSQL;
import kr.co.kmarket1.vo.ProductVO;

public class ProductDAO extends DBHelper{
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}

	
	private ProductDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Cate1VO> selectCate1(String c1Name) {
		
		List<Cate1VO> cate1s = new ArrayList<>();
		
		try {
			logger.info("selctCate1 start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MainSQL.SELECT_CATE1);
			psmt.setString(1, c1Name);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				cate1s.add(cate1);
				
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cate1 : " + cate1s);
		return cate1s;
	}
	
	
	public List<ProductVO> selectProducts(String prodCate2) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProducts start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS);
			psmt.setString(1, prodCate2);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getInt(2));
				product.setProdCate2(rs.getInt(3));
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
				product.setRdate(rs.getString(27));
				
				products.add(product);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public int selectCountTotal(int prodCate2) {
		
		int total = 0;
		
		try {
			logger.info("selectCountTotal start...");
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(ProductSQL.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();		
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;		
	}
	
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

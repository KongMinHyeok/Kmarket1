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
			logger.info("selectCate1 start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MainSQL.SELECT_KM_PRODUCT_CATE1);
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
	
	// 상품 상세 정보 불러오기
	public ProductVO selectProduct(String prodNo) {
		ProductVO product = null;
		try {
			logger.info("selectProduct start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductVO();
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
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("product : " + product);
		return product;
	}
	// 상품 리스트 불러오기1
	public List<ProductVO> selectProducts1(String prodCate1, String prodCate2, int start) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProducts1 start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS1);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			
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
		logger.debug("products1 : " + products);

		return products;
	}
	// 상품 리스트 불러오기2
		public List<ProductVO> selectProducts2(String prodCate1, String prodCate2, int start) {
			List<ProductVO> products = new ArrayList<>();
			try {
				logger.info("selectProducts2 start...");
				conn = getConnection();
				psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS2);
				psmt.setString(1, prodCate1);
				psmt.setString(2, prodCate2);
				psmt.setInt(3, start);
				
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
			logger.debug("products2 : " + products);

			return products;
		}
		// 상품 리스트 불러오기3
		public List<ProductVO> selectProducts3(String prodCate1, String prodCate2, int start) {
			List<ProductVO> products = new ArrayList<>();
			try {
				logger.info("selectProducts3 start...");
				conn = getConnection();
				psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS3);
				psmt.setString(1, prodCate1);
				psmt.setString(2, prodCate2);
				psmt.setInt(3, start);
				
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
			logger.debug("products3 : " + products);

			return products;
		}
		// 상품 리스트 불러오기4
		public List<ProductVO> selectProducts4(String prodCate1, String prodCate2, int start) {
			List<ProductVO> products = new ArrayList<>();
			try {
				logger.info("selectProducts4 start...");
				conn = getConnection();
				psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS4);
				psmt.setString(1, prodCate1);
				psmt.setString(2, prodCate2);
				psmt.setInt(3, start);
				
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
			logger.debug("products4 : " + products);

			return products;
		}
		// 상품 리스트 불러오기5
		public List<ProductVO> selectProducts5(String prodCate1, String prodCate2, int start) {
			List<ProductVO> products = new ArrayList<>();
			try {
				logger.info("selectProducts5 start...");
				conn = getConnection();
				psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS5);
				psmt.setString(1, prodCate1);
				psmt.setString(2, prodCate2);
				psmt.setInt(3, start);
				
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
			logger.debug("products5 : " + products);

			return products;
		}
		// 상품 리스트 불러오기6
		public List<ProductVO> selectProducts6(String prodCate1, String prodCate2, int start) {
			List<ProductVO> products = new ArrayList<>();
			try {
				logger.info("selectProducts6 start...");
				conn = getConnection();
				psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCTS6);
				psmt.setString(1, prodCate1);
				psmt.setString(2, prodCate2);
				psmt.setInt(3, start);
				
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
			logger.debug("products6 : " + products);

			return products;
		}
	public int selectCountTotal(String prodCate1, String prodCate2) {
		
		int total = 0;
		
		try {
			logger.info("selectCountTotal start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_COUNT_TOTAL);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			
			rs = psmt.executeQuery();

			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();		
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("total : " + total);

		return total;		
	}
	public List<ProductVO> selectProductComments(String prodNo){
		List<ProductVO> comments = new ArrayList<>();
		try {
			logger.info("selectProductComments start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_COMMENTS);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO comment = new ProductVO();
				comment.setProdNo(rs.getInt(2));
				comment.setContent(rs.getString(3));
				comment.setUid(rs.getString(4));
				comment.setRating(rs.getInt(5));
				comment.setRegip(rs.getString(6));
				comment.setRdate(rs.getString(7));
				comments.add(comment);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return comments;
	}
	// cart에 상품 넣기
	public void insertProductCart(String uid, int prodNo, int count, int price, int discount, int point, int delivery, int total, String rdate) {
		ProductVO cart = null;
		try {
			logger.info("insertProductCart...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.INSERT_PRODUCT_CART);
			psmt.setString(1, uid);
			psmt.setInt(2, prodNo);
			psmt.setInt(3, count);
			psmt.setInt(4, price);
			psmt.setInt(5, discount);
			psmt.setInt(6, point);
			psmt.setInt(7, delivery);
			psmt.setInt(8, total);
			psmt.setString(9, rdate);
			
			psmt.executeUpdate();
			
				
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	// 리뷰 총갯수
	public int selectReviewCountTotal(String prodNo) {
		int total = 0;
		
		try {
			logger.info("selectCountTotal start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_REVIEW_COUNT_TOTAL);
			psmt.setString(1, prodNo);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();		
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("total : " + total);

		return total;
	}

	
}
package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;

import kr.co.kmarket1.db.MainSQL;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductReviewVO;
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
	public List<ProductReviewVO> selectProductReviews(String prodNo, int start){
		List<ProductReviewVO> reviews = new ArrayList<>();
		try {
			logger.info("selectProductReviews start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_REVIEWS);
			psmt.setString(1, prodNo);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductReviewVO review= new ProductReviewVO();
				review.setRevNo(rs.getInt(1));
				review.setProdNo(rs.getInt(2));
				review.setContent(rs.getString(3));
				review.setUid(rs.getString(4));
				review.setRating(rs.getInt(5));
				review.setRegip(rs.getString(6));
				review.setRdate(rs.getString(7));
				reviews.add(review);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return reviews;
	}
	// cart에 상품 넣기
	public int insertProductCart(ProductCartVO cart) {
		int result = 0;
		try {
			logger.info("insertProductCart...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.INSERT_PRODUCT_CART);
			psmt.setString(1, cart.getUid());
			psmt.setInt(2, cart.getProdNo());
			psmt.setInt(3, cart.getCount());
			psmt.setInt(4, cart.getPrice());
			psmt.setInt(5, cart.getDiscount());
			psmt.setInt(6, cart.getPoint());
			psmt.setInt(7, cart.getDelivery());
			psmt.setInt(8, cart.getTotal());
			psmt.setString(9, cart.getRdate());
			
			result = psmt.executeUpdate();
			close();
				
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
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
	// cart 목록 불러오기
	public List<ProductCartVO> selectProductCarts(String uid) {
		List<ProductCartVO> carts = new ArrayList<>();
		try {
			logger.info("selectProductCarts start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCT_CARTS);
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductCartVO cart = new ProductCartVO();
				cart.setCartNo(rs.getInt(1));
				cart.setUid(rs.getString(2));
				cart.setProdNo(rs.getInt(3));
				cart.setCount(rs.getInt(4));
				cart.setPrice(rs.getInt(5));
				cart.setDiscount(rs.getInt(6));
				cart.setPoint(rs.getInt(7));
				cart.setDelivery(rs.getInt(8));
				cart.setTotal(rs.getInt(9));
				cart.setRdate(rs.getString(10));
				cart.setProdName(rs.getString(11));
				cart.setDescript(rs.getString(12));
				cart.setThumb3(rs.getString(13));
				carts.add(cart);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("carts : " + carts);
		return carts;
	}

	
}
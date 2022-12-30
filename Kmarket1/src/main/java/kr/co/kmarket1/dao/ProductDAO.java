package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;

import kr.co.kmarket1.db.MainSQL;
import kr.co.kmarket1.db.MemberSQL;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductOrderItemVO;
import kr.co.kmarket1.vo.ProductOrderVO;
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
	public void insertOrderItem(int ordNo, ProductCartVO cart) {
		try {
			logger.info("insertOrderItem start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.INSERT_ORDER_ITEM);
			psmt.setInt(1, ordNo);
			psmt.setInt(2, cart.getProdNo());
			psmt.setInt(3, cart.getCount());
			psmt.setInt(4, cart.getPrice());
			psmt.setInt(5, cart.getDiscount());
			psmt.setInt(6, cart.getPoint());
			psmt.setInt(7, cart.getDelivery());
			psmt.setInt(8, cart.getTotal());
			psmt.executeUpdate();
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
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
			logger.info("insertProductCart start...");
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
			/*psmt.setInt(10, cart.getDirect());*/
			
			result = psmt.executeUpdate();
			close();
				
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	// cart에 중복 상품 확인
	public int selectCountProduct(String prodNo) {
		int check = 0;
		try {
			logger.info("selectCountProduct start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_COUNT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt(1);
			}
			close();		
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("check : " + check);
		return check;
	}
	
	// cart에 상품 있을 때 수정
	public int updateProductCart(ProductCartVO cart) {
		int result = 0;
		try {
			logger.info("updateProductCart start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.UPDATE_PRODUCT_CART);
			psmt.setInt(1, cart.getCount());
			psmt.setInt(2, cart.getProdNo());
			result = psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	public ProductCartVO selectProductOrders(String cartNo) {
		ProductCartVO cart = null;
		try {
			logger.info("selectProductOrders Start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCT_ORDERS);
			psmt.setString(1, cartNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				cart = new ProductCartVO();
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
				
			}
			close();	
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cart : " + cart);
		return cart;
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
	
	// 바로구매 햇을때 상품 불러오기
	public ProductVO selectOrderProduct(String prodNo, String count) {
		ProductVO vo = new ProductVO();
		try {
			logger.info("selectOrderProduct start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setProdNo(rs.getString(1));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setDelivery(rs.getInt(13));
				vo.setThumb1(rs.getString(17));
				vo.setCount(count);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	};
	// 주문 번호로 오더
	public List<ProductCartVO> selectOrders(String cartNo) {
		
		List<ProductCartVO> carts = new ArrayList<>();
		
		try {
			logger.info("selectOrders start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_ORDERS);
			psmt.setString(1, cartNo);
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
				cart.setThumb3(rs.getString(12));
				cart.setDescript(rs.getString(13));
				
				carts.add(cart);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return carts;
	}
	//Order 테이블에 상품 추가
	public int insertCompleteOrder(ProductOrderVO order) {
		int ordNo = 0;
		try {
			logger.info("insertCompleteOrder start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.INSERT_COMPLETE_ORDER);
			
			logger.debug("psmt : " + psmt);
			
			psmt.setString(1, order.getOrdUid());
			psmt.setInt(2, order.getOrdCount());
			psmt.setInt(3, order.getOrdPrice());
			psmt.setInt(4, order.getOrdDiscount());
			psmt.setInt(5, order.getOrdDelivery());
			psmt.setInt(6, order.getSavePoint());
			psmt.setInt(7, order.getUsedPoint());
			psmt.setInt(8, order.getOrdTotPrice());
			psmt.setString(9, order.getRecipName());
			psmt.setString(10, order.getRecipHp());
			psmt.setString(11, order.getRecipZip());
			psmt.setString(12, order.getRecipAddr1());
			psmt.setString(13, order.getRecipAddr2());
			psmt.setInt(14, order.getOrdPayment());
			psmt.setInt(15, order.getOrdComplete());
			psmt.executeUpdate();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(ProductSQL.SELECT_LATEST_ORDER);
			if(rs.next()) {
				ordNo = rs.getInt(1);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("ordNo : " + ordNo);
		return ordNo;
	}
	
	public void insertOrderItem(int ordNo, ProductCartVO cart) {
		try {
			logger.info("insertOrderItem start...");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.INSERT_ORDER_ITEM);
			psmt.setInt(1, ordNo);
			psmt.setInt(2, cart.getProdNo());
			psmt.setInt(3, cart.getCount());
			psmt.setInt(4, cart.getPrice());
			psmt.setInt(5, cart.getDiscount());
			psmt.setInt(6, cart.getPoint());
			psmt.setInt(7, cart.getDelivery());
			psmt.setInt(8, cart.getTotal());
			psmt.executeUpdate();
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
		
		
	// select order info by ordNo
	public ProductOrderVO selectOrderByOrdNo(int ordNo) {
		ProductOrderVO order = null;
		try {
			logger.info("selectOrderByOrdNo called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_ORDER_BY_ORDNO);
			psmt.setInt(1, ordNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				order = new ProductOrderVO();
				order.setOrdNo(rs.getInt(1));
				order.setOrdUid(rs.getString(2));
				order.setOrdCount(rs.getInt(3));
				order.setOrdPrice(rs.getInt(4));
				order.setOrdDiscount(rs.getInt(5));
				order.setOrdDelivery(rs.getInt(6));
				order.setSavePoint(rs.getInt(7));
				order.setUsedPoint(rs.getInt(8));
				order.setOrdTotPrice(rs.getInt(9));
				order.setRecipName(rs.getString(10));
				order.setRecipHp(rs.getString(11));
				order.setRecipZip(rs.getString(12));
				order.setRecipAddr1(rs.getString(13));
				order.setRecipAddr2(rs.getString(14));
				order.setOrdPayment(rs.getInt(15));
				order.setOrdComplete(rs.getInt(16));
				order.setOrdDate(rs.getString(17));
				order.setName(rs.getString(18));
				order.setHp(rs.getString(19));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("order : " + order);
		return order;
	}
	
	// 주문 번호로 주문한 물품들 불러오기
	public List<ProductVO> selectItemsByOrdNo(int ordNo){
		List<ProductVO> items = new ArrayList<>();
		try {
			logger.info("selectItemsByOrdNo called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_ITEMS_BY_ORDNO);
			psmt.setInt(1, ordNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO item = new ProductVO();
				item.setThumb1(rs.getString(1).substring(37)); 
				item.setProdCate1(rs.getInt(2));
				item.setProdCate2(rs.getInt(3));
				item.setProdName(rs.getString(4));
				item.setDescript(rs.getString(5));
				item.setProdNo(rs.getInt(7));
				item.setCount(rs.getInt(8));
				item.setPrice(rs.getInt(9));
				item.setDiscount(rs.getInt(10));
				item.setPoint(rs.getInt(11));
				item.setDelivery(rs.getInt(12));
				item.setTotal(rs.getInt(13));
				items.add(item);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("items : " + items);
		return items;
	}


	
}
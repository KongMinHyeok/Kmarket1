package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.MemberSQL;
import kr.co.kmarket1.vo.OrderVO;
import kr.co.kmarket1.vo.ProductVO;

public class ProductCompleteDAO extends DBHelper{
	private static ProductCompleteDAO instance = new ProductCompleteDAO();
	public static ProductCompleteDAO getInstance() {
		return instance;
	}
	private ProductCompleteDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// select order info by ordNo
	public OrderVO selectOrderByOrdNo(int ordNo) {
		OrderVO order = null;
		try {
			logger.info("selectOrderByOrdNo called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_ORDER_BY_ORDNO);
			psmt.setInt(1, ordNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				order = new OrderVO();
				order.setOrdNo(rs.getInt(1));
				order.setOrdUid(rs.getString(2));
				order.setOrdCount(rs.getInt(3));
				order.setOrdPrice(rs.getInt(4));
				order.setOrdDiscount(rs.getInt(5));
				order.setOrdDelivery(rs.getInt(6));
				order.setSavePoint(rs.getInt(7));
				order.setUsedPoint(rs.getInt(8));
				order.setOrdTotPrice(rs.getInt(9));
				order.setRecipname(rs.getString(10));
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
			psmt = conn.prepareStatement(MemberSQL.SELECT_ITEMS_BY_ORDNO);
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

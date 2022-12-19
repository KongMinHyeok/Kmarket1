package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.ProductCompleteDAO;
import kr.co.kmarket1.vo.OrderVO;
import kr.co.kmarket1.vo.ProductVO;

public enum ProductCompleteService {
	INSTANCE;
	private ProductCompleteDAO dao = ProductCompleteDAO.getInstance();
	
	// 주문 번호로 주문(자) 정보 불러오기
	public OrderVO selectOrderByOrdNo(int ordNo) {
		return dao.selectOrderByOrdNo(ordNo);
	}
	
	// 주문 번호로 주문한 물품들 불러오기
	public List<ProductVO> selectItemsByOrdNo(int ordNo) {
		return dao.selectItemsByOrdNo(ordNo);
	}
}

package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.vo.ProductVO;

public enum ProductService {
	
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	public int selectCountTotal(String prodCate1, String prodCate2) {
		return dao.selectCountTotal(prodCate1, prodCate2);
	}
	
	// 마지막 페이지 번호
		public int getLastPageNum(int total) {
			int lastPageNum =0;
			
			if(total % 10 == 0){
				lastPageNum = total /10;
			}else {
				lastPageNum = total /10 + 1;
			}
			return lastPageNum;
		}
		
		// 페이지 그룹 시작,끝
		public int[] getPageGroupNum(int currentPage, int lastPageNum) {
			int currentPageGroup = (int) Math.ceil(currentPage /10.0);
			int pageGroupStart = (currentPageGroup -1)*10 + 1;
			int pageGroupEnd = currentPageGroup *10;
			
			if(pageGroupEnd > lastPageNum) {
				pageGroupEnd = lastPageNum;
			}
			int[] result = {currentPageGroup, pageGroupStart, pageGroupEnd};
			return result;
		}
		
		// 리스트 불러오기 1,2,3,4,5,6
		public List<ProductVO> selectProducts1(int start, String prodCate1, String prodCate2) {
			return dao.selectProducts1(prodCate1, prodCate2, start);
		}
		public List<ProductVO> selectProducts2(int start, String prodCate1, String prodCate2) {
			return dao.selectProducts2(prodCate1, prodCate2, start);
		}
		public List<ProductVO> selectProducts3(int start, String prodCate1, String prodCate2) {
			return dao.selectProducts3(prodCate1, prodCate2, start);
		}
		public List<ProductVO> selectProducts4(int start, String prodCate1, String prodCate2) {
			return dao.selectProducts4(prodCate1, prodCate2, start);
		}
		public List<ProductVO> selectProducts5(int start, String prodCate1, String prodCate2) {
			return dao.selectProducts5(prodCate1, prodCate2, start);
		}
		public List<ProductVO> selectProducts6(int start, String prodCate1, String prodCate2) {
			return dao.selectProducts6(prodCate1, prodCate2, start);
		}
		
		// 상품 상세정보 불러오기(view 페이지)
		public ProductVO selectProduct(String prodNo) {
			return dao.selectProduct(prodNo);
		};
		
		// 리뷰 불러오기(view 페이지)
		public List<ProductVO> selectProductComments(String prodNo){
			return dao.selectProductComments(prodNo);
		}
		
		// 리뷰 총갯수
		public int selectReviewCountTotal(String prodNo) {
			return dao.selectReviewCountTotal(prodNo);
		}
		
		
		/*
		// cart에 상품 추가
		public ProductVO insertProductCart() {
			return dao.insertProductCart();
		};
		*/
		
	


}
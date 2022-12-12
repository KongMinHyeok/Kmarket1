package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.ProductDAO;

public enum ProductService {
	
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	public int selectCountTotal(String prodCate2) {
		return dao.selectCountTotal(prodCate2);
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
	


}

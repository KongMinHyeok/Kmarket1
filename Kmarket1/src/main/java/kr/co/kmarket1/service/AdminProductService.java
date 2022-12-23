package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.AdminProductListDAO;

public enum AdminProductService {
	
	INSTANCE;
	AdminProductListDAO dao = AdminProductListDAO.getInstance();
	
	//마지막 Page
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	//Page 그룹
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		int[] result = {pageGroupStart, pageGroupEnd};
		return result;
	}
	
	//첫번째 Page
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	
	//현재 Page
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null && !pg.equals("")){
			currentPage = Integer.parseInt(pg);	
		}
		return currentPage;
	}
	
	//시작 번호
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}

}

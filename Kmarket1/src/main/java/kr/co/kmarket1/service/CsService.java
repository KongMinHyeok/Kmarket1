package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.CsDAO;
import kr.co.kmarket1.vo.CsNoticeVO;
import kr.co.kmarket1.vo.CsQnaVO;

public enum CsService {
	instance;
	
	private CsDAO dao = CsDAO.getInstance();
	
	public List<CsQnaVO> selectQnas() {
		return dao.selectQnas();
	}

	public List<CsNoticeVO> selectNotices() {
		return dao.selectNotices();
	}
	
	
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	public int[] getPageGroupNum (int currentPage, int lastPageNum) {
		int currentPageGroup = (int) Math.ceil(currentPage /10.0);
		int pageGroupStart = (currentPageGroup -1) * 10+1;
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		
		int[] result = {pageGroupStart, pageGroupEnd};
		
		return result;
	}
	
	public CsNoticeVO selectArticleNotice(String no) {
		return dao.selectArticleNotice(no);
	}
	
}

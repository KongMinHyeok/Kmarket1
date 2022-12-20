package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.CsDAO;
import kr.co.kmarket1.vo.CsArticleVO;


public enum CsService {
	instance;
	
	private CsDAO dao = CsDAO.getInstance();
	
	public List<CsArticleVO> selectQnas() {
		return dao.selectQnas();
	}

	public List<CsArticleVO> selectNotices() {
		return dao.selectNotices();
	}
	
	public List<CsArticleVO> selectFaq() {
		return dao.selectFaq();
	}
	public List<CsArticleVO> selectFaqs() {
		return dao.selectFaqs();
	}
	
	public List<CsArticleVO> selectFaqsCate2(String cate) {
		return dao.selectFaqsCate2(cate);
	}
	
	public CsArticleVO selectFaqArticle(String no) {
		return dao.selectFaqArticle(no);
	}
	public CsArticleVO selectCateQna() {
		return dao.selectCateQna();
	}
	public void insertArticleQna(CsArticleVO article) {
		 dao.insertArticleQna(article);
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
	
	public CsArticleVO selectArticleNotice(String no) {
		return dao.selectArticleNotice(no);
	}
	
	public CsArticleVO selectArticleQna(String no) {
		return dao.selectArticleQna(no);
	}
}

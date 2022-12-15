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
}

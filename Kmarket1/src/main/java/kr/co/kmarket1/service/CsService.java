package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.CsDAO;
import kr.co.kmarket1.vo.CsNoticeVO;

public enum CsService {
	instance;
	
	private CsDAO dao = CsDAO.getInstance();
	
	public CsNoticeVO selectNotice(String no) {
		return dao.selectNotice(no);
	}

	public List<CsNoticeVO> selectNotices(int start) {
		return dao.selectNotices(start);
	}
}

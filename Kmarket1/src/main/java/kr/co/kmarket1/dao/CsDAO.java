package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.CsSQL;
import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.vo.CsNoticeVO;
import kr.co.kmarket1.vo.CsQnaVO;

public class CsDAO extends DBHelper{
	private static CsDAO instance = new CsDAO();
	public static CsDAO getInstance() {
		return instance;
	}
	
	private CsDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public CsNoticeVO selectNotice(String no) {
		CsNoticeVO notice = null;
			
		try {
			logger.info("selectNotice start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_NOTICE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				notice = new CsNoticeVO();
				notice.setNo(rs.getInt(1));
				notice.setParent(rs.getInt(2));
				notice.setComment(rs.getInt(3));
				notice.setCate(rs.getString(4));
				notice.setTitle(rs.getString(5));
				notice.setContent(rs.getString(6));
				notice.setHit(rs.getInt(7));
				notice.setUid(rs.getString(8));
				notice.setRegip(rs.getString(9));
				notice.setRdate(rs.getString(10));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notice : " + notice);
		return notice;
	}
	
	public List<CsNoticeVO> selectNotices() {
		
		List<CsNoticeVO> notices = new ArrayList<>();
		
		try {
			logger.info("selectNotices call...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_NOTICES);
			
			while(rs.next()) {
				CsNoticeVO notice = new CsNoticeVO();
				notice.setNo(rs.getInt(1));
				notice.setParent(rs.getInt(2));
				notice.setComment(rs.getInt(3));
				notice.setCate(rs.getString(4));
				notice.setTitle(rs.getString(5));
				notice.setContent(rs.getString(6));
				notice.setHit(rs.getInt(7));
				notice.setUid(rs.getString(8));
				notice.setRegip(rs.getString(9));
				notice.setRdate(rs.getString(10).substring(2, 10));
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices : " + notices);
		return notices;
	}
	public void selectFaq() {}
	public List<CsQnaVO> selectQnas() {
		
		List<CsQnaVO> Qnas = new ArrayList<>();
		
		try {
			logger.info("selectQna call...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_QNAS);
			
			while(rs.next()) {
				CsQnaVO qna = new CsQnaVO();
				qna.setNo(rs.getInt(1));
				qna.setParent(rs.getInt(2));
				qna.setComment(rs.getInt(3));
				qna.setCate(rs.getString(4));
				qna.setTitle(rs.getString(5));
				qna.setContent(rs.getString(6));
				qna.setHit(rs.getInt(7));
				qna.setUid(rs.getString(8));
				qna.setRegip(rs.getString(9));
				qna.setRdate(rs.getString(10).substring(2, 10));
				
				Qnas.add(qna);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("Qnas : " + Qnas);
		return Qnas;
	}
	
}

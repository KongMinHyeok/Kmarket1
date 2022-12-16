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
				notice.setComment(rs.getInt(2));
				notice.setCate(rs.getString(3));
				notice.setTitle(rs.getString(4));
				notice.setContent(rs.getString(5));
				notice.setUid(rs.getString(6));
				notice.setRegip(rs.getString(7));
				notice.setRdate(rs.getString(8));
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
				notice.setComment(rs.getInt(2));
				notice.setCate(rs.getString(3));
				notice.setTitle(rs.getString(4));
				notice.setContent(rs.getString(5));
				notice.setUid(rs.getString(6));
				notice.setRegip(rs.getString(7));
				notice.setRdate(rs.getString(8).substring(2, 10));
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices : " + notices);
		return notices;
	}

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
				qna.setComment(rs.getInt(2));
				qna.setCate(rs.getString(3));
				qna.setTitle(rs.getString(4));
				qna.setContent(rs.getString(5));
				qna.setUid(rs.getString(6));
				qna.setRegip(rs.getString(7));
				qna.setRdate(rs.getString(8).substring(2, 10));
				
				Qnas.add(qna);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("Qnas : " + Qnas);
		return Qnas;
	}
	
	public int selectCountNotice(String cate) {
		
		int total = 0;
		
		try {
			logger.info("selectCountNotice... start");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_COUNT_NOTICE);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("total : " + total);
		return total;
	}
	
	public int selectCountNotices() {
		
		int total = 0;
		
		try {
			logger.info("selectCountNotices... start");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_COUNT_NOTICES);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("total : " + total);
		return total;
	}
	
	public List<CsNoticeVO> selectNoticesGroup(int start) {
		
		List<CsNoticeVO> notices = new ArrayList<>();
		
		try {
			logger.info("selectNoticesGroup start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_NOTICES_GROUP);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsNoticeVO notice = new CsNoticeVO();
				notice.setNo(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setRdate(rs.getString(3).substring(2,10));
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices" + notices);
		return notices;
	}
	public List<CsNoticeVO> selectNoticesCate(String cate, int start) {
		
		List<CsNoticeVO> notices = new ArrayList<>();
		
		try {
			logger.info("selectNoticesCate start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_NOTICES_CATE);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsNoticeVO notice = new CsNoticeVO();
				notice.setNo(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setRdate(rs.getString(3));
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices" + notices);
		
		return notices;
	}
	
	public CsNoticeVO selectArticleNotice(String no) {
		
		CsNoticeVO notice = null;
		
		try {
			logger.info("selectArticleNotice start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE_NOTICE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				notice = new CsNoticeVO();
				notice.setTitle(rs.getString(1));
				notice.setRdate(rs.getString(2).substring(2, 10));
				notice.setContent(rs.getString(3));
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notice : " + notice );
		return notice;
	}
	public void selectFaq() {}
}

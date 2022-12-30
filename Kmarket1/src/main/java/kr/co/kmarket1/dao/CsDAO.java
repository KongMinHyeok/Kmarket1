package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.CsSQL;
import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.vo.CsArticleVO;

public class CsDAO extends DBHelper{
	private static CsDAO instance = new CsDAO();
	public static CsDAO getInstance() {
		return instance;
	}
	
	private CsDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public List<CsArticleVO> selectNotices() {
		
		List<CsArticleVO> notices = new ArrayList<>();
		
		try {
			logger.info("selectNotices call...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_NOTICES);
			
			while(rs.next()) {
				CsArticleVO notice = new CsArticleVO();
				notice.setNo(rs.getInt(1));
				notice.setComment(rs.getString(2));
				notice.setCate(rs.getString(3));
				notice.setTitle(rs.getString(4));
				notice.setContent(rs.getString(5));
				notice.setHit(rs.getInt(6));
				notice.setUid(rs.getString(7));
				notice.setRegip(rs.getString(8));
				notice.setRdate(rs.getString(9).substring(2, 10));
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices : " + notices);
		return notices;
	}

	public List<CsArticleVO> selectQnas() {
		
		List<CsArticleVO> Qnas = new ArrayList<>();
		
		try {
			logger.info("selectQna call...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_QNAS);
			
			while(rs.next()) {
				CsArticleVO qna = new CsArticleVO();
				qna.setNo(rs.getInt(1));
				qna.setComment(rs.getString(2));
				qna.setCate(rs.getString(3));
				qna.setCate2(rs.getString(4));
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
	
	public List<CsArticleVO> selectNoticesGroup(int start) {
		
		List<CsArticleVO> notices = new ArrayList<>();
		
		try {
			logger.info("selectNoticesGroup start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_NOTICES_GROUP);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleVO notice = new CsArticleVO();
				notice.setNo(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setUid(rs.getString(3));
				notice.setHit(rs.getInt(4));
				notice.setRdate(rs.getString(5).substring(2,10));
				notice.setCate(rs.getString(6));	
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices" + notices);
		return notices;
	}
	public List<CsArticleVO> selectNoticesCate(String cate, int start) {
		
		List<CsArticleVO> notices = new ArrayList<>();
		
		try {
			logger.info("selectNoticesCate start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_NOTICES_CATE);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleVO notice = new CsArticleVO();
				notice.setNo(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setUid(rs.getString(3));
				notice.setHit(rs.getInt(4));
				notice.setRdate(rs.getString(5).substring(2, 10));
				notice.setCate(rs.getString(6));
				
				notices.add(notice);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notices" + notices);
		
		return notices;
	}
	
	public CsArticleVO selectArticleNotice(String no) {
		
		CsArticleVO notice = null;
		
		try {
			logger.info("selectArticleNotice start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE_NOTICE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				notice = new CsArticleVO();
				notice.setNo(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setUid(rs.getString(3));
				notice.setRdate(rs.getString(4).substring(2, 10));
				notice.setContent(rs.getString(5));
				notice.setCate(rs.getString(6));

			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notice : " + notice );
		return notice;
	}
	
	public void updateNoticeHit(String no) {
		try {
			logger.info("updateNoticeHit start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.UPDATE_NOTICE_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public List<CsArticleVO> selectFaq() {
			
		List<CsArticleVO> faqs = new ArrayList<>();
		
		try {
			logger.info("selectfaq call...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_FAQ);
			
			while(rs.next()) {
				CsArticleVO faq = new CsArticleVO();
				faq.setNo(rs.getInt(1));
				faq.setComment(rs.getString(2));
				faq.setCate(rs.getString(3));
				faq.setCate2(rs.getString(4));
				faq.setTitle(rs.getString(5));
				faq.setContent(rs.getString(6));
				faq.setHit(rs.getInt(7));
				faq.setUid(rs.getString(8));
				faq.setRegip(rs.getString(9));
				faq.setRdate(rs.getString(10).substring(2, 10));
				
				faqs.add(faq);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("faqs : " + faqs);
		return faqs;
	}
	
public List<CsArticleVO> selectFaqCate(){
		
		List<CsArticleVO> cates = new ArrayList<>();
		
		try {
			logger.info("selectcate start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_FAQ_CATE1);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleVO ct = new CsArticleVO();
				ct.setCate(rs.getString(1));
				
				cates.add(ct);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cates;
	}
	
	public List<CsArticleVO> selectFaqs() {
		
		List<CsArticleVO> faqs = new ArrayList<>();
		
		try {
			logger.info("selectfaqs call...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_FAQ);
			
			while(rs.next()) {
				CsArticleVO faq = new CsArticleVO();
				faq.setNo(rs.getInt(1));
				faq.setCate(rs.getString(2));
				faq.setCate2(rs.getString(3));
				faq.setTitle(rs.getString(4));
				faqs.add(faq);
			}	
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("faqs : " + faqs);
		return faqs;
	}
	
	public List<CsArticleVO> selectFaqsCate2(String cate) {
		
		List<CsArticleVO> faqct2 = new ArrayList<>();
		
		try {
			logger.info("selectfaqCate2 start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_FAQ_CATE);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleVO ct = new CsArticleVO();
				ct.setCate2(rs.getString(1));
				
				faqct2.add(ct);
			}	
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cate2 : " + faqct2);
		return faqct2;
	}
	
	public CsArticleVO selectFaqArticle(String no) {
		
		
		CsArticleVO article = null;
		
		try {
			logger.info("selectFaqArticle start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_FAQ_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				article = new CsArticleVO();
				article.setNo(rs.getInt(1));
				article.setCate(rs.getString(2));
				article.setCate2(rs.getString(3));
				article.setTitle(rs.getString(4));
				article.setContent(rs.getString(5));
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
			logger.debug("faqArticle : " + article);
		return article;
	}
	
public List<CsArticleVO> selectQnasGroup(int start) {
		
		List<CsArticleVO> qnas = new ArrayList<>();
		
		try {
			logger.info("selectQnasGroup start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_QNAS_GROUP);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleVO qna = new CsArticleVO();
				qna.setNo(rs.getInt(1));
				qna.setCate2(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setUid(rs.getString(4));
				qna.setRdate(rs.getString(5).substring(2,10));
				qna.setCate(rs.getString(6));
				qna.setComment(rs.getString(7));
				
				qnas.add(qna);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("qnas" + qnas);
		return qnas;
	}

	public List<CsArticleVO> selectQnasCate(String cate, int start) {
		
		List<CsArticleVO> qnas = new ArrayList<>();
		
		try {
			logger.info("selectQnasCate start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_QNAS_CATE);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleVO qna = new CsArticleVO();
				qna.setNo(rs.getInt(1));
				qna.setCate2(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setUid(rs.getString(4));
				qna.setRdate(rs.getString(5).substring(2, 10));
				qna.setCate(rs.getString(6));
				qna.setComment(rs.getString(7));
				
				qnas.add(qna);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("qnas" + qnas);
		
		return qnas;
	}
	
	public int selectCountQna(String cate) {
		
		int total = 0;
		
		try {
			logger.info("selectCountQna... start");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_COUNT_QNA);
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
	
	public int selectCountQnas() {
		
		int total = 0;
		
		try {
			logger.info("selectCountQnas... start");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_COUNT_QNAS);
			
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
	
	public CsArticleVO selectArticleQna(String no) {
		
		CsArticleVO qna = new CsArticleVO();
		
		try {
			logger.info("selectArticleQna start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE_QNA);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				qna.setNo(rs.getInt(1));
				qna.setCate2(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setUid(rs.getString(4));
				qna.setRdate(rs.getString(5).substring(2, 10));
				qna.setContent(rs.getString(6));
				qna.setCate(rs.getString(7));
				qna.setComment(rs.getString(8));

			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("qna : " + qna );
		return qna;
	}

	public CsArticleVO selectCateQna() {
		
		CsArticleVO qna = new CsArticleVO();
		
		try {
			logger.info("selectCateQna start...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSQL.SELECT_CATE_QNA);
			
			if(rs.next()) {
				qna.setCate(rs.getString(1));
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return qna;
	}
	
	public void insertArticleQna(CsArticleVO article) {
		
		try {
			logger.info("insertArticleQna start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.INSERT_ARTICLE_QNA);
			psmt.setString(1, article.getUid());
			psmt.setString(2, article.getCate());
			psmt.setString(3, article.getCate2());
			psmt.setString(4, article.getTitle());
			psmt.setString(5, article.getContent());
			psmt.setString(6, article.getRegip());
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void insertCommentQna(String comment, String no) {
		
		try {
			logger.info("insertCommentQna start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.INSERT_COMMENT_QNA);
			psmt.setString(1, comment);
			psmt.setString(2, no);
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("comment : " + comment);
		
	}
	
	public int deleteqna(String no) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.DELETE_QNA);
			psmt.setString(1, no);
			result += psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("qna delete : " + no + "result : " + result);
		return result;
	}
	
	public void insertArticleNotice(CsArticleVO article) {
		
		try {
			logger.info("insertArticleNotice start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.INSERT_ARTICLE_NOTICE);
			psmt.setString(1, article.getUid());
			psmt.setString(2, article.getCate());
			psmt.setString(3, article.getTitle());
			psmt.setString(4, article.getContent());
			psmt.setString(5, article.getRegip());
			psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("insertArticleNotice : " + article);
	}
	
	public int deleteNotice(String no) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.DELETE_NOTICE);
			psmt.setString(1, no);
			result += psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notice delete : " + no + "result : " + result);
		return result;
	}
	
	public void updateNotice(String no, String cate, String title, String content) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.UPDATE_NOTICE);	
			psmt.setString(1, cate);
			psmt.setString(2, title);
			psmt.setString(3, content);
			psmt.setString(4, no);
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("notice update : " + no);
	}
	
	
	public void insertArticleFaq(CsArticleVO article) {
		
		try {
			logger.info("insertArticleFaq start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.INSERT_ARTICLE_FAQ);
			psmt.setString(1, article.getUid());
			psmt.setString(2, article.getCate());
			psmt.setString(3, article.getCate2());
			psmt.setString(4, article.getTitle());
			psmt.setString(5, article.getContent());
			psmt.setString(6, article.getRegip());
			psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("insertArticleFaq : " + article);
	}
	
	public void updateFaq(String no, String cate, String cate2, String title, String content) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.UPDATE_FAQ);	
			psmt.setString(1, cate);
			psmt.setString(2, cate2);
			psmt.setString(3, title);
			psmt.setString(4, content);
			psmt.setString(5, no);
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("Faq update : " + no);
	}
	
	public void updateFaqHit(String no) {
		try {
			logger.info("updateFaqHit start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.UPDATE_FAQ_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public int deleteFaq(String no) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.DELETE_FAQ);
			psmt.setString(1, no);
			result += psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("Faq delete : " + no + "result : " + result);
		return result;
	}
}

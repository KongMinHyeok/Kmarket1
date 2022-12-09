package kr.co.kmarket1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.MemberSQL;
import kr.co.kmarket1.vo.MemberVO;

public class MemberDAO extends DBHelper{
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// insert
	
	// select
	public MemberVO selectMember(String uid, String pass) {
		MemberVO member = null;
		try {
			logger.info("selectMember called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_MEMBER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setUid(rs.getString(1));
				member.setPass(rs.getString(2));
				member.setName(rs.getString(3));
				member.setGender(rs.getInt(4));
				member.setHp(rs.getString(5));
				member.setEmail(rs.getString(6));
				member.setType(rs.getInt(7));
				member.setPoint(rs.getInt(8));
				member.setLevel(rs.getInt(9));
				member.setZip(rs.getString(10));
				member.setAddr1(rs.getString(11));
				member.setAddr2(rs.getString(12));
				member.setCompany(rs.getString(13));
				member.setCeo(rs.getString(14));
				member.setBizRegNum(rs.getString(15));
				member.setComRegNum(rs.getString(16));
				member.setTel(rs.getString(17));
				member.setManager(rs.getString(18));
				member.setManagerHp(rs.getString(19));
				member.setFax(rs.getString(20));
				member.setRegip(rs.getString(21));
				member.setWdate(rs.getString(22));
				member.setRdate(rs.getString(23));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("member " + member);
		return member;
	}
	
	public MemberVO selectMemberBySessId(String sessId) {
		MemberVO member = null;
		try {
			logger.info("selectMemberBySessId called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_MEMBER_BY_SESSID);
			psmt.setString(1, sessId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setUid(rs.getString(1));
				member.setPass(rs.getString(2));
				member.setName(rs.getString(3));
				member.setGender(rs.getInt(4));
				member.setHp(rs.getString(5));
				member.setEmail(rs.getString(6));
				member.setType(rs.getInt(7));
				member.setPoint(rs.getInt(8));
				member.setLevel(rs.getInt(9));
				member.setZip(rs.getString(10));
				member.setAddr1(rs.getString(11));
				member.setAddr2(rs.getString(12));
				member.setCompany(rs.getString(13));
				member.setCeo(rs.getString(14));
				member.setBizRegNum(rs.getString(15));
				member.setComRegNum(rs.getString(16));
				member.setTel(rs.getString(17));
				member.setManager(rs.getString(18));
				member.setManagerHp(rs.getString(19));
				member.setFax(rs.getString(20));
				member.setRegip(rs.getString(21));
				member.setWdate(rs.getString(22));
				member.setRdate(rs.getString(23));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("member " + member);
		return member;
	}
	
	public String[] selectTerms() {
		String[] terms = new String[5];
		try {
			logger.info("selectTerms called");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(MemberSQL.SELECT_TERMS);
			
			while(rs.next()) {
				terms[0] = rs.getString(1);
				terms[1] = rs.getString(2);
				terms[2] = rs.getString(3);
				terms[3] = rs.getString(4);
				terms[4] = rs.getString(5);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("terms length " + terms.length);
		return terms;
	}
	
	public int selectCountUid(String uid) {
		int result = 0;
		try {
			logger.info("selectCountUid called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result " + result);
		return result;
	}
	
	// update
	public void updateMemberForSession(String uid, String sessId) {
		try {
			logger.info("updateMemberForSession called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.UPDATE_MEMBER_FOR_SESSION);
			psmt.setString(1, sessId);
			psmt.setString(2, uid);
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void updateMemberForSessionOut(String uid) {
		try {
			logger.info("updateMemberForSessionOut called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.UPDATE_MEMBER_FOR_SESSION_OUT);
			psmt.setString(1, uid);
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// delete
}
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
	public void insertMember(MemberVO member) {
		try {
			logger.info("insertMember called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.INSERT_MEMBER);
			psmt.setString(1, member.getUid());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			psmt.setInt(4, member.getGender());
			psmt.setString(5, member.getHp());
			psmt.setString(6, member.getEmail());
			psmt.setInt(7, member.getType());
			psmt.setInt(8, member.getPoint());
			psmt.setInt(9, member.getLevel());
			psmt.setString(10, member.getZip());
			psmt.setString(11, member.getAddr1());
			psmt.setString(12, member.getAddr2());
			psmt.setString(13, member.getRegip());
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void insertSellerMember(MemberVO seller) {
		try {
			logger.info("insertSellerMember called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.INSERT_SELLER_MEMBER);
			psmt.setString(1, seller.getUid());
			psmt.setString(2, seller.getPass());
			psmt.setString(3, seller.getName());
			psmt.setString(4, seller.getHp());
			psmt.setString(5, seller.getEmail());
			psmt.setString(6, seller.getZip());
			psmt.setString(7, seller.getAddr1());
			psmt.setString(8, seller.getAddr2());
			psmt.setString(9, seller.getCompany());
			psmt.setString(10, seller.getCeo());
			psmt.setString(11, seller.getBizRegNum());
			psmt.setString(12, seller.getComRegNum());
			psmt.setString(13, seller.getTel());
			psmt.setString(14, seller.getManager());
			psmt.setString(15, seller.getManagerHp());
			psmt.setString(16, seller.getFax());
			psmt.setString(17, seller.getRegip());
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
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
	
	public int selectCountReg(String reg) {
		int result = 0;
		try {
			logger.info("selectCountReg called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_COUNT_REG);
			psmt.setString(1, reg);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("result " + result);
		return result;
	}
	
	public String selectMemberByContact(String name, String contact) {
		String result = null;
		try {
			logger.info("selectMemberByContact called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_MEMBER_BY_CONTACT);
			psmt.setString(1, name);
			psmt.setString(2, contact);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString(1);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result: " + result);
		return result;
	}
	
	public int selectMemberByContact(String name, String contact, String uid) {
		int result = 0;
		try {
			logger.info("selectMemberByContact called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_COUNT_MEMBER_BY_CONTACT);
			psmt.setString(1, name);
			psmt.setString(2, contact);
			psmt.setString(3, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result: " + result);
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
	
	public int updatePass(String pass, String uid) {
		int result = 0;
		try {
			logger.info("updatePass called");
			
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.UPDATE_PASS);
			psmt.setString(1, pass);
			psmt.setString(2, uid);
			result = psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result " + result);
		return result;
	}
	
	// delete
}

package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.MemberDAO;
import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.MemberVO;

public enum MemberService{
	INSTANCE;
	private MemberDAO dao = MemberDAO.getInstance();
	
	// insert
	public void insertMember(MemberVO member) {
		dao.insertMember(member);
	}
	public void insertSellerMember(MemberVO seller) {
		dao.insertSellerMember(seller);
	}
	
	// select
	public MemberVO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public MemberVO selectMemberBySessId(String sessId) {
		return dao.selectMemberBySessId(sessId);
	}
	public String[] selectTerms() {
		return dao.selectTerms();
	}
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountReg(String reg) {
		return dao.selectCountReg(reg);
	}
	public String selectMemberByContact(String name, String contact) {
		return dao.selectMemberByContact(name, contact);
	}
	public int selectMemberByContact(String name, String contact, String uid) {
		return dao.selectMemberByContact(name, contact, uid);
	}
	
	// update
	public void updateMemberForSession(String uid, String sessId) {
		dao.updateMemberForSession(uid, sessId);
	}
	public void updateMemberForSessionOut(String uid) {
		dao.updateMemberForSessionOut(uid);
	}
	public int updatePass(String pass, String uid) {
		return dao.updatePass(pass, uid);
	}
	
	// delete
	
	
	
	
	
	

}

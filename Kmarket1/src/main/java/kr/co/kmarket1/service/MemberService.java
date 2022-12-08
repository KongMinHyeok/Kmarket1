package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.MemberDAO;
import kr.co.kmarket1.vo.MemberVO;

public enum MemberService{
	INSTANCE;
	private MemberDAO dao = MemberDAO.getInstance();
	
	// insert
	
	// select
	public MemberVO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public MemberVO selectMemberBySessId(String sessId) {
		return dao.selectMemberBySessId(sessId);
	}
	
	// update
	public void updateMemberForSession(String uid, String sessId) {
		dao.updateMemberForSession(uid, sessId);
	}
	public void updateMemberForSessionOut(String uid) {
		dao.updateMemberForSessionOut(uid);
	}
	// delete
}

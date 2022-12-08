package kr.co.kmarket1.db;

public class SQL {
	// member
	// insert
	
	// select
	public static final String SELECT_MEMBER = "select * from `km_member` where `uid`=? and `pass`=?";
	public static final String SELECT_MEMBER_BY_SESSID= "select * from `km_member` where `sessId`=?";
	
	// update
	public static final String UPDATE_MEMBER_FOR_SESSION ="update `km_member` set `sessId`=?, `sessDateLimit`=DATE_ADD(NOW(), INTERVAL 3 DAY) where `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "update `km_member` set `sessId`=NULL, `sessDateLimit`=NULL where `uid`=?";
	
	// delete
}

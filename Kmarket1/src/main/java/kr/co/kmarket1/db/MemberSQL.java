package kr.co.kmarket1.db;

public class MemberSQL {
	// member
	// insert
	public static final String INSERT_MEMBER = "insert into `km_member` set "
											+ "`uid`=?, `pass`=SHA2(?, 256), `name`=?, `gender`=?, `hp`=?, `email`=?, "
											+ "`type`=?, `point`=?, `level`=?, "
											+ "`zip`=?, `addr1`=?, `addr2`=?, "
											+ "`regip`=?, `rdate`=NOW()";
	public static final String INSERT_SELLER_MEMBER = "insert into `km_member` set"
											+ "`uid`=?, `pass`=SHA2(?, 256), `name`=?, `gender`=1, `hp`=?, `email`=?, "
											+ "`type`=2, `level`=5, `zip`=?, `addr1`=?, `addr2`=?, "
											+ "`company`=?, `ceo`=?, `bizRegNum`=?, `comRegNum`=?, "
											+ "`tel`=?, `manager`=?, `managerHp`=?, `fax`=?, `regip`=?, `rdate`=NOW()";
	
	// select
	public static final String SELECT_MEMBER = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String SELECT_MEMBER_BY_SESSID= "select * from `km_member` where `sessId`=?";
	public static final String SELECT_TERMS = "select * from `km_member_terms`";
	public static final String SELECT_COUNT_UID = "select count(*) from `km_member` where `uid`=?";
	public static final String SELECT_COUNT_REG = "select count(*) from `km_member` where `bizRegNum`=?";
	public static final String SELECT_MEMBER_BY_CONTACT = "select * from `km_member` where `name`=? and `email`=?";
	
	// update
	public static final String UPDATE_MEMBER_FOR_SESSION ="update `km_member` set `sessId`=?, `sessDateLimit`=DATE_ADD(NOW(), INTERVAL 3 DAY) where `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "update `km_member` set `sessId`=NULL, `sessDateLimit`=NULL where `uid`=?";
	
	// delete
}

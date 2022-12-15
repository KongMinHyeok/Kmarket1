package kr.co.kmarket1.db;

public class CsSQL {

	public static final String SELECT_NOTICE = "select * from `km_cs_notice` where `no`=?";
	
	public static final String SELECT_NOTICES = "select * from `km_cs_notice`"
												+"where `parent`=0 "
												+"order by `no` DESC "
												+"limit 0, 5";
	
	public static final String SELECT_QNAS = "select * from `km_cs_qna`"
										+"where `parent`=0 "
										+"order by `no` DESC "
										+"limit 0, 5";
}

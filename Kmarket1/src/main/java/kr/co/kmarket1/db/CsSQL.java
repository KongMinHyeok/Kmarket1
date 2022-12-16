package kr.co.kmarket1.db;

public class CsSQL {

	public static final String SELECT_NOTICE = "select * from `km_cs_notice` where `no`=?";
	
	public static final String SELECT_NOTICES = "select * from `km_cs_notice`"
												+"order by `no` DESC "
												+"limit 0, 5";
	
	public static final String SELECT_QNAS = "select * from `km_cs_qna`"
											+"order by `no` DESC "
											+"limit 0, 5";
	
	public static final String SELECT_COUNT_NOTICE = "select count(`no`) from `km_cs_notice` where `cate`=?";
	public static final String SELECT_COUNT_NOTICES = "select count(`no`) from `km_cs_notice`";
	public static final String SELECT_NOTICES_GROUP = "select `no`, `title`, `rdate` from `km_cs_notice` "
													+"order by `no` DESC "
													+"limit ?, 10";
	
	public static final String SELECT_NOTICES_CATE = "select `no`, `title`, `rdate` from `km_cs_notice` "
													+"where `cate`=?"
													+"order by `no` DESC "
													+"limit ?, 10";
	
	public static final String SELECT_ARTICLE_NOTICE = "select `title`, `rdate`, `content` from `km_cs_notice` where `no`=?";
}

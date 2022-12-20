package kr.co.kmarket1.db;

public class CsSQL {

	public static final String SELECT_NOTICE = "select * from `km_cs_notice` where `no`=?";
	
	public static final String SELECT_NOTICES = "select * from `km_cs_notice`"
												+"order by `no` DESC "
												+"limit 0, 5";
	
	public static final String SELECT_COUNT_NOTICE = "select count(`no`) from `km_cs_notice` where `cate`=?";
	public static final String SELECT_COUNT_NOTICES = "select count(`no`) from `km_cs_notice`";
	
	public static final String SELECT_NOTICES_GROUP = "select `no`, `title`,`uid`, `rdate`, `cate` from `km_cs_notice` "
													+"order by `no` DESC "
													+"limit ?, 10";
	
	public static final String SELECT_NOTICES_CATE = "select `no`, `title`, `uid`, `rdate`, `cate` from `km_cs_notice` "
													+"where `cate`=?"
													+"order by `no` DESC "
													+"limit ?, 10";
	
	public static final String SELECT_ARTICLE_NOTICE = "select `title`,`uid`, `rdate`, `content`, `cate` from `km_cs_notice` where `no`=?";
	
	public static final String SELECT_FAQ = "select * from `km_cs_faq`";
	
	public static final String SELECT_FAQ_CATE = "select DISTINCT `cate2` from `km_cs_faq` where `cate`=?";
	
	public static final String SELECT_FAQ_ARTICLE = "select `cate`, `title`, `content` from `km_cs_faq` "
													+"where `no`=?";
	
	public static final String SELECT_QNAS = "select * from `km_cs_qna`"
											+"order by `no` DESC "
											+"limit 0, 5";
	
	public static final String SELECT_COUNT_QNA = "select count(`no`) from `km_cs_qna` where `cate`=?";
	public static final String SELECT_COUNT_QNAS = "select count(`no`) from `km_cs_qna`";
	
	public static final String SELECT_QNAS_GROUP = "select `no`, `cate2`, `title`, `uid`, `rdate`, `cate` from `km_cs_qna` "
													+"order by `no` DESC "
													+"limit ?, 10";
	
	public static final String SELECT_QNAS_CATE = "select `no`, `cate2`, `title`, `uid`, `rdate`, `cate` from `km_cs_qna` "
													+"where `cate`=?"
													+"order by `no` DESC "
													+"limit ?, 10";
	
	public static final String SELECT_ARTICLE_QNA = "select `cate2`, `title`,`uid`, `rdate`, `content`, `cate` from `km_cs_qna` where `no`=?";
	public static final String SELECT_CATE_QNA = "select `cate` from km_cs_qna";
	
	public static final String INSERT_ARTICLE_QNA = "insert into `km_cs_qna` set "
												+ "`uid`=?, `cate`=?, `cate2`=?, "
												+ "`title`=?, `content`=?, `regip`=?";
	
	
}

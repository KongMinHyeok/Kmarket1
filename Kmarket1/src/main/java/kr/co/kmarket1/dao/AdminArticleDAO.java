package kr.co.kmarket1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;

public class AdminArticleDAO extends DBHelper{
	private static AdminArticleDAO instance = new AdminArticleDAO();
	public static AdminArticleDAO getInstance() {
		return instance;
	}
	
	private AdminArticleDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
}

package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.AdminArticleDAO;

public enum AdminArticleService {

	instance;
	
	private AdminArticleDAO dao = AdminArticleDAO.getInstance();
	
	public void AdminArticleDAO() {
		
	}
}

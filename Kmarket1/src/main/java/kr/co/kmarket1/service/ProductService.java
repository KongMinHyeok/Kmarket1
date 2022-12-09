package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.ProductDAO;

public enum ProductService {
	
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	public int selectCountTotal(int prodCate2) {
		return dao.selectCountTotal(prodCate2);
	}


}

package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.MainDAO;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

public enum MainService {
	instance;
	private MainDAO dao = MainDAO.getInstance();
	
	public List<Cate1VO> selectCate1() {
		return dao.selectCate1();
	}
	public List<Cate2VO> selectCate2() {
		return dao.selectCate2();
	}
	
	public List<ProductVO> selectProductCountSold() {
		return dao.selectProductCountSold();
	}
	public List<ProductVO> selectProductCountHit() {
		return dao.selectProductCountHit();
	}
	public List<ProductVO> selectProductCountScore() {
		return dao.selectProductCountScore();
	}
	public List<ProductVO> selectProductCountNew() {
		return dao.selectProductCountNew();
	}
	public List<ProductVO> selectProductCountDiscount() {
		return dao.selectProductCountDiscount();
	}
}

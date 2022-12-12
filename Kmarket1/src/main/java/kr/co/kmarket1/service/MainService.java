package kr.co.kmarket1.service;

import java.util.List;

import kr.co.kmarket1.dao.MainDAO;
import kr.co.kmarket1.vo.Cate1VO;

public enum MainService {
	instance;
	private MainDAO dao = MainDAO.getInstance();
	
	public List<Cate1VO> selectCate1() {
		return dao.selectCate1();
	}
}

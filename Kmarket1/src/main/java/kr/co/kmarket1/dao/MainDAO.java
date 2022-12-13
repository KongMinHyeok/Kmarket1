package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.MainSQL;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

public class MainDAO extends DBHelper{
	private static MainDAO instance = new MainDAO();
	public static MainDAO getInstance() {
		return instance;
	}
	
	private MainDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	public List<Cate1VO> selectCate1() {
		List<Cate1VO> cates1 = new ArrayList<>();
		try {
			logger.info("selectCate1 start....");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(MainSQL.SELECT_KM_PRODUCT_CATE1);
					
			while(rs.next()) {
				Cate1VO vo = new Cate1VO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				cates1.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.debug("cates1 : " + cates1);
		return cates1;
	}
	
	public List<Cate2VO> selectCate2() {
		List<Cate2VO> cates2 = new ArrayList<>();
		try {
			logger.info("selectCate2 start....");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(MainSQL.SELECT_KM_PRODUCT_CATE2);
					
			while(rs.next()) {
				Cate2VO vo2 = new Cate2VO();
				vo2.setCate1(rs.getInt(1));
				vo2.setCate2(rs.getInt(2));
				vo2.setC2Name(rs.getString(3));
				cates2.add(vo2);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.debug("cates2 : " + cates2);
		return cates2;
	}
	
	public void selectProduct() {}
	public List<ProductVO> selectProductCountSold(String sold) {
		
		List<ProductVO> prodSd = new ArrayList<>();
		
		try {
			logger.info("selectProductCountSold start...");
			conn = getConnection();
			psmt = conn.prepareStatement(MainSQL.SELECT_KM_PRODUCT_SOLD_COUNT);
			psmt.setString(1, sold);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pdv = new ProductVO();
				pdv.setProdName(rs.getString(1));
				pdv.setThumb1(rs.getString(2));
				pdv.setPrice(rs.getInt(3));
				pdv.setDiscount(rs.getInt(4));
				prodSd.add(pdv);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("prodSd : " + prodSd);
		return prodSd;
	}
	public void selectProductCountHit() {}
	public void selectProductCountScore() {}
	
}

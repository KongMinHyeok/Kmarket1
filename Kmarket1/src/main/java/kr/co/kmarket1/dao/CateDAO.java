package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;

public class CateDAO extends DBHelper{
	private static CateDAO instance = new CateDAO();
	public static CateDAO getInstance () {
		return instance;
	}
	private CateDAO (){}
	
	// logger
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void selectCate() {}
	
	// cate1 리스트 불러오기
	public List<Cate1VO> selectCates1() {
		List<Cate1VO> cate1_1 = new ArrayList<>();
		try {
			logger.info("selectCate1 start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `km_product_cate1`");
			
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				
				cate1_1.add(cate1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate1_1;
	}
	
	// cate1에 해당하는 cate2 리스트 불러오기
	public List<Cate2VO> selectCates2() {
		List<Cate2VO> cate2_1 = new ArrayList<>();
		try {
			logger.info("selectCate2 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELCT * FROM `km_product_cate2`");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2_1.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2_1;
	}
	
	// cate1에 해당하는 cate2 리스트 불러오기
	public List<Cate2VO> selectCates2(String cate1) {
		List<Cate2VO> cate2_1 = new ArrayList<>();
		try {
			logger.info("selectCate_2 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product_cate2` WHERE `cate1`=?");
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2_1.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2_1;
	}
	
	public void insertCate() {}
	public void updateCate() {}
	public void deleteCate() {}
	
}

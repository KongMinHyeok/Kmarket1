package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.MainSQL;
import kr.co.kmarket1.vo.Cate1VO;

public class MainDAO extends DBHelper{
	private static MainDAO instance = new MainDAO();
	public static MainDAO getInstance() {
		return instance;
	}
	
	private MainDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	public List<Cate1VO> selectCate1() {
		List<Cate1VO> Cates = new ArrayList<>();
		try {
			logger.info("selectCate1 start....");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(MainSQL.SELECT_CATE1);
					
			while(rs.next()) {
				Cate1VO vo = new Cate1VO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				Cates.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.debug("Cates : " + Cates);
		return Cates;
	}
	public void selectProduct() {}
	public void selectProductCountSold() {}
	public void selectProductCountHit() {}
	public void selectProductCountScore() {}
	
}

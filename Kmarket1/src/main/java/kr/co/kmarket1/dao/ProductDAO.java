package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.Cate1VO;

public class ProductDAO extends DBHelper{

	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	private ProductDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Cate1VO> selectCate1(String c1Name) {
		
		List<Cate1VO> cate1s = new ArrayList<>();
		
		try {
			logger.info("selctCate1 start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CATE1);
			psmt.setString(1, c1Name);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				cate1s.add(cate1);
				
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cate1 : " + cate1s);
		return cate1s;
	}
	
	public void selectSold() {}
	
	public void selectThumb2() {}
	
	public void selectScore() {}
	
}

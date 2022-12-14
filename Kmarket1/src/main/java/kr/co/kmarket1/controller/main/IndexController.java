package kr.co.kmarket1.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.MainService;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MainService service = MainService.instance;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1,2차 카테고리 리스트
		List<Cate1VO> cates1 = service.selectCate1();
		List<Cate2VO> cates2 = service.selectCate2();
		
		// 메인 베스트, 히트, 추천, 최신, 할인 품목
		List<ProductVO> bestsold = service.selectProductCountSold();
		List<ProductVO> hitprod = service.selectProductCountHit();
		List<ProductVO> scoreprod = service.selectProductCountScore();
		List<ProductVO> newprod = service.selectProductCountNew();
		List<ProductVO> discountprod = service.selectProductCountDiscount();
		
		
		req.setAttribute("cates1", cates1);
		req.setAttribute("cates2", cates2);
		req.setAttribute("bestsold", bestsold);
		req.setAttribute("hitprod", hitprod);
		req.setAttribute("scoreprod", scoreprod); 
		req.setAttribute("newprod", newprod);
		req.setAttribute("discountprod", discountprod);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	}
	
	
}

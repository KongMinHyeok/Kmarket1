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
		
		String sold = req.getParameter("sold");
		
		List<Cate1VO> cates1 = service.selectCate1();
		List<Cate2VO> cates2 = service.selectCate2(); 
		List<ProductVO> prodSd = service.selectProductCountSold(sold);
		
		
		req.setAttribute("cates1", cates1);
		req.setAttribute("cates2", cates2);
		req.setAttribute("prodSd", prodSd);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	}
	
	
}

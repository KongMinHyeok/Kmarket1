package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE; 
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		//
		String pg = req.getParameter("pg");
		int currentPage = 1;
		int start;
		int total = 0;
		int lastPageNum;
		int currentPageGroup;
		int pageGroupStart;
		int pageGroupEnd;
		int pageStartNum;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		start = (currentPage - 1)*10;
		
		// 전체 게시물 갯수
		/* prodCate2 형변환 해야함*/
		total = service.selectCountTotal(prodCate2);

		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		
		// ProductDAO 객체 생성
		ProductDAO dao = ProductDAO.getInstance();
		ProductService service = ProductService.INSTANCE;
		
		// 상품 목록 가져오기
		List<ProductVO> products = dao.selectProducts(prodCate2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
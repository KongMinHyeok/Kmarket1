package kr.co.kmarket1.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.AdminDAO;
import kr.co.kmarket1.service.AdminProductService;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/admin/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminProductService service = AdminProductService.INSTANCE;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		int currentPage = service.getCurrentPage(pg);
		
		int total = 0;
		total = service.selectListCountTotal();
		
		int lastPageNum = service.getLastPageNum(total);
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);
		int pageStartNum = service.getPageStartNum(total, currentPage);
		int start = service.getStartNum(currentPage);
		
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		List<ProductVO> products = AdminDAO.getInstance().selectProductList();
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/productList.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

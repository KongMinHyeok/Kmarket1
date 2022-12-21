package kr.co.kmarket1.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.AdminProductListDAO;
import kr.co.kmarket1.service.AdminProductService;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/admin/product/list.do")
public class AdminProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminProductService service = AdminProductService.INSTANCE;
	AdminProductListDAO dao = AdminProductListDAO.getInstance();

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String search = req.getParameter("search");
		String pg	  = req.getParameter("pg");
		
		int currentPage = service.getCurrentPage(pg);
		
		//페이지 번호
		int total = 0; // 전체 게시물 갯수 
		total = service.selectAdminListCountTotal();
		
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);// 페이지 그룹 start, end 번호
		int pageStartNum = service.getPageStartNum(total, currentPage);// 페이지 시작번호
		int start = service.getStartNum(currentPage);// 시작 인덱스
		
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		List<ProductVO> products = AdminProductListDAO.getInstance().selectAdminList();
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

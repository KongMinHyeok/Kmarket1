package kr.co.kmarket1.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.AdminProductListDAO;
import kr.co.kmarket1.service.AdminProductService;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/admin/product/delete.do")
public class AdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminProductService service = AdminProductService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		AdminProductListDAO.getInstance().deleteAdminList(prodNo);
		
		resp.sendRedirect("/Kmarket1/admin/product/list.do");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}

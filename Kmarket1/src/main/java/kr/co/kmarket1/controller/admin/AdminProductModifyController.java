package kr.co.kmarket1.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.AdminProductRegisterDAO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/admin/product/modify.do")
public class AdminProductModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		ProductVO vo = AdminProductRegisterDAO.getInstance().ModifyAdminList(prodNo);
		
		req.setAttribute("prodNo", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodName = req.getParameter("prodName");
		String descript = req.getParameter("descript");
		String company  = req.getParameter("company");
		String seller   = req.getParameter("seller");
		String price	= req.getParameter("price");
		String discount = req.getParameter("discount");
		String point	= req.getParameter("point");
		String stock	= req.getParameter("stock");
		String delivery = req.getParameter("delivery");
		String thumb1	= req.getParameter("thumb1");
		String thumb2	= req.getParameter("thumb2");
		String thumb3	= req.getParameter("thumb3");
		String detail	= req.getParameter("detail");
		String prodNo	= req.getParameter("prodNo");
		
		AdminProductRegisterDAO dao = AdminProductRegisterDAO.getInstance();
		dao.updateAdminRegister(prodName, descript, company, seller, price, discount, point, stock, delivery, thumb1, thumb2, thumb3, detail, prodNo);
		
		resp.sendRedirect("/Kmarket1/admin/product/list.do");
	}
}

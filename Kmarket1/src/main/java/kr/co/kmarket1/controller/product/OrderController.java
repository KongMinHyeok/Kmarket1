package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		if(prodNo != null) {
			
			ProductVO vo = ProductDAO.getInstance().selectOrderProduct(prodNo, count);
			List<ProductVO> carts = new ArrayList<>();
			carts.add(vo);
			
			req.setAttribute("carts", carts);
			HttpSession session = req.getSession();
			session.setAttribute("carts", carts);

			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
			dispatcher.forward(req, resp);
		}else {
			HttpSession session = req.getSession();
			List<ProductCartVO> carts = (List<ProductCartVO>) session.getAttribute("carts");
			req.setAttribute("carts", carts);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 여기부터 해야함		
		// 주문번호 하나에 count는 중복된거 다
		String prodNo = req.getParameter("prodNo");
		String ordUid = req.getParameter("uid");
		String recipName = req.getParameter("orderer");
		String recipHp = req.getParameter("hp");
		String recipZip = req.getParameter("zip");
		String recipAddr1 = req.getParameter("addr1");
		String recipAddr2 = req.getParameter("addr2");
	}
}

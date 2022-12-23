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
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductOrderVO;
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
		req.setAttribute("prodNo", prodNo);
		
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductOrderVO> orders = null;
		
		List<ProductCartVO> carts = null;
		// 만약 바로 구매로 왔으면
		//if() {
			
			carts = dao.selectProductCart(prodNo);
			req.setAttribute("carts", carts);
		//}else{// 장바구니 선택으로 왔으면
		//}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}

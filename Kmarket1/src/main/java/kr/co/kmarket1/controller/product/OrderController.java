package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

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
		String uid = req.getParameter("uid");
		String cartNo = req.getParameter("cartNo");
		
		req.setAttribute("cartNo", cartNo);
		req.setAttribute("prodNo", prodNo);
		req.setAttribute("uid", uid);
		
		ProductDAO dao = ProductDAO.getInstance();
		
		List<ProductCartVO> carts = null;
		

		int directNum = ProductDAO.getInstance().findDirect(uid);

		if(directNum == 0) {
			// 장바구니
			carts = dao.selectProductCarts(uid, cartNo);
			req.setAttribute("carts", carts);
			
		}else {// 바로 구매
			
			carts = dao.selectProductCart(uid);
			req.setAttribute("carts", carts);

		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}

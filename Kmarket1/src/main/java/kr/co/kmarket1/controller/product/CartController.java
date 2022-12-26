package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/cart.do")
public class CartController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		req.setAttribute("uid", uid);


		// ProductDAO 객체 생성
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductCartVO> carts = null;
		
		carts = dao.selectProductCarts(uid);
		req.setAttribute("carts", carts);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/cart.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderCheck[] = req.getParameterValues("arr");
		System.out.println(orderCheck);
		List<ProductCartVO> carts = new ArrayList<>();
		
		for(String cartNo : orderCheck) {
			ProductCartVO vo = ProductDAO.getInstance().selectProductOrders(cartNo);
			carts.add(vo);
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("carts", carts);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", carts.size());
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());

	}

}

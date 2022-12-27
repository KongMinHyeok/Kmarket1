package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String cartNo = req.getParameter("cartNo");
		String prodNo = req.getParameter("prodNo");
		String recipname = req.getParameter("recipName");
		String recipHp = req.getParameter("recipHp");
		String recipZip = req.getParameter("recipZip");
		String recipAddr1 = req.getParameter("recipAddr1");
		String recipAddr2 = req.getParameter("recipAddr2");
		String ordUid = req.getParameter("ordUid");
		String ordCount = req.getParameter("ordCount");
		String ordPrice = req.getParameter("ordPrice");
		String ordDiscount = req.getParameter("ordDiscount");
		String ordDelivery = req.getParameter("ordDelivery");
		String savePoint = req.getParameter("savePoint");
		String usedPoint = req.getParameter("usedPoint");
		String ordTotPrice = req.getParameter("ordTotPrice");
		String ordPayment = req.getParameter("ordPayment");
		
		ProductOrderVO vo = new ProductOrderVO();
		vo.setRecipname(recipname);
		vo.setRecipHp(recipHp);
		vo.setRecipZip(recipZip);
		vo.setRecipAddr1(recipAddr1);
		vo.setRecipAddr2(recipAddr2);
		vo.setOrdUid(ordUid);
		vo.setOrdCount(ordCount);
		vo.setOrdPrice(ordPrice);
		vo.setOrdDiscount(ordDiscount);
		vo.setOrdDelivery(ordDelivery);
		vo.setSavePoint(savePoint);
		vo.setUsedPoint(usedPoint);
		vo.setOrdTotPrice(ordTotPrice);
		vo.setOrdPayment(ordPayment);
	}
}

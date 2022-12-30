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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductOrderItemVO;
import kr.co.kmarket1.vo.ProductOrderVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
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
		String ordCount = req.getParameter("ordCount");
		String ordPrice = req.getParameter("ordPrice");
		String ordDiscount = req.getParameter("ordDiscount");
		String ordDelivery = req.getParameter("ordDelivery");
		String savePoint = req.getParameter("savePoint");
		String usedPoint = req.getParameter("usedPoint");
		String ordTotPrice = req.getParameter("ordTotPrice");
		
		String recipName = req.getParameter("recipName");
		String recipHp = req.getParameter("recipHp");
		String recipZip = req.getParameter("recipZip");
		String recipAddr1 = req.getParameter("recipAddr1");
		String recipAddr2 = req.getParameter("recipAddr2");
		
		String ordUid = req.getParameter("ordUid");
		String ordPayment = req.getParameter("ordPayment");
		String ordComplete = req.getParameter("ordComplete");
		
		logger.debug("ordCount : " + ordCount);
		logger.debug("ordPrice : " + ordPrice);
		logger.debug("ordDiscount : " + ordDiscount);
		logger.debug("ordDelivery : " + ordDelivery);
		logger.debug("savePoint : " + savePoint);
		logger.debug("usedPoint : " + usedPoint);
		logger.debug("ordTotPrice : " + ordTotPrice);
		 
		
		ProductOrderVO order = new ProductOrderVO();
		order.setOrdCount(ordCount);
		order.setOrdPrice(ordPrice);
		order.setOrdDiscount(ordDiscount);
		order.setOrdDelivery(ordDelivery);
		order.setSavePoint(savePoint);
		order.setUsedPoint(usedPoint);
		order.setOrdTotPrice(ordTotPrice);
		
		order.setRecipName(recipName);
		order.setRecipHp(recipHp);
		order.setRecipZip(recipZip);
		order.setRecipAddr1(recipAddr1);
		order.setRecipAddr2(recipAddr2);
		
		order.setOrdUid(ordUid);
		order.setOrdPayment(ordPayment);
		order.setOrdComplete(ordComplete);
		
		// order_item 어떻게 만들지 생각해라
		JsonObject json = new JsonObject();
		PrintWriter writer = resp.getWriter();

		int ordNo = ProductDAO.getInstance().insertCompleteOrder(order);
		///
		if(ordCount != null) {
				ProductOrderItemVO item = new ProductOrderItemVO();
				HttpSession session = req.getSession();
				List<ProductCartVO> carts = (List<ProductCartVO>) session.getAttribute("carts");
				
				req.setAttribute("carts", carts);
				
				
				for(ProductCartVO cart : carts) {
					ProductDAO.getInstance().insertOrderItem(ordNo, cart);
				}
				}
				///
		/*
		if(ordCount != null) {
			ProductDAO.getInstance().insertOrderItem(ordNo, cart);
		}
		*/
		json.addProperty("result", ordNo);
		
		writer.print(json.toString());
	}
}
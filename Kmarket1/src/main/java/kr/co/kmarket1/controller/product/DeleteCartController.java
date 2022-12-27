package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.ProductCartDAO;

@WebServlet("/product/deleteCart.do")
public class DeleteCartController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ProductDAO 객체 생성
		ProductCartDAO dao = ProductCartDAO.getInstance();
		// DELETE_PRODUCT_CART 하는거임
		String chks[] = req.getParameterValues("chk");
		
		for(String cartNo : chks) {
			int result = dao.deleteProductCart(cartNo);
		}
		
		
		JsonObject json = new JsonObject();
		json.addProperty("result", 1);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	
	}

}

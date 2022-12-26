package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.ProductDAO;

@WebServlet("/product/DeleteDirect.do")
public class DeleteDirectController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO.getInstance().deleteProductDirect();
		String uid = req.getParameter("uid");

		int directNum = ProductDAO.getInstance().findDirect(uid);
		JsonObject json = new JsonObject();
		PrintWriter writer = resp.getWriter();

		if(directNum == 1) {
			// 장바구니
			int result = ProductDAO.getInstance().deleteProductDirect();
			
			json.addProperty("result", result);
			
			writer.print(json.toString());
			
		
		}
	}
}

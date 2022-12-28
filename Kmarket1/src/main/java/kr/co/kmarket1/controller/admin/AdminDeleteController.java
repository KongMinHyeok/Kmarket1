package kr.co.kmarket1.controller.admin;

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

import kr.co.kmarket1.dao.AdminProductListDAO;



@WebServlet("/admin/product/delete.do")
public class AdminDeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
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
		
		String prodNo[] = req.getParameterValues("prodNo[]");
		AdminProductListDAO dao = AdminProductListDAO.getInstance();
		
		int result = 0;
		
		for(int i = 0; i<prodNo.length; i++) {
			result = dao.selectDelete(prodNo[i]);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		
	}

}


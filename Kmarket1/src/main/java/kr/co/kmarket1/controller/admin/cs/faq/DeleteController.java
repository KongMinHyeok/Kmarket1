package kr.co.kmarket1.controller.admin.cs.faq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.service.CsService;


@WebServlet("/admin/cs/faq/delete.do")
public class DeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String no = req.getParameter("no");
		
		service.deleteFaq(no);
		
		resp.sendRedirect("/Kmarket1/admin/cs/faq/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String [] chkarr = req.getParameterValues("chkarr");
		int result = 0;
		
		for(int i = 0; i < chkarr.length; i++) {
			result = service.deleteFaq(chkarr[i]);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		String jsonData = json.toString();
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
	}
	
	
}

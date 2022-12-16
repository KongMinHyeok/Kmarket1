package kr.co.kmarket1.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket1.dao.CateDAO;
import kr.co.kmarket1.vo.Cate2VO;

@WebServlet("/admin/cate2List.do")
public class Cate2ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수신
		String cate1 = req.getParameter("cate1");
		
		// cate2 리스트 불러오기
		List<Cate2VO> cate2_1 = CateDAO.getInstance().selectCates2(cate1);
		// cate2 GSON 
		Gson gson = new Gson();
		String jsonData = gson.toJson(cate2_1);
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}
}

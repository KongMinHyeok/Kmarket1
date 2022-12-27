package kr.co.kmarket1.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.db.CsSQL;
import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;

@WebServlet("/admin/cs/notice/modify.do")
public class ModifyController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String no = req.getParameter("no");
		
		CsArticleVO notice = service.selectArticleNotice(no);
		
		req.setAttribute("notice", notice);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/admin/cs/notice/modify.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		service.updateNotice(no, cate, title, content);
		
		resp.sendRedirect("/Kmarket1/admin/cs/notice/view.do?no=" + no);
	}
	
}


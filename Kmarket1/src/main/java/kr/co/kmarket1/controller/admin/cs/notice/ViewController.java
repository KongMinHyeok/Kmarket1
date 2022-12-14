package kr.co.kmarket1.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;

@WebServlet("/admin/cs/notice/view.do")
public class ViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String cate  = req.getParameter("cate");
		String pg 	 = req.getParameter("pg");
		String no 	 = req.getParameter("no");
		
		CsArticleVO notice = service.selectArticleNotice(no);
		service.updateNoticeHit(no);
		
		req.setAttribute("cate", cate);
		req.setAttribute("pg", pg);
		req.setAttribute("no", no);
		req.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

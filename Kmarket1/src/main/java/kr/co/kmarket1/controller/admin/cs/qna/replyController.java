package kr.co.kmarket1.controller.admin.cs.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;

@WebServlet("/admin/cs/qna/reply.do")
public class replyController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String cate  = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String pg 	 = req.getParameter("pg");
		String no 	 = req.getParameter("no");
		
		CsArticleVO qna = service.selectArticleQna(no);
		
		req.setAttribute("cate", cate);
		req.setAttribute("cate2", cate2);
		req.setAttribute("pg", pg);
		req.setAttribute("no", no);
		req.setAttribute("qna", qna);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/reply.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String comment = req.getParameter("comment");
		String no = req.getParameter("no");
		
		service.insertCommentQna(comment, no);
		resp.sendRedirect("/Kmarket1/admin/cs/qna/view.do?no=" + no);
	}
	
}

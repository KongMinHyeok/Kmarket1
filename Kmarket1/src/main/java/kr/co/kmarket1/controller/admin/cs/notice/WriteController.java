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

@WebServlet("/admin/cs/notice/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		String cate = req.getParameter("cate");
		
		req.setAttribute("cate", cate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/write.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String regip = req.getRemoteAddr();
		
		CsArticleVO article = new CsArticleVO();
		
		article.setUid(uid);
		article.setCate(cate);
		article.setTitle(title);
		article.setContent(content);
		article.setRegip(regip);
		
		service.insertArticleNotice(article);
		
		resp.sendRedirect("/Kmarket1/admin/cs/notice/list.do");
		
	}
	
}

package kr.co.kmarket1.controller.cs.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;

@WebServlet("/cs/qna/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		CsArticleVO qna = service.selectCateQna();
		
		req.setAttribute("cate", cate);
		req.setAttribute("qna", qna);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid 		= req.getParameter("uid");
		String cate 	= req.getParameter("cate");
		String cate2 	= req.getParameter("cate2");
		String title 	= req.getParameter("title");
		String content 	= req.getParameter("content");
		String regip 	= req.getParameter("regip");
		
		CsArticleVO article = new CsArticleVO();
		article.setUid(uid);
		article.setCate(cate);
		article.setCate2(cate2);
		article.setTitle(title);
		article.setContent(content);
		article.setRegip(req.getRemoteAddr());
		
		service.insertArticleQna(article);
		
		resp.sendRedirect("/Kmarket1/cs/qna/list.do");
		
	}
	
	
}

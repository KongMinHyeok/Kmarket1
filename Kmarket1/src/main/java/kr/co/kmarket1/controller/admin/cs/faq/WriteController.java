package kr.co.kmarket1.controller.admin.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;

@WebServlet("/admin/cs/faq/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		
		List<CsArticleVO> faqct2 = service.selectFaqsCate2(cate);
		
		req.setAttribute("cate", cate);
		req.setAttribute("cate2", cate2);
		req.setAttribute("faqct2", faqct2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/write.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String regip = req.getRemoteAddr();
		
		CsArticleVO article = new CsArticleVO();
		
		article.setUid(uid);
		article.setCate(cate);
		article.setCate2(cate2);
		article.setTitle(title);
		article.setContent(content);
		article.setRegip(regip);
		
		service.insertArticleFaq(article);
		
		resp.sendRedirect("/Kmarket1/admin/cs/faq/list.do");
	
	}
	
}

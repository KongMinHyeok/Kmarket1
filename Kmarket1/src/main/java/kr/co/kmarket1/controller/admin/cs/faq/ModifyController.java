package kr.co.kmarket1.controller.admin.cs.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;

@WebServlet("/admin/cs/faq/modify.do")
public class ModifyController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String no = req.getParameter("no");
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		
		CsArticleVO faq = service.selectFaqArticle(no);
		
		req.setAttribute("faq", faq);
		req.setAttribute("no", no);
		req.setAttribute("cate", cate);
		req.setAttribute("cate2", cate2);
			
		RequestDispatcher dispathcer = req.getRequestDispatcher("/admin/cs/faq/modify.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		service.updateFaq(no, cate, cate2, title, content);
		
		resp.sendRedirect("/Kmarket1/admin/cs/faq/view.do?no=" + no);
	}
	
	
}

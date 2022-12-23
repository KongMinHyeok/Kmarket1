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

@WebServlet("/admin/cs/faq/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		
		List<CsArticleVO> faqs = service.selectFaq();
		List<CsArticleVO> faqct = service.selectFaqCate();
		List<CsArticleVO> faqct2 = service.selectFaqsCate2(cate);
		
		req.setAttribute("cate", cate);
		req.setAttribute("cate2", cate2);
		req.setAttribute("faqct", faqct);
		req.setAttribute("faqct2", faqct2);
		req.setAttribute("faqs", faqs);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}

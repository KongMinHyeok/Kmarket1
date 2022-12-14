package kr.co.kmarket1.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsNoticeVO;

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		String search = req.getParameter("search");
		int currentPage =1;
		int start;
		int total = 0;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		start = (currentPage - 1)*10;
		
	
		List<CsNoticeVO> notices = null;
		if(search == null) {
			notices = service.selectNotices(start);
		}else {
		}
		
		req.setAttribute("notices", notices);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/index.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
}

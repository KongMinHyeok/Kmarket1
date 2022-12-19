package kr.co.kmarket1.controller.cs.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.CsDAO;
import kr.co.kmarket1.service.CsService;
import kr.co.kmarket1.vo.CsArticleVO;


@WebServlet("/cs/notice/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.instance;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate  = req.getParameter("cate");
		String pg 	 = req.getParameter("pg");
		String group = req.getParameter("group");
		
		int start = 0;
		int currentPage = 1;
		int currentPageGroup = 1;
		int total = 0;
		int pageStartNum = 0;
		int lastPageNum = 0;
		
		
		if(pg!=null){
			currentPage = Integer.parseInt(pg);
		}
		
		start = (currentPage -1) * 10;
		
		
		
		// 전체 게시물 갯수
		if(cate == null) {
			total = CsDAO.getInstance().selectCountNotices();
		}else {
			total = CsDAO.getInstance().selectCountNotice(cate);
		}
		
		// 시작번호 페이지
		pageStartNum = total - start + 1;
		
		// 마지막 페이지 번호
		lastPageNum = service.getLastPageNum(total);
		
		// 페이지 그룹 스타트, 엔드
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);
		
		List<CsArticleVO> articles = null;
		
		
		if(cate == null) {
			articles = CsDAO.getInstance().selectNoticesGroup(start);
		}else {
			articles = CsDAO.getInstance().selectNoticesCate(cate, start);
		}

		req.setAttribute("cate", cate);
		req.setAttribute("pg", pg);
		req.setAttribute("group", group);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("currentPageGroup", currentPageGroup);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("articles", articles);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/notice/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
}
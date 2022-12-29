package kr.co.kmarket1.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket1.dao.AdminProductListDAO;
import kr.co.kmarket1.vo.MemberVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/admin/product/list.do")
public class AdminProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminProductListDAO dao = AdminProductListDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션에서 유저정보 가져오기
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("sessUser");
		
		int level     = vo.getLevel();
		String seller = vo.getCeo();
		String pg     = req.getParameter("pg");
		String cate   = req.getParameter("cate");
		String search = req.getParameter("search");
		
		//페이징 처리
		int start = 0;
		int total = 0;
		int lastPageNum = 0;
		int currentPage = 1;
		int currentPageGroup = 1;
		int pageGroupStart = 0;
		int pageGroupEnd = 0;
		int pageStartNum = 0;
		
		if(pg != null){
			currentPage = Integer.parseInt(pg);
		}
		
		currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		pageGroupStart = (currentPageGroup -1) * 10 + 1; //시작번호
		pageGroupEnd= currentPageGroup * 10; //끝번호
		
		//전체 게시물 갯수
		if(level == 7) {
			total = dao.selectCountTotal();
		}else {
			total = dao.selectCountTotalSeller(seller);
		}
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 +1;
		}
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		start = (currentPage - 1) * 10;
		
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("total", total);
		req.setAttribute("start", start);
		
		List<ProductVO> products = new ArrayList<>();
		
		if(level == 7) {
			//search 검색, cate 카테고리
			if(search != null && cate != null) {
				products = dao.searchAdminList(cate, search);
			}else {
				products = dao.selectAdminList(start);
			}
		}else {
			//search 검색, cate 카테고리
			if(search != null && cate != null) {
				products = dao.searchAdminList(seller, cate, search);
			}else {
				products = dao.selectAdminList(seller, start);
			}
		}
		
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}

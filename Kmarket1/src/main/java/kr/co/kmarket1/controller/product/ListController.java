package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.ProductDAO;
import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE; 
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		//페이징 처리용
		String pg = req.getParameter("pg");
		//정렬을 위하여 받아옴
		int type = Integer.parseInt(req.getParameter("type"));

		int currentPage = 1;
		int start;
		int total = 0;
		int lastPageNum;
		int currentPageGroup;
		int pageGroupStart;
		int pageGroupEnd;
		int pageStartNum;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		start = (currentPage - 1)*10;
		
		// 전체 게시물 갯수
		/* prodCate2 형변환 해야함*/
		total = service.selectCountTotal(prodCate1, prodCate2);
		
		// 마지막 페이지 번호
		lastPageNum = service.getLastPageNum(total);
		
		// 페이지 그룹 시작 끝
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);
		currentPageGroup = result[0];
		pageGroupStart = result[1];
		pageGroupEnd = result[2];
		
		pageStartNum = total - start +1;
		
		req.setAttribute("start", start);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("currentPageGroup", currentPageGroup);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		
		
		
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("type", type);
		
		// ProductDAO 객체 생성
		ProductDAO dao = ProductDAO.getInstance();
		
		// 상품 목록 가져오기
		List<ProductVO> products = null;
		if(type == 1) {
			products = dao.selectProducts1(prodCate1, prodCate2, start);
		}else if(type == 2) {
			products = dao.selectProducts2(prodCate1, prodCate2, start);
		}else if(type == 3) {
			products = dao.selectProducts3(prodCate1, prodCate2, start);
		}else if(type == 4) {
			products = dao.selectProducts4(prodCate1, prodCate2, start);
		}else if(type == 5) {
			products = dao.selectProducts5(prodCate1, prodCate2, start);
		}else {
			products = dao.selectProducts6(prodCate1, prodCate2, start);
		}
		
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.ProductCartVO;
import kr.co.kmarket1.vo.ProductReviewVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet{
	private ProductService service = ProductService.INSTANCE;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		String prodNo = req.getParameter("prodNo");
		String pg = req.getParameter("pg");
		
		
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("prodNo", prodNo);
		req.setAttribute("pg", pg);
		
		ProductVO product = service.selectProduct(prodNo);
		req.setAttribute("product", product);
		
		// 현재 시간 구해서 배송일자 구하기
		LocalDate now = LocalDate.now();
		LocalDate deliveryDate = now.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd");
        String formatedNow = deliveryDate.format(formatter);
        req.setAttribute("formatedNow", formatedNow);
        
        DayOfWeek dayOfWeek = deliveryDate.getDayOfWeek();
        /* 이게 왜 작동안하는지 모르겠다
        dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        */
        String koreanDOW = null;
        switch(dayOfWeek) {
        case SUNDAY:
        	koreanDOW = "일요일";
        	break;
        case MONDAY:
        	koreanDOW = "월";
        	break;
        case TUESDAY:
        	koreanDOW = "화";
        	break;
        case WEDNESDAY:
        	koreanDOW = "수";
        	break;
        case THURSDAY:
        	koreanDOW = "목";
        	break;
        case FRIDAY:
        	koreanDOW = "금";
        	break;
        case SATURDAY:
        	koreanDOW = "토";
        	break;
        }
        req.setAttribute("koreanDOW", koreanDOW);

        // 리뷰 들고오기
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
		start = (currentPage - 1)*5;
		
		// 전체 게시물 갯수
		total = service.selectReviewCountTotal(prodNo);
		
		// 마지막 페이지 번호
		lastPageNum = service.getReviewLastPageNum(total);
		
		// 페이지 그룹 스타트, 엔드
		int[] result = service.getReviewPageGroupNum(currentPage, lastPageNum);
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
		
		req.setAttribute("pg", pg);
        
		List<ProductReviewVO> reviews = null;
		reviews = service.selectProductReviews(prodNo, start);
        req.setAttribute("reviews", reviews);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("uid");
		int prodNo = Integer.parseInt(req.getParameter("prodNo"));
		int count = Integer.parseInt(req.getParameter("count"));
		int price = Integer.parseInt(req.getParameter("price"));
		int discount = Integer.parseInt(req.getParameter("discount"));
		int point = Integer.parseInt(req.getParameter("point"));
		int delivery = Integer.parseInt(req.getParameter("delivery"));
		int total = Integer.parseInt(req.getParameter("total"));
		String rdate = req.getParameter("rdate");
		
		resp.setCharacterEncoding("UTF-8");
		
		ProductCartVO cart = service.insertProductCart(uid, prodNo, count, price, discount, point, delivery, total, rdate);
 
		JsonObject json = new JsonObject();
		json.addProperty("uid", cart.getUid());
		json.addProperty("prodNo", cart.getProdNo());
		json.addProperty("count", cart.getCount());
		json.addProperty("price", cart.getPrice());
		json.addProperty("discount", cart.getDiscount());
		json.addProperty("point", cart.getPoint());
		json.addProperty("delivery", cart.getDelivery());
		json.addProperty("total", cart.getTotal());
		json.addProperty("rdate", cart.getRdate());

		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());

		
	}
}

package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.service.ProductCompleteService;
import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.OrderVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/complete.do")
public class CompleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ProductCompleteService service = ProductCompleteService.INSTANCE;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ordNo = req.getParameter("ordNo");
		
		// 파라미터로 받아온 주문번호를 이용해 주문자 정보와 주문 내용 받아오기
		// 첫 번째는 주문자 정보 받아오기; 편의를 위해서 orderVO 생성
		OrderVO order = service.selectOrderByOrdNo(Integer.parseInt(ordNo));
		
		// 두 번째는 주문 내용 받아오기; productVO 사용
		List<ProductVO> items = service.selectItemsByOrdNo(Integer.parseInt(ordNo));
		
		// 세션에 정보 저장하기
		req.setAttribute("order", order);
		req.setAttribute("items", items);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/complete.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}

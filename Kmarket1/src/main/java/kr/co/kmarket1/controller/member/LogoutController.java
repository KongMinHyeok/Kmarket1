package kr.co.kmarket1.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket1.service.MemberService;

@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		// 세션에서 지우기
		HttpSession session = req.getSession();
		session.removeAttribute("sessMember");
		session.invalidate();
		
		// 자동로그인한 경우 쿠키에서 지우기
		Cookie cookie = new Cookie("SESSID", null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		// DB에서 sessId, sessDateLimit 지우기
		service.updateMemberForSessionOut(uid);
		
		resp.sendRedirect("/Kmarket1/member/login.do?success=201");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

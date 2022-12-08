package kr.co.kmarket1.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket1.service.MemberService;
import kr.co.kmarket1.vo.MemberVO;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String auto = req.getParameter("auto");
		
		MemberVO member = service.selectMember(uid, pass);
		
		if(member !=null && member.getLevel() != 0) { // 회원 정보가 DB에 있는지, 그리고 탈퇴한 회원이 아닌지 확인
			HttpSession session = req.getSession();
			session.setAttribute("sessMember", member);
			
			// 자동로그인 확인
			if(auto != null) {
				String sessId = session.getId();
				
				Cookie cookie = new Cookie("SESSID", sessId);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*3);
				resp.addCookie(cookie);
				
				service.updateMemberForSession(uid, sessId);
			}
			resp.sendRedirect("/Kmarket1/product/list.do");
		}else if(member !=null && member.getLevel() == 0) { // 회원 정보는 있지만 탈퇴한 경우
			resp.sendRedirect("/Kmarket1/member/login.do?success=111");
		}else { // 회원 정보가 없는 경우
			resp.sendRedirect("/Kmarket1/member/login.do?success=100");
		}
		
		// autoLoginFilter로 매페이지마다 로그인 여부 확인
	}
}

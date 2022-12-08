package kr.co.kmarket1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.service.MemberService;
import kr.co.kmarket1.vo.MemberVO;

@WebFilter("/*")
public class AutoLoginFilter implements Filter{
	private MemberService service = MemberService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		logger.info("autoLoginFilter called");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sess = req.getSession();
		
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("SESSID")) {
					String sessId = cookie.getValue();
					MemberVO member = service.selectMemberBySessId(sessId);
					
					if(member != null) {
						sess.setAttribute("sessMember", member);
					}
				}
			}
		}
		chain.doFilter(request, response);
	}
}

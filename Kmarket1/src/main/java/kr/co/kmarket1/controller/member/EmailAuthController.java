package kr.co.kmarket1.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.service.MemberService;

@WebServlet("/user/emailAuth.do")
public class EmailAuthController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		// 인증코드 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
		
		// 기본 정보
		String sender = ".";
		String password = ".";
		String title = "Kmarket 인증코드입니다";
		String content = "인증코드 6자리는 " + code + " 입니다\n 인증 페이지로 돌아가 인증을 완료하여 주시기 바랍니다" + "\n<a href='http://localhost:8080/Kmarket1/member/register.do'>인증 페이지</a>";
		
		// Gmail SMTP 정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// Gmail 서버 인증
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		});
		
		// 이메일 발송
		Message message = new MimeMessage(session);
		int status = 0;
		
		try {
			System.out.println("메일 전송 시작");
			
			message.setFrom(new InternetAddress(sender, "관리자", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
			Transport.send(message);
			status = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
			status = 0;
			System.out.println("메일 전송 실패");
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("status", status);
		json.addProperty("code", code);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

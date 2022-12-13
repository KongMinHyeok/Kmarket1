package kr.co.kmarket1.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.service.MemberService;
import kr.co.kmarket1.vo.MemberVO;

@WebServlet("/member/registerSeller.do")
public class RegisterSellerController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/registerSeller.jsp");
		dispatcher.forward(req, resp);
		// 원래 사업자 등록번호 ajax로 받아와서 여기서 체크하려고 했는데, req, resp값 포워드하면 json 데이터는 못 보내서 따로 컨트롤러 만들어야 함
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("km_uid");
		String pass = req.getParameter("km_pass2");
		String company = req.getParameter("kms_company");
		String ceo = req.getParameter("kms_ceo");
		String reg = req.getParameter("kms_corp_reg");
		String onlineReg = req.getParameter("kms_online_reg");
		String tel = req.getParameter("kms_tel");
		String fax = req.getParameter("kms_fax");
		String email = req.getParameter("km_email");
		String zip = req.getParameter("kms_zip");
		String addr1 = req.getParameter("kms_addr1");
		String addr2 = req.getParameter("kms_addr2");
		String name = req.getParameter("km_name");
		String hp = req.getParameter("km_hp");
		String regip = req.getRemoteAddr();
		
		MemberVO seller = new MemberVO();
		seller.setUid(uid);
		seller.setPass(pass);
		seller.setCompany(company);
		seller.setCeo(ceo);
		seller.setBizRegNum(reg);
		seller.setComRegNum(onlineReg);
		seller.setTel(tel);
		seller.setFax(fax);
		seller.setEmail(email);
		seller.setZip(zip);
		seller.setAddr1(addr1);
		seller.setAddr2(addr2);
		seller.setName(name);
		seller.setHp(hp);
		seller.setRegip(regip);
		
		service.insertSellerMember(seller);
		
		resp.sendRedirect("/Kmarket1/member/login.do");
	}
}

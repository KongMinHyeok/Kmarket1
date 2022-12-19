package kr.co.kmarket1.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket1.dao.AdminDAO;
import kr.co.kmarket1.dao.CateDAO;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/admin/productRegister.do")
public class ProductRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// cate1 리스트 불러오기
		List<Cate1VO> cate1_1 = CateDAO.getInstance().selectCates1();
		req.setAttribute("cate1_1", cate1_1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/productRegister.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext sc = req.getServletContext();
		String savePath = sc.getRealPath("/file");
		
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration e = mr.getFileNames();
		ArrayList<String> saveFiles = new ArrayList<>();
		ArrayList<String> newFiles = new ArrayList<>();
		
		while(e.hasMoreElements()) {
			String n = (String) e.nextElement();
			saveFiles.add(mr.getFilesystemName(n));
		}
		
		for(int i=0 ; i<4; i++) {
			String Fname = saveFiles.get(i);
			
			int idx = Fname.lastIndexOf(".");
			String ext = Fname.substring(idx);
			
			String random = UUID.randomUUID().toString();
			String newName = random + ext;
			
			File oriFile = new File(savePath+"/"+Fname);
			File newFile = new File(savePath+"/"+newName);
			
			newFiles.add(newName); 
			oriFile.renameTo(newFile); 
		}
		
		//데이터 수신
		String prodCate1 = mr.getParameter("category1"); 
		String prodCate2 = mr.getParameter("category2"); 
		String prodName  = mr.getParameter("prodName"); 
		String descript  = mr.getParameter("descript"); 
		String company	 = mr.getParameter("company");  
		String seller	 = mr.getParameter("seller");  
		String price	 = mr.getParameter("price");	
		String discount  = mr.getParameter("discount");
		String point	 = mr.getParameter("point");	
		String stock	 = mr.getParameter("stock");	
		String delivery	 = mr.getParameter("delivery");	
		String thumb1	 = "/Kmarket1/file/"+newFiles.get(0);	
		String thumb2	 = "/Kmarket1/file/"+newFiles.get(1);	
		String thumb3	 = "/Kmarket1/file/"+newFiles.get(2);	
		String detail	 = "/Kmarket1/file/"+newFiles.get(3);	
		String status	 = mr.getParameter("status");	
		String duty		 = mr.getParameter("duty");		
		String receipt	 = mr.getParameter("receipt");	
		String bizType	 = mr.getParameter("bizType");	
		String origin	 = mr.getParameter("origin");	
		String ip		 = req.getRemoteAddr();
		
		ProductVO vo = new ProductVO();
		
		vo.setProdCate1(prodCate1);
		vo.setProdCate2(prodCate2);
		vo.setProdName(prodName);
		vo.setDescript(descript);
		vo.setCompany(company);
		vo.setSeller(seller);
		vo.setPrice(price);
		vo.setDiscount(discount);
		vo.setPoint(point);
		vo.setStock(stock);
		vo.setDelivery(delivery);
		vo.setThumb1(thumb1);
		vo.setThumb2(thumb2);
		vo.setThumb3(thumb3);
		vo.setDetail(detail);
		vo.setStatus(status);
		vo.setDuty(duty);
		vo.setReceipt(receipt);
		vo.setBizType(bizType);
		vo.setOrigin(origin);
		vo.setIp(ip);
		
		AdminDAO.getInstance().insertProduct(vo);
		
		//productList로 리다이렉트
		resp.sendRedirect("/Kmarket1/admin/productList.do");
	}
	
}

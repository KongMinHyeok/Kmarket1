<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/admin/_header.jsp"/>
<script>

$(function(){
	$('select[name=cate]').click(function(){
		
	});
});

</script>
     <section id="admin-notice-list">
         <nav>
             <h3>자주묻는질문 목록</h3>
             <p>
                 HOME > 고객센터 > <strong>자주묻는질문</strong>
             </p>
         </nav>
         <article class="list">
             <select name="cate1">
              <option value="0">1차선택</option>
              <c:forEach var="cate" items="${faqct}">
              	<option value="${cate.cate}">${cate.cate}</option>
              </c:forEach>
         	</select>
         	<select name="cate2">
              <option value="0">2차선택</option>
              <c:forEach var="cate2" items="${faqct2}">
              	<option value="${cate2.cate2}">${cate2.cate2}</option>
              </c:forEach>
         	</select>
                 <table>
                      <tr>
                       <th><input type="checkbox"></th>
                       <th>번호</th>
                       <th>1차유형</th>
                       <th>2차유형</th>
                       <th>제목</th>
                       <th>조회</th>
                       <th>날짜</th>
                       <th>관리</th>
                      </tr>
                      <c:forEach var="faq" items="${faqs}" begin="0" end="9">
        			  <tr>
         			   <td><input type="checkbox" name="all" value="${faq.no}"></td>
                	   <td>${faq.no}</td>
                       <td>${faq.cate}</td>
                       <td>${faq.cate2}</td>
                       <td><a href="/Kmarket1/admin/cs/faq/view.do?cate=${faq.cate}&no=${faq.no}&cate2=${faq.cate2}">${faq.title}</a></td>
                       <td>${faq.hit}</td>
                       <td>${faq.rdate}</td>
				 	   <td>
                          <a href="/Kmarket1/admin/cs/faq/delete.do?no=${faq.no}">[삭제]</a>
                          <a href="/Kmarket1/admin/cs/faq/modify.do?no=${faq.no}">[수정]</a>
                  	   </td>
        			  </tr>
    			 	  </c:forEach>
                 </table>
                    <a href="/Kmarket1/admin/cs/faq/delete.do?no=${no}" class="btnDelete">선택삭제</a>
                    <a href="/Kmarket1/admin/cs/faq/write.do" class="btnWrite">작성하기</a>

		</article>
     </section>
    </main>
<jsp:include page="/admin/_footer.jsp"/>
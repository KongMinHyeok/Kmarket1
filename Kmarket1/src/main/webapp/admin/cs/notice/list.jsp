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
             <h3>공지사항 목록</h3>
             <p>
                 HOME > 고객센터 > <strong>공지사항</strong>
             </p>
         </nav>
         <article class="list">
             <select name="cate">
              <option value="0">유형선택</option>
              <option value="service">고객 서비스</option>
              <option value="safe">안전거래</option>
              <option value="product">위해상품</option>
              <option value="event">이벤트 당첨</option>
         	</select>
                 <table>
                      <tr>
                       <th><input type="checkbox"></th>
                       <th>번호</th>
                       <th>유형</th>
                       <th>제목</th>
                       <th>조회</th>
                       <th>날짜</th>
                       <th>관리</th>
                      </tr>
                      <c:forEach var="notice" items="${articles}">
        			  <tr>
         			   <td><input type="checkbox" name="all" value="${notice.no}"></td>
                	   <td>${notice.no}</td>
                       <td>${notice.cate}</td>
                       <td><a href="/Kmarket1/admin/cs/notice/view.do?cate=${notice.cate}&no=${notice.no}&pg=${pg}">${notice.title}</a></td>
                       <td>${notice.hit}</td>
                       <td>${notice.rdate}</td>
				 	   <td>
                          <a href="/Kmarket1/admin/cs/notice/delete.do?no=${notice.no}">[삭제]</a>
                          <a href="/Kmarket1/admin/cs/notice/modify.do?no=${notice.no}">[수정]</a>
                  	   </td>
        			  </tr>
    			 	  </c:forEach>
                 </table>
                 <div class="page">
		          	<c:if test="${pageGroupStart gt 1 && cate ne null}">
		            	<a href="/Kmarket1/admin/cs/notice/list.do?pg=${pageGroupStart-1}&cate=${cate}" class="prev">이전</a>
		          	</c:if>
		          	<c:if test="${pageGroupStart gt 1 && cate eq null}">
		            	<a href="/Kmarket1/admin/cs/notice/list.do?pg=${pageGroupStart-1}" class="prev">이전</a>
		          	</c:if>
		            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
		            <c:choose>
		             <c:when test="${cate ne null}">
		             	<a href="/Kmarket1/admin/cs/notice/list.do?pg=${num}&cate=${cate}" class="num ${currentPage eq num ? 'on' : 'off' }">${num}</a>
		            	</c:when>
		           	</c:choose>
		           	<c:choose>
		             <c:when test="${cate eq null}">
						<a href="/Kmarket1/admin/cs/notice/list.do?pg=${num}" class="num ${currentPage eq num ? 'on' : 'off' }">${num}</a>
		            	</c:when>
		           	</c:choose>
		            </c:forEach>
		            <c:if test="${pageGroupEnd lt lastPageNum && cate ne null}">
		            	<a href="/Kmarket1/admin/cs/notice/list.do?pg=${pageGroupStart+1}&cate=${cate}" class="next">다음</a>
		            </c:if>
		            <c:if test="${pageGroupEnd lt lastPageNum && cate eq null}">
		            	<a href="/Kmarket1/admin/cs/notice/list.do?pg=${pageGroupStart+1}" class="next">다음</a>
		            </c:if>
                 </div>
                    <a href="/Kmarket1/admin/cs/notice/delete.do?no=${item.no}" class="btnDelete">선택삭제</a>
                    <a href="/Kmarket1/admin/cs/notice/write.do" class="btnWrite">작성하기</a>
		</article>
     </section>
    </main>
<jsp:include page="/admin/_footer.jsp"/>
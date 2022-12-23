<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/admin/_header.jsp"/>
            <section id="admin-notice-view">
                <nav>
                    <h3>자주묻는질문 보기</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <article class="list">
	               <table>
	               	<tr>
	               		<th>유형</th>
	               		<td>${article.cate}-${article.cate2}</td>
	               	</tr>
	               	<tr>
	               		<th>제목</th>
	               		<td>${article.title}</td>
	               	</tr>
	               	<tr>
	               		<th>내용</th>
	               		<td>${article.content}</td>
	               	</tr>
	               </table>
	               <div>
	               <c:if test="${pg eq ''}">	
	               	<a href="/Kmarket1/admin/cs/faq/list.do" class="btnList">목록</a>
	               </c:if>
	               <c:if test="${pg ne ''}">
					<a href="/Kmarket1/admin/cs/faq/list.do?pg=${pg}" class="btnList">목록</a>
					</c:if>
						<a href="/Kmarket1/admin/cs/faq/modify.do?&cate=${cate}&cate2=${cate2}&no=${no}" class="btnModify">수정</a>
						<a href="/Kmarket1/admin/cs/faq/delete.do?&cate=${cate}&no=${no}" class="btnDelete">삭제</a>
					</div>
	        	</article>        
            </section>
        </main>
<jsp:include page="/admin/_footer.jsp"/>
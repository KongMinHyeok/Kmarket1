<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/admin/_header.jsp"/>
            <section id="admin-notice-view">
                <nav>
                    <h3>문의하기 답변</h3>
                    <p>
                        HOME > 고객센터 > <strong>문의하기</strong>
                    </p>
                </nav>
				<form action="/Kmarket1/admin/cs/qna/reply.do" method="post">
                <input type="hidden" name="no" value="${qna.no}"/>
                <article class="list">
	               <table>
	               	<tr>
	               		<th>유형</th>
	               		<td>${qna.cate}-${qna.cate2}</td>
	               	</tr>
	               	<tr>
	               		<th>제목</th>
						<td>${qna.title}</td>
	               	</tr>
	               	<tr>
	               		<th>내용</th>
	               		<td>${qna.content}</td>
	               	</tr>
					<tr>
	               		<th>답변</th>
	               		<td><textarea name="comment"></textarea></td>
	               	</tr>
	               </table>
	               <div class="btnNotice">
	               <a href="/Kmarket1/admin/cs/qna/delete.do?&cate=${cate}&no=${no}" class="btnDeleteqna">삭제</a>
	               <input class="noticeModify" type="submit" name="submit" value="답변등록">
				   <c:if test="${pg eq ''}">
	               	<a href="/Kmarket1/admin/cs/qna/list.do" class="btnqnaList">목록</a>
	               </c:if>
	               <c:if test="${pg ne ''}">
					<a href="/Kmarket1/admin/cs/qna/list.do?pg=${pg}" class="btnqnaList">목록</a>
				   </c:if>
				   </div>
	        	</article>
	          </form>        
            </section>
        </main>
<jsp:include page="/admin/_footer.jsp"/>
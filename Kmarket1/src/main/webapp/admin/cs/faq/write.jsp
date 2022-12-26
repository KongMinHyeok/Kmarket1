<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/admin/_header.jsp"/>
            <section id="admin-notice-view">
                <nav>
                    <h3>자주묻는질문 작성</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는 질문</strong>
                    </p>
                </nav>
				<form action="/Kmarket1/admin/cs/faq/write.do" method="post">
                <input type="hidden" name="uid" value="${uid}">
                <article class="list">
	               <table>
	               	<tr>
	               		<th>유형</th>
	               		<td>
                          <select name="cate">
                              <option value="0">1차 선택</option>
                              <option value="member" >회원</option>
                              <option value="event">쿠폰/혜택/이벤트</option>
                              <option value="order">주문/결제</option>
                              <option value="ship">배송</option>
                              <option value="cancel">취소/반품/교환</option>
                              <option value="trip">여행/숙박/항공</option>
                              <option value="safe">안전거래</option>
                          </select>
			         	<select name="cate2">
			              <option value="0">2차선택</option>
			              <c:forEach var="cate2" items="${faqct2}">
			              	<option value="${cate2.cate2}">${cate2.cate2}</option>
			              </c:forEach>
			         	</select>
	               		</td>
	               	</tr>
	               	<tr>
	               		<th>제목</th>
	               		<td><input type="text" name="title" placeholder="제목을 입력해주세요"></td>
	               	</tr>
	               	<tr>
	               		<th>내용</th>
	               		<td><textarea name="content" placeholder="내용을 입력해주세요"></textarea></td>
	               	</tr>
	               </table>
	               <div class="btnNotice">
                      <a href="/Kmarket1/admin/cs/faq/list.do" class="noticecancel">취소하기</a>
                      <input name="submit"  class="noticeWrite" type="submit" value="등록하기">      
					</div>
	        	</article>
	        	</form>
            </section>
        </main>
<jsp:include page="/admin/_footer.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:include page="../_header.jsp"/>
      <section id="cs">
        <div class="qna">
          <nav>
            <div>
              <p>홈<span>></span>문의하기</p>
            </div>
          </nav>
          <section class="list">
            <aside>
              <h2>문의하기</h2>
              <ul>
	            <li class="${cate eq null || cate eq 'member' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=member">회원</a></li>
                <li class="${cate eq 'event' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=event">쿠폰/이벤트</a></li>
                <li class="${cate eq 'order' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=order">주문/결제</a></li>
                <li class="${cate eq 'ship' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=ship">배송</a></li>
                <li class="${cate eq 'cancel' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=cancel">취소/반품/교환</a></li>
                <li class="${cate eq 'trip' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=trip">여행/숙박/항공</a></li>
                <li class="${cate eq 'safe' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=safe">안전거래</a></li>
              </ul>
            </aside>
            <article>
              <nav>
               <c:choose>
	              <c:when test="${cate eq null || cate eq 'member'}"><h1>회원</h1><h2>회원 관련 문의내용 입니다.</h2></c:when>
	              <c:when test="${cate eq 'event'}"><h1>쿠폰/이벤트</h1><h2>쿠폰/이벤트 관련 문의내용 입니다.</h2></c:when>
	              <c:when test="${cate eq 'order'}"><h1>주문/결제</h1><h2>주문/결제 관련 문의내용 입니다.</h2></c:when>
	              <c:when test="${cate eq 'ship'}"><h1>배송</h1><h2>배송 관련 문의내용 입니다.</h2></c:when>
	              <c:when test="${cate eq 'cancel'}"><h1>취소/반품/교환</h1><h2>취소/반품/교환 관련 문의내용 입니다.</h2></c:when>
	              <c:when test="${cate eq 'trip'}"><h1>여행/숙박/항공</h1><h2>여행/숙박/항공 관련 문의내용 입니다.</h2></c:when>
	              <c:when test="${cate eq 'safe'}"><h1>안전거래</h1><h2>안전거래 관련 문의내용 입니다.</h2></c:when>
	           </c:choose>
              </nav>
              <table>
				<c:forEach var="qna" items="${articles}">
                <tr>
                  <td><a href="/Kmarket1/cs/qna/view.do?no=${qna.no}&cate=${qna.cate}">[${qna.cate2}]${qna.title}</a></td>
             		<c:choose>
					<c:when test="${fn:length(qna.uid) gt 5}">
						<td>${fn:substring (qna.uid,0,fn:length(qna.uid)-3)}***</td>
                   </c:when>
	                <c:otherwise>
	                   	<td>${fn:substring (qna.uid,0,fn:length(qna.uid)-2)}**</td>
	                </c:otherwise>
                   </c:choose>
                  <td>${qna.rdate}</td>
                </tr>
				</c:forEach>
              </table>
              <div class="page">
              	<c:if test="${pageGroupStart gt 1 && cate ne null}">
                	<a href="/Kmarket1/cs/qna/list.do?pg=${pageGroupStart-1}&cate=${cate}" class="prev">이전</a>
              	</c:if>
              	<c:if test="${pageGroupStart gt 1 && cate eq null}">
                	<a href="/Kmarket1/cs/qna/list.do?pg=${pageGroupStart-1}" class="prev">이전</a>
              	</c:if>
                <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <c:choose>
	                <c:when test="${cate ne null}">
	                	<a href="/Kmarket1/cs/qna/list.do?pg=${num}&cate=${cate}" class="num on${(num eq currentPage)? 'current':'off'}">${num}</a>
	               	</c:when>
               	</c:choose>
               	<c:choose>
	                <c:when test="${cate eq null}">
						<a href="/Kmarket1/cs/qna/list.do?pg=${num}" class="num on${(num eq currentPage)? 'current':'off'}">${num}</a>
	               	</c:when>
               	</c:choose>
                </c:forEach>
                <c:if test="${pageGroupEnd lt lastPageNum && cate ne null}">
                	<a href="/Kmarket1/cs/qna/list.do?pg=${pageGroupStart+1}&cate=${cate}" class="next">다음</a>
                </c:if>
                <c:if test="${pageGroupEnd lt lastPageNum && cate eq null}">
                	<a href="/Kmarket1/cs/qna/list.do?pg=${pageGroupStart+1}" class="next">다음</a>
                </c:if>
              </div>
              <a href="/Kmarket1/cs/qna/write.do?cate=${cate}" class="btnWrite">문의하기</a>
            </article>
          </section>
        </div>
      </section>
<jsp:include page="../_footer.jsp"/>

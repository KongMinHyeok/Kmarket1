<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
      <section id="cs">
        <div class="notice">
          <nav>
            <div>
              <p>홈<span>></span>공지사항</p>
            </div>
          </nav>
          <section class="list">
            <aside>
              <h2>공지사항</h2>
              <ul>
                <li class="${cate eq null ? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do">전체</a></li>
                <li class="${cate.equals('service')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=service">고객서비스</a></li>
                <li class="${cate.equals('safe')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=safe">안전거래</a></li>
                <li class="${cate.equals('product')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=product">위해상품</a></li>
                <li class="${cate.equals('event')? 'on':'off'}"><a href="/Kmarket1/cs/notice/list.do?cate=event">이벤트당첨</a></li>
              </ul>
            </aside>
            <article>
              <nav>
              <c:choose>
	              <c:when test="${cate eq null}"><h1>전체</h1><h2>공지사항 전체 내용입니다.</h2></c:when>
	              <c:when test="${cate eq 'service'}"><h1>고객서비스</h1><h2>고객서비스 전체 내용입니다.</h2></c:when>
	              <c:when test="${cate eq 'safe'}"><h1>안전거래</h1><h2>안전거래 전체 내용입니다.</h2></c:when>
	              <c:when test="${cate eq 'event'}"><h1>이벤트당첨</h1><h2>이벤트당첨 전체 내용입니다.</h2></c:when>
	              <c:otherwise><h1>위해상품</h1><h2>위해상품 전체 내용입니다.</h2></c:otherwise>
              </c:choose>
              </nav>

              <table>
              <c:forEach var="notice" items="${articles}">
                <tr>
                  <td><a href="/Kmarket1/cs/notice/view.do?no=${notice.no}&cate=${notice.cate}">${notice.title}</a></td>
                  <td>${notice.rdate}</td>
                </tr>
               </c:forEach>
               </table>
              <div class="page">
              	<c:if test="${pageGroupStart gt 1 && cate ne null}">
                	<a href="/Kmarket1/cs/notice/list.do?pg=${pageGroupStart-1}&cate=${cate}" class="prev">이전</a>
              	</c:if>
              	<c:if test="${pageGroupStart gt 1 && cate eq null}">
                	<a href="/Kmarket1/cs/notice/list.do?pg=${pageGroupStart-1}" class="prev">이전</a>
              	</c:if>
                <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <c:choose>
	                <c:when test="${cate ne null}">
	                	<a href="/Kmarket1/cs/notice/list.do?pg=${num}&cate=${cate}" class="num on${(num eq currentPage)? 'current':'off'}">${num}</a>
	               	</c:when>
               	</c:choose>
               	<c:choose>
	                <c:when test="${cate eq null}">
						<a href="/Kmarket1/cs/notice/list.do?pg=${num}" class="num on${(num eq currentPage)? 'current':'off'}">${num}</a>
	               	</c:when>
               	</c:choose>
                </c:forEach>
                <c:if test="${pageGroupEnd lt lastPageNum && cate ne null}">
                	<a href="/Kmarket1/cs/notice/list.do?pg=${pageGroupStart+1}&cate=${cate}" class="next">다음</a>
                </c:if>
                <c:if test="${pageGroupEnd lt lastPageNum && cate eq null}">
                	<a href="/Kmarket1/cs/notice/list.do?pg=${pageGroupStart+1}" class="next">다음</a>
                </c:if>
              </div>
            </article>
          </section>
        </div>
      </section>
<jsp:include page="../_footer.jsp"/>
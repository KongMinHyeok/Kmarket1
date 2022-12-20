<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(function() {	
	
	$('.more').click(function(e) {
			e.preventDefault();
			$('li').show();
			$('.more').click(function(e){
				$('.list:nth-child(n+4)').hide();
			});
		});
	
});
</script>
<jsp:include page="../_header.jsp"/>
      <section id="cs">
        <div class="faq">
          <nav>
            <div>
              <p>홈<span>></span>자주묻는 질문</p>
            </div>
          </nav>
          <section class="list">
            <aside>
              <h2>자주묻는 질문</h2>
              <ul>
                <li class="${cate eq null || cate eq 'member' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=member">회원</a></li>
                <li class="${cate eq 'event' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=event">쿠폰/이벤트</a></li>
                <li class="${cate eq 'order' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=order">주문/결제</a></li>
                <li class="${cate eq 'ship' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=ship">배송</a></li>
                <li class="${cate eq 'cancel' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=cancel">취소/반품/교환</a></li>
                <li class="${cate eq 'trip' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=trip">여행/숙박/항공</a></li>
                <li class="${cate eq 'safe' ? 'on':'off'}"><a href="/Kmarket1/cs/faq/list.do?cate=safe">안전거래</a></li>
              </ul>
            </aside>
            <article>              
              <nav>
               <c:choose>
	              <c:when test="${cate eq null || cate eq 'member'}"><h1>회원</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
	              <c:when test="${cate eq 'event'}"><h1>쿠폰/이벤트</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
	              <c:when test="${cate eq 'order'}"><h1>주문/결제</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
	              <c:when test="${cate eq 'ship'}"><h1>배송</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
	              <c:when test="${cate eq 'cancel'}"><h1>취소/반품/교환</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
	              <c:when test="${cate eq 'trip'}"><h1>여행/숙박/항공</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
	              <c:when test="${cate eq 'safe'}"><h1>안전거래</h1><h2>가장 자주 묻는 질문입니다.</h2></c:when>
              </c:choose>
              </nav>
              <div>
              <c:forEach var="cate" items="${cate2}">
                <h3>${cate.cate2}</h3>
				<ul>
                 <c:forEach var="faq" items="${faqs}">
					<c:if test="${faq.cate2 eq cate.cate2}">
	                  <li class="list"><a href="/Kmarket1/cs/faq/view.do?no=${faq.no}&cate=${faq.cate}"><span>Q.</span>${faq.title}</a></li>
	                </c:if>
                 </c:forEach>
                  <li class="more"><a href="#">더보기</a></li>
                </ul>
                </c:forEach>
              </div>
            </article>
          </section>
        </div>
      </section>
<jsp:include page="../_footer.jsp"/>
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
          <section class="view">
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
                <h2 class="title">[${qna.cate2}]${qna.title}</h2>
                <p>
                  <c:choose>
					<c:when test="${fn:length(qna.uid) gt 5}">
						<span class="uid">${fn:substring (qna.uid,0,fn:length(qna.uid)-3)}***</span>
                       </c:when>
                    <c:otherwise>
                       	<span class="uid">${fn:substring (qna.uid,0,fn:length(qna.uid)-2)}**</span>
                    </c:otherwise>
                  </c:choose>
                  <span>${qna.rdate}</span>
                </p>
              </nav>

              <div class="content">
                <p>
                  ${qna.content}
                </p>
                <p>
                  ※ 피싱 관련 피해신고<br /><br />
                  ▶ 경찰청 사이버수사국 (국번없이)182 :
                  <a href="http://cyberbureau.police.go.kr">http://cyberbureau.police.go.kr</a><br />
                  ▶ KISA 인터넷침해대응센터 (국번없이)118 :
                  <a href="http://www.krcert.or.kr">http://www.krcert.or.kr</a><br />
                  감사합니다.<br />
                </p>
              </div>
              <a href="/Kmarket1/cs/qna/list.do?cate=${qna.cate}" class="btnList">목록보기</a>
            </article>
          </section>
        </div>
      </section>
<jsp:include page="../_footer.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:include page="./_header.jsp"/>
<section id="cs">
    <div class="main">
        <h1 class="title">
            <strong>케이마켓</strong>이 도와드릴게요!
        </h1>
        <section class="notice">
            <h1>
                공지사항
                <a href="/Kmarket1/cs/notice/list.do?group=notice">전체보기</a>
            </h1>
            <ul>
           		<c:forEach var="notice" items="${notices}">
	                <li>
	                    <a href="#" class="title">${notice.title}</a>
	                    <span class="date">${notice.rdate}</span>
	                </li>
				</c:forEach>
            </ul>
        </section>
        <section class="faq">
            <h1>자주 묻는 질문<a href="/Kmarket1/cs/faq/list.do?group=faq">전체보기</a></h1>
            <ol>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member"><span>회원</span></a>
                </li>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member"><span>쿠폰/이벤트</span></a>
                </li>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member""><span>주문/결제</span></a>
                </li>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member""><span>배송</span></a>
                </li>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member""><span>취소/반품/교환</span></a>
                </li>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member""><span>여행/숙박/항공</span></a>
                </li>
                <li>
                    <a href="/Kmarket1/cs/faq/list.do?group=faq&cate=member""><span>안전거래</span></a>
                </li>
            </ol>
        </section>
        <section class="qna">
            <h1>문의하기<a href="/Kmarket1/cs/qna/list.do?group=qna">전체보기</a></h1>
            <ul>
            <c:forEach var="qna" items="${qnas}">
                <li>
                    <a href="#" class="title">${qna.title}</a>
                    <p>
						<c:choose>
						<c:when test="${fn:length(qna.uid) gt 5}">
							<span class="uid">${fn:substring (qna.uid,0,fn:length(qna.uid)-3)}***</span>
                        </c:when>
	                    <c:otherwise>
                        	<span class="uid">${fn:substring (qna.uid,0,fn:length(qna.uid)-2)}**</span>
	                    </c:otherwise>
                        </c:choose>
                        <span class="date">${qna.rdate}</span>
                    </p>
                </li>
            </c:forEach>
            </ul>
            <a href="/Kmarket1/cs/qna/write.do?group=qna" class="ask">문의글 작성 ></a>
        </section>
        <section class="tel">
            <h1>1:1 상담이 필요하신가요?</h1>
            <article>
                <div>
                    <h3>고객센터 이용안내</h3>
                    <p>
                        <span>일반회원/비회원</span><br/>
                        <strong>1566-0001</strong>
                        <span>(평일 09:00 ~ 18:00)</span>
                    </p>
                    <p>
                        <span>스마일클럽 전용</span><br/>
                        <strong>1566-0002</strong>
                        <span>(365일 09:00 ~ 18:00)</span>
                    </p>
                </div>
            </article>
            <article>
                <div>
                    <h3>판매상담 이용안내</h3>
                    <p>
                        <span>판매고객</span><br/>
                        <strong>1566-5700</strong>
                        <span>(평일 09:00 ~ 18:00)</span>
                    </p>
                    <p>
                        <a href="#">판매자 가입 및 서류 접수 안내 ></a>
                    </p>
                </div>
            </article>
        </section>
    </div>
</section>
<jsp:include page="./_footer.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<h1>상품목록</h1>
	<p>HOME > 
	<c:choose>
	           <c:when test="${prodCate1 eq '10'}">
	           <em>브랜드패션</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '11'}">
	           <em>패션의류·잡화·뷰티</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '12'}">
	           <em>유아동</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '13'}">
	           <em>식품·생필품</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '14'}">
	           <em>홈데코·문구·취미·반려</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '15'}">
	           <em>컴퓨터·디지털·가전</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '16'}">
	           <em>스포츠·건강·렌탈</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '17'}">
	           <em>자동차·공구</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '18'}">
	           <em>여행·도서·티켓·e쿠폰</em>
	           </c:when>
	           </c:choose> > 
		<c:choose>
		<c:when test="${prodCate2 eq '10'}">
		<em>여성의류</em>
		</c:when>
		<c:when test="${prodCate2 eq '11'}">
		<em>남성의류</em>
		</c:when>
		<c:when test="${prodCate2 eq '12'}">
		<em>진/캐쥬얼</em>
		</c:when>
		<c:when test="${prodCate2 eq '13'}">
		<em>신발/가방</em>
		</c:when>
		<c:when test="${prodCate2 eq '14'}">
		<em>주얼리/시계</em>
		</c:when>
		<c:when test="${prodCate2 eq '15'}">
        <em>아웃도어</em>
        </c:when>
        </c:choose>
	</p>
	
	</nav>
	<!-- 
	           <c:choose>
	           <c:when test="${prodCate1 eq '10'}">
	           <em>브랜드패션</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '11'}">
	           <em>패션의류·잡화·뷰티</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '12'}">
	           <em>유아동</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '13'}">
	           <em>식품·생필품</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '14'}">
	           <em>홈데코·문구·취미·반려</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '15'}">
	           <em>컴퓨터·디지털·가전</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '16'}">
	           <em>스포츠·건강·렌탈</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '17'}">
	           <em>자동차·공구</em>
	           </c:when>
	           <c:when test="${prodCate1 eq '18'}">
	           <em>여행·도서·티켓·e쿠폰</em>
	           </c:when>
	           </c:choose>
	 -->
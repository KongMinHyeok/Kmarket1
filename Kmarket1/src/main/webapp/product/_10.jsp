<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<h1>상품목록</h1>
	<p>HOME > 패션·의류·뷰티 > 
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
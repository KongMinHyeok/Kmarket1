<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket1/img/favicon.ico">
    <link rel="stylesheet" href="/Kmarket1/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="./js/index.js"></script>
  </head>
  <body>
    <div id="wrapper">
      <header>
        <div class="top">
        <c:choose>
        <c:when test="${null eq sessMember }">
          <div>
            <a href="/Kmarket1/member/login.do">로그인</a>
            <a href="/Kmarket1/member/join.do">회원가입</a>
            <a href="/Kmarket1/member/login.do">마이페이지</a>
            <a href="/Kmarket1/product/cart.do?uid=${sessMember.uid}">
            	<i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
          </div>
         </c:when>
         <c:when test="${null ne sessMember}">
         	<div>
         		<a href="/Kmarket1/member/logout.do?uid=${sessMember.uid}">로그아웃</a>
         		<a href="#">${sessMember.name}님</a>
         		<a href="/Kmarket1/member/myPage.do?uid=${sessMember.uid}">마이페이지</a>
         		<a href="/Kmarket1/product/cart.do?uid=${sessMember.uid}">
         			<i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니
         		</a>
         	</div>
         </c:when>
         </c:choose>
        </div>
        <div class="logo">
          <div>
            <a href="/Kmarket1/index.do"><img src="./img/header_logo.png" alt="로고" /></a>
            <form action="#">
              <input type="text" name="search" />
              <button><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
        <div class="menu">
          <div>
            <ul>
              <li><a href="#">히트상품</a></li>
              <li><a href="#">추천상품</a></li>
              <li><a href="#">최신상품</a></li>
              <li><a href="#">인기상품</a></li>
              <li><a href="#">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="/Kmarket1/cs/notice/list.do">공지사항</a></li>
              <li><a href="/Kmarket1/cs/faq/list.do">자주묻는질문</a></li>
              <li><a href="/Kmarket1/cs/qna/list.do">문의하기</a></li>
              <li><a href="/Kmarket1/cs/index.do">고객센터</a></li>
            </ul>
          </div>
        </div>
      </header>
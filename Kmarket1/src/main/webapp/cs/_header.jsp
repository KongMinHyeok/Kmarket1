<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓 고객센터</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket1/img/favicon.ico" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/Kmarket1/cs/css/style.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <div id="wrapper">
      <header>
        <div class="top">
     	<c:choose>
       	  <c:when test="${null eq sessMember}">
            <div>
                <a href="/Kmarket1/member/login.do">로그인</a>
                <a href="/Kmarket1/member/join.do">회원가입</a>
                <a href="/Kmarket1/member/login.do">마이페이지</a>
                <a href="/Kmarket1/member/login.do">
                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니
                </a>
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
            <a href="/Kmarket1/cs/index.do"><img src="/Kmarket1/cs/img/logo.png" alt="로고" />고객센터</a>
          </div>
        </div>
      </header>
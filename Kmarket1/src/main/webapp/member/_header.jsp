<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/common.css?c">
    <link rel="stylesheet" href="./css/member.css?c">
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
	                    <a href="#">
	                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
	                        장바구니
	                    </a>
	                </div>
                </c:when>
                <c:when test="${null ne sessMember}">
                	<div>
	                    <a href="/Kmarket1/member/logout.do?uid=${sessMember.uid}">로그아웃</a>
	                    <a href="#">${sessMember.name}님</a>
	                    <a href="/Kmarket1/member/myPage.do?uid=${sessMember.uid}">마이페이지</a>
	                    <a href="#">
	                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
	                        장바구니
	                    </a>
	                </div>
                </c:when>
                </c:choose>
            </div>
            <div class="logo">
                <div>
                    <a href="../index.do">
                        <img src="./img/header_logo.png" alt="로고">
                    </a>
                </div>
            </div>
        </header>
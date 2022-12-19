<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/product.css">
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
	                    <a href="/Kmarket1/product/cart.do?uid=${sessMember.uid}">
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
                    <a href="#"><img src="./img/header_logo.png" alt="Kmarket" width="180px" height="49px"></a>
                    <form action="#">
                        <input type="text" name="keyword">
                        <button>
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li>
                            <a href="#">히트상품</a>
                        </li>
                        <li>
                            <a href="#">추천상품</a>
                        </li>
                        <li>
                            <a href="#">최신상품</a>
                        </li>
                        <li>
                            <a href="#">인기상품</a>
                        </li>
                        <li>
                            <a href="#">할인상품</a>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <a href="#">쿠폰존</a>
                        </li>
                        <li>
                            <a href="#">사용후기</a>
                        </li>
                        <li>
                            <a href="#">개인결제</a>
                        </li>
                        <li>
                            <a href="#">고객센터</a>
                        </li>
                        <li>
                            <a href="#">FAQ</a>
                        </li>
                    </ul>
                </div>
            </div>
        </header>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
        <jsp:include page="/product/_header.jsp" />
        <main id="product">
                <jsp:include page="/product/_aside.jsp" />
            <section class="list">
                <!-- 제목, 페이지 네비게이션 -->
                <jsp:include page="./_${prodCate1}.jsp"/>
                <!-- 정렬 메뉴 -->
                <ul class="sort">
                <!-- 방법을 type로 하여 각각 다르게 sql문 보내기 -->
                    <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=1" 
                    class="on">판매많은순</a></li>
                    <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=2" 
                    >낮은가격순</a></li>
                    <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=3" 
                    >높은가격순</a></li>
                    <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=4" 
                    >평점높은순</a></li>
                    <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=5" 
                    >후기많은순</a></li>
                    <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=6" 
                    >최근등록순</a></li>
                </ul>
                <!-- 상품 목록 -->
                <table border="0">
                    <tbody>
                        <c:forEach var="product" items="${products}">
                        <tr>
                            <!-- img는 예시 사이트에서 받아왔음 -->
                            <td><a href="/Kmarket1/product/view.do?prodNo=${product.prodNo}&prodCate1=${product.prodCate1}&prodCate2=${product.prodCate2}" class="goods"><img src="./img/120x120.png" alt="상품이미지"></a></td>
                            <td>
                                <h3 class="name">${product.prodName}</h3>
                                <a href="/Kmarket1/product/view.do?prodNo=${product.prodNo}&prodCate1=${product.prodCate1}&prodCate2=${product.prodCate2}" class="desc">${product.descript}</a>
                            </td>
                            <td>
                                <ul>
                                    <li><ins class="discount-price"><fmt:formatNumber value="${product.price * ((100 - product.discount)/100)}" pattern="#,###"/></ins></li>
                                    <li>
                                        <!-- del태그는 텍스트 한가운데 라인을 추가하여 문서에서 삭제된 텍스트 표현-->
                                        <del class="original-price">${product.price}</del>
                                        <span class="discount">${product.discount}%</span>
                                    </li>
                                    <c:choose>
                                    	<c:when test="${product.delivery == 0}">
                                    		<li><span class="free-delivery">무료배송</span></li> 
                                    	</c:when>
                                    	<c:otherwise>
                                    		<li><span class="nonfree-delivery">배송비 ${product.delivery}원</span></li>
                                    	</c:otherwise>
                                    </c:choose>
                                </ul>
                            </td>
                            <td>
                                <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${product.seller}</h4>
                                <h5 class="badge power">판매자등급</h5>
                                <!-- 반올림해서 rating star로 바꿔야할듯? -->
                                <h6 class="rating star1">상품평</h6>
                              </td>
                        </tr>
                        </c:forEach>
                       
                    </tbody>
                </table>
                <!-- 상품목록 페이지번호 -->
              <div class="paging">
              	<c:if test="${pageGroupStart >1}">
                <span class="prev">
                  <a href="/Kmarket1/product/list.do?pg=${pageGroupStart -1}&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=${type}"><&nbsp;이전</a>
                </span>
                </c:if>
                <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
                <span class="num">
                  <a href="/Kmarket1/product/list.do?pg=${num}&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=${type}" 
                  class="num${(num == currentPage)? '_on' : '_off'}">${num}</a>
                </span>
                </c:forEach>
                <c:if test="${pageGroupEnd < lastPageNum}">
                <span class="next">
                  <a href="/Kmarket1/product/list.do?pg=${pageGroupEnd +1}&prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=${type}">다음&nbsp;></a>
                </span>
                </c:if>
              </div>
            </section>
        </main>
        <footer>
            <ul>
                <li>
                    <a href="#">회사소개</a>
                </li>
                <li>
                    <a href="#">서비스이용약관</a>
                </li>
                <li>
                    <a href="#">개인정보처리방침</a>
                </li>
                <li>
                    <a href="#">전자금융거래약관</a>
                </li>
            </ul>
            <div>
                <p>
                    <img src="./img/footer_logo.png" alt="로고">                </p>
                    <p>
                        <strong>(주)KMARKET</strong><br>
                        부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br>
                        대표이사 : 홍길동<br>
                        사업자등록번호 : 220-81-83676 사업자정보확인<br>
                        통신판매업신고 : 강남 10630호 Fax : 02-589-8842
                      </p>
                      <p>
                        <strong>고객센터</strong><br>
                        Tel : 1234-5678 (평일 09:00~18:00)<br>
                        스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br>
                        경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br>
                        Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br>
                      </p>
            </div>
        </footer>
        <!-- 상단이동 버튼 -->
        <button type="button" id="top">상단이동</button>
    </div>    
</body>
</html>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
    	// 페이지 로딩때부터 판매가 * 1
    $(document).ready(function(){
    	var countnum = $('input[name = num]').val();
    	var num = parseInt(countnum);
    	var total =${product.delivery} +  num * ${product.price * ((100 - product.discount)/100)};
    	$('input[name=total]').attr('value',total);
	});
    $(function(){
    	// 감소 버튼 클릭시----------------------------------------------------------------
    	$('.decrease').click(function(){
    	var countnum = $('input[name = num]').val();
    	if(countnum > 1){
    	countnum--;
    	}
    	var num = parseInt(countnum);
    	$('input[name=num]').attr('value',num);
    	var total =${product.delivery} + num * ${product.price * ((100 - product.discount)/100)};
    	$('input[name=total]').attr('value',total);
    	});

    	//증가 버튼 클릭시------------------------------------------------------------------
    	$('.increase').click(function(){
    	var countnum = $('input[name = num]').val();
    	countnum++;
    	var num = parseInt(countnum);
    	$('input[name=num]').attr('value',num);
    	var total =${product.delivery} + num * ${product.price * ((100 - product.discount)/100)};
    	$('input[name=total]').attr('value',total);
    	});
    	//장바구니 버튼 클릭시-----------------------------------------------------------------	
    	// view에서 장바구니로 데이터 넘기기
    	$('.cart').click(function(){
    		
    		let uid = $('input[name=uid]').val();
			let prodNo = $('input[name=prodNo]').val();
			let count = $('input[name=num]').val();
			let price = $('input[name=price]').val();
			let discount = $('input[name=discount]').val();
			let point = $('input[name=point]').val();
			let delivery = $('input[name=delivery]').val();
			let total = $('input[name=total]').val();
			let rdate = $('input[name=rdate]').val();
			
    		let jsonData = {
    				"uid": uid,
    				"prodNo": prodNo,
    				"count": count,
    				"price": price,
    				"discount": discount,
    				"point": point,
    				"delivery": delivery,
    				"total": total,
    				"rdate": rdate
    		};
			console.log(jsonData);
			
    		$.ajax({
    			url: '/Kmarket1/product/view.do',
    			type: 'POST',
    			data: jsonData,
    			dataType: 'json',
    			success: function(result) {
    		          if (result) {
    		              alert("완료");
    		          } else {
    		              alert("전송된 값 없음");
    		          }
    		      },
    		      error: function() {
    		          alert("에러 발생");
    		      }
    		});
    	});
	//
    });
    </script>
    <style>
    </style>
</head>
<body>
    <div id="wrapper">
                <jsp:include page="/product/_header.jsp" />
        <main id="product">
            <aside>
                <ul class="category">
                    <!-- 아이콘들 Font Awesome에서 들고온거라 복붙했음 -->     
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#"><i class="fas fa-tshirt"></i>패션·의류·뷰티</a>
                        <ol>
                            <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=10&prodCate2=10&type=1">여성의류</a></li>
                            <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=10&prodCate2=11&type=1">남성의류</a></li>
                            <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=10&prodCate2=12&type=1">진/캐쥬얼</a></li>
                            <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=10&prodCate2=13&type=1">신발/가방</a></li>
                            <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=10&prodCate2=14&type=1">주얼리/시계</a></li>
                            <li><a href="/Kmarket1/product/list.do?pg=1&prodCate1=10&prodCate2=15&type=1">아웃도어</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-laptop"></i>가전·디지털</a>
                        <ol>
                            <li><a href="#">노트북/PC</a></li>
                            <li><a href="#">가전</a></li>
                            <li><a href="#">휴대폰</a></li>
                            <li><a href="#">기타</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-utensils"></i>식품·생필품</a>
                        <ol>
                            <li><a href="#">신선식품</a></li>
                            <li><a href="#">가공식품</a></li>
                            <li><a href="#">건강식품</a></li>
                            <li><a href="#">생필품</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-home"></i>홈·문구·취미</a>
                        <ol>
                            <li><a href="#">가구/DIY</a></li>
                            <li><a href="#">침구·커튼</a></li>
                            <li><a href="#">생활용품</a></li>
                            <li><a href="#">사무용품</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>
            <section class="view">
                <!-- 제목, 페이지 네비게이션 -->
				<jsp:include page="./_${prodCate1}.jsp"/>
				<input type="hidden" name="uid" value="${sessMember.uid}">
				<input type="hidden" name="prodNo" value="${product.prodNo}">
                <!-- 상품 전체 내용 -->
                <article class="info">
                    <div class="image">
                        <img src="./img/460x460.png" alt="예시 이미지">
                    </div>
                    <div class="summary">
                        <nav>
                            <h1>${product.seller}</h1>
                            <h2>상품번호 : ${product.prodNo}</h2>
                            <input type="hidden" name="rdate" value="${product.rdate}">
                        </nav>
                        <nav>
                            <h3>${product.prodName}</h3>
                            <p>${product.descript}</p>
                            <h5 class="rating star4">
                                <a href="#">상품평보기</a>
                            </h5>
                        </nav>
                        <nav>
                            <div class="original-price">
                                <del>${product.price}</del>
                                <input type="hidden" name="price" value="${product.price}">
                                <span>${product.discount}%</span>
                                <input type="hidden" name="discount" value="${product.discount}">
                            </div>
                            <div class="discount-price">
                                <ins><fmt:formatNumber value="${product.price * ((100 - product.discount)/100)}" pattern="0"/></ins>
                                <input type="hidden" name="point" value="${product.point}">
                            </div>
                        </nav>
                        <nav>
                            <span class="delivery">
                            <input type="hidden" name="delivery" value="${product.delivery}">
                            <c:choose>
                            <c:when test="${product.delivery == 0}">
                            	무료배송
                            </c:when>
                            <c:otherwise>
                            	${product.delivery}원
                            </c:otherwise>
                            </c:choose>
                            </span>
                            <span class="arrival">모레(${koreanDOW}) ${formatedNow} 도착예정</span>
                            <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                        </nav>
                        <nav>
                            <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                            <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                        </nav>
                        <nav class="origin">
                            원산지-${product.origin}
                        </nav>
                        <img src="./img/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립" class="banner">
                        <div class="count">
                            <button class="decrease"></button>
                            <input type="text" name="num" value="1" readonly>
                            <button class="increase"></button>
                        </div>
                        <div class="total">
                            <span><input type="text" name="total" value"" readonly"></span>
                            <em>총 상품금액</em>
                        </div>
                        <div class="button">
                            <input type="button" class="cart" value="장바구니">
                            <input type="button" class="order" value="구매하기">
                        </div>
                    </div>
                </article>
                <!-- 상품정보 사진 -->
                <article class="detail">
                    <nav>
                        <h1>상품정보</h1>
                    </nav>
                    <img src="./img/860x460.png" alt="상품정보 이미지">
                    <img src="./img/860x460.png" alt="상품정보 이미지">
                    <img src="./img/860x460.png" alt="상품정보 이미지">
                </article>
                <!-- 상품정보 제공 고시내용-->
                <article class="notice">
                    <nav>
                        <h1>상품 정보 제공 고시</h1>
                        <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
                    </nav>
                    <table border="0">
                        <tbody>
                            <tr>
                                <td>상품번호</td>
                                <td>${product.prodNo}</td>
                            </tr>
                            <tr>
                                <td>상품상태</td>
                                <td>${product.status}</td>
                            </tr>
                            <tr>
                                <td>부가세 면세여부</td>
                                <td>${product.duty}</td>
                            </tr>
                            <tr>
                                <td>영수증발행</td>
                                <td>${product.receipt}</td>
                            </tr>
                            <tr>
                                <td>사업자구분</td>
                                <td>${product.bizType}</td>
                            </tr>
                            <tr>
                                <td>브랜드</td>
                                <td>${product.company}</td>
                            </tr>
                            <tr>
                                <td>원산지</td>
                                <td>${product.origin}</td>
                            </tr>
                        </tbody>
                    </table>
                    <table>
                        <tbody>
                            <tr>
                                <td>제품소재</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>색상</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>치수</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>제조자/수입국</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>제조국</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>취급시 주의사항</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>제조연월</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>품질보증기준</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>A/S 책임자와 전화번호</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td>주문후 예상 배송기간</td>
                                <td>상세정보 직접입력</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <p class="notice">
                        소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                        동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                        환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                        제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                        산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                        환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
                    </p>
                </article>

                <!-- 상품 리뷰-->
                <article class="review">
                    <nav>
                        <h1>상품리뷰</h1>
                    </nav>
                    <ul>
		            <c:forEach var="review" items="${reviews}">
		                <li>
		                    <div>
		                        <h5 class="rating star${review.rating}">상품평</h5>
		                        <span>${review.uid}	${review.rdate}</span>
		                    </div>
		                    <h3>${review.prodName}</h3>
		                    <p>${review.content}</p>
		                </li>
		            </c:forEach>
            		</ul>    
                 <!-- 상품목록 페이지번호 -->
              	<!-- 리뷰 페이지 번호 -->
	            <div class="paging">
		            <span class="prev">
			            <c:if test="${pageGroupStart > 1}">
			                <a href="/Kmarket1/product/view.do?prodNo=${prodNo}&prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${pageGroupStart - 1}"><&nbsp;이전</a>
			            </c:if>
			        </span>
			        <span class="num">
			            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
			                <a href="/Kmarket1/product/view.do?prodNo=${prodNo}&prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${num}" class="num ${num == currentPage ? 'on':'off'}">${num}</a>
			            </c:forEach>
			        </span>
			        <span class="next">
			            <c:if test="${pageGroupEnd < lastPageNum}">
			                <a href="/Kmarket1/product/view.do?prodNo=${prodNo}&prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${pageGroupEnd + 1}">다음&nbsp;></a>
			            </c:if>
		            </span>
	        	</div>
                </article>
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
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
    <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="/Kmarket1/product/js/postcode.js"></script>
    
    <script>
	  //onBeforeUnload 이벤트 지정
	  /*    
	  $(function(){
	    	  let uid = $('input[name=uid]').val();
			   let jsonData = {"uid": uid};
	    	  window.addEventListener('unload', function() {
	    		  navigator.sendBeacon('/Kmarket1/product/DeleteDirect.do', JSON.stringify({'uid': 'uid'}));
	    		});
	      });
	  */
	  
	  
	  
	  // 포인트 적용, order에서 complete 넘기기, 다이렉트 오더 해야함
	  $(document).ready(function(){
		  
		  
	    	$('.usePoint').click(function(){
	    		
	    		let finalTotalPrice = $('input[name=finalTotalPrice]').val();
	    		//alert(finalTotalPrice);
	    		
	    		let myPoint = ${sessMember.point};
	    		let usePoint = $('input[name=usePoint]').val();
	    		
	    		// 5000이하 거부
	    		if(usePoint < 5000){
	    			alert('포인트는 5000원부터 사용가능합니다');
	    			$('.usePoint').prop('disabled', true);
	    			return false;
	    		}else if(usePoint > myPoint){
	    			alert('가지고 있는 포인트 내에서 사용해 주세요');
	    			return false;
	    		}else if(5000 < usePoint < myPoint){
	    			$('.usedPoint').text(usePoint);
	    			finalTotalPrice = finalTotalPrice - usePoint;
	    			
	    			$('.finalTotalPrice > span').text(finalTotalPrice.toLocaleString());
	    			$('input[name=finalTotalPrice]').val(finalTotalPrice);
	    		}
	    	});
	    	/************************************/
	    	
	    	$("input[name=postcode]").click(function(){
	    		postcode();
	    	});
	    	$(".complete").click(function(){
	    		
	    		let ordCount = parseInt($('.finalCount').text());
	    		let ordPrice = $('input[name=finalPrice]').val();
	    		let ordDiscount = parseInt($('input[name=finalDiscount]').val());
	    		let ordDelivery = parseInt($('input[name=finalDelivery]').val());
	    		let savePoint = parseInt($('.savePoint').text());
	    		let usedPoint = $('input[name=usePoint]').val();
	    		let ordTotPrice = parseInt($('input[name=finalTotalPrice]').val());

	    		let recipName = $('input[name=orderer]').val();
	    		let recipHp = $('input[name=hp]').val();
	    		let recipZip = $('input[name=zip]').val();
	    		let recipAddr1 = $('input[name=addr1]').val();
	    		let recipAddr2 = $('input[name=addr2]').val();
	    		let ordUid = $('input[name=uid]').val();
	    		
	    		let ordPayment = $('input[name=payment]:checked').val();
	    		let ordComplete = 1;
	    		
	    		let jsonData = {
	    				"ordCount" : ordCount,
	    				"ordPrice" : ordPrice,
	    				"ordDiscount" : ordDiscount,
	    				"ordDelivery" : ordDelivery,
	    				"savePoint" : savePoint,
	    				"usedPoint" : usedPoint,
	    				"ordTotPrice" : ordTotPrice,
	    				"recipName" : recipName,
	    				"recipHp" : recipHp,
	    				"recipZip" : recipZip,
	    				"recipAddr1" : recipAddr1,
	    				"recipAddr2" : recipAddr2,
	    				"ordUid" : ordUid,
	    				"ordPayment" : ordPayment,
	    				"ordComplete" : ordComplete
	    		}
	    		
	    		console.log(jsonData);
	    		
	    		$.ajax({
	    			url : '/Kmarket1/product/order.do',
	    			type : 'POST',
	    			data : jsonData,
					traditional : true,
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
<<<<<<< HEAD
							location.href='/Kmarket1/product/complete.do?ordNo='+data.result;
=======
							location.href='/Kmarket1/product/complete.do?ordNo='+data.result
>>>>>>> 0b95a41be13698fdfc68f59227481ee3bcc2c8f4
							}
						}
					});
	    		});
	    	
	    	
	  });
    </script>
</head>
<body>
    <div id="wrapper">
                        <jsp:include page="/product/_header.jsp" />
        <main id="product">
                            <jsp:include page="/product/_aside.jsp" />
            <section class="order">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>주문결제</h1>
                    <p>HOME > 장바구니 > 주문결제</p>
                </nav>
                <!-- 주문 결제 창 -->
                <form action="#" method="get">
                    <table border="0">
                        <thead>
                            <tr>
                                <th></th>
                                <th>상품명</th>
                                <th>수량</th>
                                <th>판매가</th>
                                <th>할인</th>
                                <th>포인트</th>
                                <th>배송비</th>
                                <th>총합</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cart" items="${carts}">
                            <tr>
                                <td class="cart_info_td">
                                	<input type="hidden" name="cartNo" value="${cart.cartNo}">
                                	<input type="hidden" class="prodNo" name="prodNo" value="${cart.prodNo}">
                                	<input type="hidden" class="count" value="${cart.count}">
                                	<input type="hidden" class="price" value="${cart.price}">
                                	<input type="hidden" class="discount" value="${cart.price * cart.count * (cart.discount/100)}">
                                	<input type="hidden" class="point" value="${cart.point * cart.count}">
                                	<input type="hidden" class="delivery" value="${cart.delivery}">
                                	<input type="hidden" class="total" value="${cart.total - cart.price * cart.count * (cart.discount/100)}">
                                	${cart.cartNo}
                                </td>
                                <td>
                                    <article>
                                    <!-- 이거 상품번호로 carts products 조인해서 이미지 들고와야할듯 -->
                                        <a href="#">
                                            <img src="./img/80x80.png" alt="상품이미지">
                                        </a>
                                        <div>
                                            <h2>
                                                <a href="#">${cart.prodName}</a>
                                            </h2>
                                            <p>${cart.descript}</p>
                                        </div>
                                    </article>
                                </td>
                                <td>${cart.count}</td>
                                <td><fmt:formatNumber value="${cart.price}" pattern="#,###,###" /></td>
                                <td>${cart.discount}%</td>
                                <td><fmt:formatNumber value="${cart.point}" pattern="#,###,###" /></td>
                                <td><fmt:formatNumber value="${cart.delivery}" pattern="#,###,###" /></td>
                                <td><fmt:formatNumber value="${cart.total}" pattern="#,###,###" /></td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div class="final">
                            <table border="0">
                                <h2>최종결제 정보</h2>
                                <c:set var="sum" value="0"/>
                                <tr>
                                    <td>상품수</td>
                                    <td class="finalCount">
                                		<c:set var="finalCount" value="0"/>
                                    	<c:forEach var="cart" items="${carts}">
			                        		<c:set var="finalCount" value="${finalCount+cart.count}"/>
			                        	</c:forEach>
			                        	<c:out  value="${finalCount}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품금액</td>
                                    <td class="finalPrice">
                                    	<c:set var="finalPrice" value="0"/>
                                    	<c:forEach var="cart" items="${carts}">
			                        	<c:set var="finalPrice" value="${finalPrice+cart.price*cart.count}"/>
			                        	</c:forEach>
                                    	<fmt:formatNumber value="${finalPrice}" pattern="#,###,###" />
                                    	<input type="hidden" name="finalPrice" value="${finalPrice}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>할인금액</td>
                                    <td class="finalDiscount">
                                    	<c:set var="finalDiscount" value="0"/>
                                    	<c:forEach var="cart" items="${carts}">
			                        	<c:set var="finalDiscount" value="${finalDiscount + cart.discount/100 * cart.price * cart.count}"/>
			                        	</c:forEach>
                                    	<fmt:formatNumber value="${finalDiscount}" pattern="#,###,###" />
                                    	<input type="hidden" name="finalDiscount" value="${finalDiscount}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td class="finalDelivery">
                                    	<c:set var="finalDelivery" value="0"/>
                                    	<c:forEach var="cart" items="${carts}">
			                        	<c:set var="finalDelivery" value="${finalDelivery+cart.delivery}"/>
			                        	</c:forEach>
                                    	<fmt:formatNumber value="${finalDelivery}" pattern="#,###,###" />
                                    	<input type="hidden" name="finalDelivery" value="${finalDelivery}"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>포인트 할인</td>
                                    <td class="usedPoint">0</td>
                                </tr>
                                <tr>
                               		<td>적립 포인트</td>
	                               	<td class="savePoint">
                                    	<c:set var="savePoint" value="0"/>
		                        		<c:forEach var="cart" items="${carts}">
			                        	<c:set var="savePoint" value="${savePoint+cart.point * cart.count}"/>
			                        	</c:forEach>
                                    	<fmt:formatNumber value="${savePoint}" pattern="#,###,###" />
                                    	<input type="hidden" name="savePoint" value="${savePoint}"/>
	                               	</td>
                                </tr>
                                <tr>
                                    <td>전체 주문 금액</td>
                                    <td class="finalTotalPrice">
                                    	<c:forEach var="cart" items="${carts}">
			                        		<c:set var="finalTotalPrice" value="${finalTotalPrice + cart.total + cart.delivery}"/>
			                        	</c:forEach>
                                    	<span><fmt:formatNumber value="${finalTotalPrice}" pattern="#,###,###" /></span>
                                    	<input type="hidden" name="finalTotalPrice" value="${finalTotalPrice}"/>
                                    </td>
                                </tr>
                               
                            </table>
                            <input type="button" name="complete" class="complete" value="결제하기">
                            <input type="hidden" name="uid" value="${sessMember.uid}">
                        </div>
                        <article class="delivery">
                            <h1>배송정보</h1>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>주문자</td>
                                        <td><input type="text" name="orderer" value="${sessMember.name}"></td>
                                    </tr>
                                    <tr>
                                        <td>휴대폰</td>
                                        <td>
                                            <input type="text" name="hp" value="${sessMember.hp}">
                                            <span> - 포함 입력</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>우편번호</td>
                                        <td>
                                            <input type="text" name="zip" id="zip" value="${sessMember.zip}">
                                            <input type="button" name="postcode" value="검색">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>기본주소</td>
                                        <td><input type="text" name="addr1" id="addr1" value="${sessMember.addr1}"></td>
                                    </tr>
                                    <tr>
                                        <td>상세주소</td>
                                        <td><input type="text" name="addr2" id="addr2" value="${sessMember.addr2}"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </article>
                        <article class="discount">
                            <h1>할인정보</h1>
                            <div>
                                <p>현재 포인트 : <span class="myPoint">${sessMember.point}</span>점</p>
                                <label>
                                    <input type="text" name="usePoint">점 
                                    <input type="button" class="btn usePoint" value="적용">
                                </label>
                                <span>
                                    포인트 5,000점 이상이면 현금처럼 사용 가능합니다.
                                </span>
                            </div>
                        </article>
                        <article class="payment">
                            <h1>결제방법</h1>
                            <div>
                                <span>신용카드</span>
                                <p>
                                    <label><input type="radio" name="payment" value="1">신용카드 결제</label>
                                    <label><input type="radio" name="payment" value="2">체크카드 결제</label>
                                </p>
                            </div>
                            <div>
                                <span>계좌이체</span>
                                <p>
                                    <label><input type="radio" name="payment" value="3">실시간 계좌이체</label>
                                    <label><input type="radio" name="payment" value="4">무통장 입금</label>
                                </p>
                            </div>
                            <div>
                                <span>기타</span>
                                <p>
                                    <label><input type="radio" name="payment" value="type5">휴대폰결제</label>
                                    <label>
                                        <input type="radio" name="payment" value="type6">카카오페이
                                        <img src="./img/ico_kakaopay.gif" alt="카카오페이">
                                    </label>
                                </p>
                            </div>
                        </article>
                        <article class="alert">
                            <ul>
                                <li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</span></li>
                                <li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</span></li>
                                <li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
                            </ul>
                        </article>
                </form>
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
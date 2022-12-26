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
	    	
	    	// 전체 선택
	    	$("input[name=all]").click(function(){
	    		if ($(this).is(":checked")){
	    			$('input[name=chkProduct]').each(function() {

	    			      this.checked = true; //checked 처리

	    			      if(this.checked){//checked 처리된 항목의 값

	    			            console.log(this.value); 
								setTotalInfo();
	    			      }


	    			 });
	    			
	    		}else{
	    			$('input[name=chkProduct]').each(function() {

	  			      this.checked = false; //checked 해제 처리
						setTotalInfo();


	  			 });
	    		}
	    	});
	    	
	    	/************************************/
	    	function setTotalInfo(){
	    		
	    	
		    	let totalPrice = 0; // 상품금액 합
		    	let totalCount = 0; // 상품수 합
		    	let totalDiscount = 0; // 상품 할인 금액 합(이거는 계산해서 들어가야할듯)
		    	let totalDelivery = 0; // 배송비 합
		    	let usePoint = 0;
		    	let finalTotalPrice = 0;
		    	
		    	$(".cart_info_td").each(function(index, element){
		    		
		    	
		    		if($(element).find("input[name=chkProduct]").is(":checked") === true){ //체크여부
		    		
		    		totalPrice += parseInt($(element).find(".price").val())*parseInt($(element).find(".count").val());
		    		totalCount += parseInt($(element).find(".count").val());
		    		totalDiscount += parseInt($(element).find(".discount").val());
		    		totalDelivery += parseInt($(element).find(".delivery").val());
		    		usePoint += parseInt($(element).find(".usePoint").val());
		    		
		    		}
		    	});
		    	/* 최종 가격 */
		    	finalTotalPrice = totalPrice - totalDiscount + totalDelivery;
		    	/* 값 삽입 */
		    	$('.totalPrice').text(totalPrice);			
		    	$('.totalCount').text(totalCount);
				$('.totalDiscount').text(' - '+totalDiscount);			
				$('.totalDelivery').text(totalDelivery);			
				$('.finalTotalPrice').text(finalTotalPrice+'원');
				$('.pointDiscount').text('-'+usePoint)
	    	}
	    	$("input[name=chkProduct]").on("change", function(){
	    		setTotalInfo($(".cart_info_td"));
	    	});
	    	$("input[name=postcode]").click(function(){
	    		postcode();
	    	});
	  });
    </script>
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
                </ul><!-- 베스트상품 배너 -->
                    <article class="best">
                      <h1><i class="fas fa-crown"></i>베스트상품</h1>
                      <ol>
                      <li>
                          <a href="#">
                          <div class="thumb">
                              <i>1</i><img src="./img/sample_thumb.jpg" alt="item1" />
                          </div>
                          <h2>상품명</h2>
                          <div class="org_price">
                              <del>30,000</del><span>10%</span>
                          </div>
                          <div class="dis_price">
                              <ins>27,000</ins>
                          </div>
                          </a>
                      </li>
                      <li>
                          <a href="#">
                          <div class="thumb">
                              <i>2</i><img src="./img/sample_thumb.jpg" alt="item1" />
                          </div>
                          <article>
                              <h2>상품명</h2>
                              <div class="org_price">
                              <del>30,000</del>
                              <span>10%</span>
                              </div>
                              <div class="dis_price">
                              <ins>27,000</ins>
                              </div>
                          </article>
                          </a>
                      </li>
                      <li>
                          <a href="#">
                          <div class="thumb">
                              <i>3</i><img src="./img/sample_thumb.jpg" alt="item1" />
                          </div>
                          <article>
                              <h2>상품명</h2>
                              <div class="org_price">
                              <del>30,000</del>
                              <span>10%</span>
                              </div>
                              <div class="dis_price">
                              <ins>27,000</ins>
                              </div>
                          </article>
                          </a>
                      </li>
                      <li>
                          <a href="#">
                          <div class="thumb">
                              <i>4</i><img src="./img/sample_thumb.jpg" alt="item1" />
                          </div>
                          <article>
                              <h2>상품명</h2>
                              <div class="org_price">
                              <del>30,000</del>
                              <span>10%</span>
                              </div>
                              <div class="dis_price">
                              <ins>27,000</ins>
                              </div>
                          </article>
                          </a>
                      </li>
                      <li>
                          <a href="#">
                          <div class="thumb">
                              <i>5</i><img src="./img/sample_thumb.jpg" alt="item1" />
                          </div>
                          <article>
                              <h2>상품명</h2>
                              <div class="org_price">
                              <del>30,000</del>
                              <span>10%</span>
                              </div>
                              <div class="dis_price">
                              <ins>27,000</ins>
                              </div>
                          </article>
                          </a>
                      </li>
                      </ol>
                  </article>
              </aside>
            <section class="order">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>주문결제</h1>
                    <p>HOME > 장바구니 > 주문결제</p>
                </nav>
                <!-- 주문 결제 창 -->
                <form action="#">
                    <table border="0">
                        <thead>
                            <tr>
                                <th><input type="checkbox" name="all"></th>
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
                                	<input type="checkbox" name="chkProduct" value="${cart.cartNo}">
                                	<input type="hidden" class="prodNo" name="prodNo" value="${cart.prodNo}">
                                	<input type="hidden" class="count" value="${cart.count}">
                                	<input type="hidden" class="price" value="${cart.price}">
                                	<input type="hidden" class="discount" value="${cart.price * cart.count * (cart.discount/100)}">
                                	<input type="hidden" class="point" value="${cart.point}">
                                	<input type="hidden" class="delivery" value="${cart.delivery}">
                                	<input type="hidden" class="total" value="${cart.total - cart.price * cart.count * (cart.discount/100)}">
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
                                <tr>
                                    <td>총</td>
                                    <td class="totalCount">0</td>
                                </tr>
                                <tr>
                                    <td>상품금액</td>
                                    <td class="totalPrice">0</td>
                                </tr>
                                <tr>
                                    <td>할인금액</td>
                                    <td class="totalDiscount">0</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td class="totalDelivery">0</td>
                                </tr>
                                <tr>
                                    <td>포인트 할인</td>
                                    <td class="usePoint">0</td>
                                </tr>
                                <tr>
                                    <td>전체주문금액</td>
                                    <td class="finalTotalPrice">0</td>
                                </tr>
                            </table>
                            <input type="submit" name="" value="결제하기">
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
                                <p>현재 포인트 : <span>${sessMember.point}</span>점</p>
                                <label>
                                    <input type="text" name="point">점 
                                    <input type="button" class="usePoint" value="적용">
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
                                    <label><input type="radio" name="payment" value="type1">신용카드 결제</label>
                                    <label><input type="radio" name="payment" value="type2">체크카드 결제</label>
                                </p>
                            </div>
                            <div>
                                <span>계좌이체</span>
                                <p>
                                    <label><input type="radio" name="payment" value="type3">실시간 계좌이체</label>
                                    <label><input type="radio" name="payment" value="type4">무통장 입금</label>
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
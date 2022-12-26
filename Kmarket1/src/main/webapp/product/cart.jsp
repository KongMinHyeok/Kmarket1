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
	    	let totalPoint = 0; // 포인트 합
	    	let finalTotalPrice = 0;
	    	
	    	$(".cart_info_td").each(function(index, element){
	    		
	    	
	    		if($(element).find("input[name=chkProduct]").is(":checked") === true){ //체크여부
	    		
	    		totalPrice += parseInt($(element).find(".price").val())*parseInt($(element).find(".count").val());
	    		totalCount += parseInt($(element).find(".count").val());
	    		totalDiscount += parseInt($(element).find(".discount").val());
	    		totalDelivery += parseInt($(element).find(".delivery").val());
	    		totalPoint += parseInt($(element).find(".point").val());
	    		
	    		}
	    	});
	    	/* 최종 가격 */
	    	finalTotalPrice = totalPrice - totalDiscount + totalDelivery;
	    	/* 값 삽입 */
	    	$('.totalPrice').text(totalPrice);			
	    	$('.totalCount').text(totalCount);
			$('.totalDiscount').text(' - '+totalDiscount);			
			$('.totalDelivery').text(totalDelivery);			
			$('.totalPoint').text(totalPoint);			
			$('.finalTotalPrice').text(finalTotalPrice+'원');
    	}
    	$("input[name=chkProduct]").on("change", function(){
    		setTotalInfo($(".cart_info_td"));
    	});
    	// 주문하기--------------------------------------------------------------------
    	// km_product_order 테이블은 생각해보니까 주문페이지에서 주문을 해야 만들어지는거 같음
/*
    	$('input[name=order]').click(function(e){
			e.preventDefault();
    		let chk2 = [];
    		let chkArr2 = $("input[name=chkProduct]:checked").length;
    		let checkOrder = confirm('선택한 상품을 주문하시겠습니까?');
    		
    		$('input[name=chkProduct]:checked').each(function(){
    			  chk2.push($(this).val());
    		});
    		console.log(chk2);
    		
    		 if(chkArr2 == 0) {
    			 //리스트에 상품이 없으면
    			 alert('선택한 상품이 존재하지 않습니다');
    		 }else{
    			 if(checkOrder){
    				 $.ajax({
 						url : '/Kmarket1/product/Cart.do',
 						type : 'POST',
 						traditional: true,
 						data : {'chk2': chk2},
 						dataType : 'json',
 						success : function(data){
 							if(data.result > 0){
 								alert('오더 ㄱㄱ');
 							}else{
 								return;
 							}
 						}
 						});
    				 location.href = "/Kmarket1/product/order.do?uid="+uid;
    			 }else{
    				 return;
    			 }
    		 }
    	});
*/
		$('input[name=order]').click(function(e){
			e.preventDefault();
			
			let arr = [];
			
			let checked = $('input[name=chkProduct]:checked').length;
			
			$('input[name=chkProduct]:checked').each(function(){
				arr.push($(this).val());
				});
			
			let jsonData = {"arr" : arr};
			
			if(checked == 0){
				alert('상품은 1개 이상 선택해주세요.');
				
			}else{
				let arrs = arr.toString();
				console.log(arrs);
				$.ajax({
					url : '/Kmarket1/product/cart.do',
					type : 'POST',
					data : jsonData,
					traditional : true,
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							location.href='/Kmarket1/product/order.do?uid=${uid}&cartNo='+arr;
						}
					}
				});
			}
		});
    	// 값 계산----------------------------------------------------------------------
    	
    	
    	$('input[name=chkProduct]').click(function() {
    		// alert('!');
    		// 이거 지금 문자배열이라 계산이 안되니깐 숫자배열로 바꾸는거 찾아서 해라
    		let totalList = [];
    		let checkArr = $("input[name=chkProduct]:checked").length;
    		let checkbox  = $("input[name=chkProduct]:checked");
    		checkbox.each(function(i){
    			let tr = checkbox.parent().parent().eq(i);
    			let td = tr.children();
    			
    			let total = td.eq(7).text();
    			
    			totalList.push(total);
    			
    		});
    		console.log(totalList);
    		let sum = 0;
    			for(let i=0; i < checkArr; i++ ){
    			       if( "input[name=chkProduct]:checked" == true ){
    				    sum += parseInt(total);
    			       }
    			   }
    			   console.log(sum);
    		
    	});
    	
    	// 선택 항목 삭제------------------------------------------------------------------
    	$('.del').click(function(){
    		let chk = [];
    		let checkArr = $("input[name=chkProduct]:checked").length;
    		 $('input[name=chkProduct]:checked').each(function(){
    		      chk.push($(this).val());
    		    });
    		 console.log(chk);
    		 if(checkArr == 0) {
    				
    				//리스트에 값이 존재하지 않음
    				alert("선택한 상품이 존재하지 않습니다");
    			}else if(
    				confirm("선택한 상품을 삭제하시겠습니까?")){
    				$('input[name=chkProduct]:checked').parents('tr').remove();
    					$.ajax({
    						url : '/Kmarket1/product/deleteCart.do',
    						type : 'POST',
    						traditional: true,
    						data : {'chk': chk},
    						dataType : 'json',
    						success : function(data){
    							if(data.result > 0){
    								alert('삭제가 완료되었습니다');
    								location.reload();
    							}else{
    								return;
    							}
    						}
    					});
    				}
    			
    		 
    	});
    	
    	
        // 끝
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
            <section class="cart">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>장바구니</h1>
                    <p>HOME > 장바구니</p>
                </nav>
                <!-- 장바구니 목록 -->
                <form action="/Kmarket1/product/cart.do" class="submitCart" method="post">
                    <table border="0">
                        <thead>
                            <tr>
                                <th><input type="checkbox" name="all"></th>
                                <th>상품명</th>
                                <th>총수량</th>
                                <th>판매가</th>
                                <th>할인</th>
                                <th>포인트</th>
                                <th>배송비</th>
                                <th>소계</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- 장바구니에 상품이 없을 경우 출력 -->
                            <tr class="empty">
                                <td colspan="7">장바구니에 상품이 없습니다.</td>
                            </tr>
                            <c:forEach var="cart" items="${carts}">
                            <tr>
                                <td class="cart_info_td">
                                	<input type="checkbox" name="chkProduct" value="${cart.cartNo}">
                                	<input type="hidden" class="prodNo" value="${cart.prodNo}">
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
                                <td><fmt:formatNumber value="${cart.total+cart.delivery}" pattern="#,###,###" /></td>
                            </tr>
                            </c:forEach>
                            <tr><td><input type="hidden" name="uid" value= ${sessMember.uid }></td></tr>
                        </tbody>
                    </table>
                    <input type="button" value="선택삭제" name="del" class="del">
                    <div class="total">
                        <table border="0">
                            <h2>전체합계</h2>
                            <tr>
                                <td>상품수</td>
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
                                <td>포인트</td>
                                <td class="totalPoint">0</td>
                            </tr>
                            <tr>
                                <td>전체주문금액</td>
                                <td class="finalTotalPrice">0</td>
                            </tr>
                        </table>
                        <input type="submit" name="order" value="주문하기">
                    </div>
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
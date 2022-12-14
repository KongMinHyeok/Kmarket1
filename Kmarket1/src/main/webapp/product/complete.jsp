<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/product/_header.jsp"/>
<!-- 베스트 상품 배너 추가해주세요 -->
        <main id="product">
            <aside>
                <ul class="category">
                    <!-- 아이콘들 Font Awesome에서 들고온거라 복붙했음 -->     
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#"><i class="fas fa-tshirt"></i>패션·의류·뷰티</a>
                        <ol>
                            <li><a href="#">남성의류</a></li>
                            <li><a href="#">여성의류</a></li>
                            <li><a href="#">잡화</a></li>
                            <li><a href="#">뷰티</a></li>
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
            <section class="complete">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>주문완료</h1>
                    <p>HOME > 장바구니 > 주문결제 > 주문완료</p>
                </nav>
                <!-- 주문 완료 창 -->
                <article class="message">
                    <h2>고객님의 주문이 정상적으로 완료되었습니다.<i class="far fa-smile" aria-hidden="true"></i></h2>
                    <p>즐거운 쇼핑이 되셨습니까? 항상 고객님을 최우선으로 생각하는 케이마켓이 되겠습니다.</p>
                </article>
                <article class="info">
				<h1>상품정보</h1>
                    <table border="0">
                      <tr>
                        <th>상품명</th>
                        <th>상품금액</th>
                        <th>할인율</th>
                        <th>수량</th>
                        <th>주문금액</th>
                      </tr>
                      <c:forEach items="${items}" var="item">
                      <tr>
                        <td>
                          <article>
                            <img src="${item.thumb1}" alt=""> <!-- server.xml > host > context에 이미지 로드 설정해놓음 -->
                            												   <!-- 예시: <Context docBase="C:\Users\java1\Desktop\kmarket_images" path="/Kmarket1_images/"></Context> -->
                            <div>
                              <h2><a href="/Kmarket1/product/view.do?prodCate1=${item.prodCate1}&prodCate2=${item.prodCate2}&prodNo=${item.prodNo}&pg=1">${item.prodName}</a></h2>
                              <p>${item.descript}</p>
                            </div>
                          </article>
                        </td>
                        <td>${item.price}원</td>
                        <td>${item.discount}%</td>
                        <td>${item.count}</td>
                        <td>${item.total}원</td>
                      </tr>
                      </c:forEach>
                      
                      <tr class="total">
                        <td colspan="4"></td>
                        <td>
                          <table border="0">
                            <tr>
                              <td>총 상품금액</td>
                              <td><span>${order.ordPrice}</span>원</td>
                            </tr>
                            <tr>		
                              <td>총 할인금액</td>
                              <c:choose>
                              	<c:when test="${order.ordDiscount eq 0 }">
                              		<td><span>${order.ordDiscount}</span>원</td>
                              	</c:when>
                              	<c:otherwise>
                              		<td><span>-${order.ordDiscount}</span>원</td>
                              	</c:otherwise>
                              </c:choose>
                            </tr>
                            <tr>
                              <td>배송비</td>
                              <td><span>${order.ordDelivery}</span>원</td>
                            </tr>
                            <tr>
                              <td>총 결제금액</td>
                              <td><span>${order.ordTotPrice}</span>원</td>
                            </tr>
                          </table>                      
                        </td>
                      </tr>
                    </table>
                  </article>
            <article class="order">
                <h1>주문정보</h1>          
                <table border="0">
                  <tr>
                    <td>주문번호</td>
                    <td>${order.ordNo}</td>
                    <td rowspan="3">총 결제금액</td>
                    <td rowspan="3"><span>${order.ordTotPrice}</span>원</td>
                  </tr>
                  <tr>
                    <td>결제방법</td>
                    <c:choose>
                    	<c:when test="${order.ordPayment eq 1}">
                    	<td>신용카드</td>
                    	</c:when>
                    	<c:when test="${order.ordPayment eq 2}">
                    	<td>체크카드</td>
                    	</c:when>
                    	<c:when test="${order.ordPayment eq 3}">
                    	<td>실시간 계좌이체</td>
                    	</c:when>
                    	<c:when test="${order.ordPayment eq 4}">
                    	<td>무통장입금</td>
                    	</c:when>
                    	<c:when test="${order.ordPayment eq 5}">
                    	<td>휴대폰결제</td>
                    	</c:when>
                    	<c:when test="${order.ordPayment eq 6}">
                    	<td>카카오페이</td>
                    	</c:when>
                    </c:choose>
                  </tr>
                  <tr>
                    <td>주문자/연락처</td>
                    <td>${order.name}/${order.hp}</td>
                  </tr>
                </table>
              </article>
            
              <!-- 배송정보 -->
              <article class="delivery">
                <h1>배송정보</h1>
                <table border="0">
                  <tr>
                    <td>수취인</td>
                    <td>${order.recipName}</td>                    
                    <td>주문자 정보</td>
                  </tr>
                  <tr>
                    <td>연락처</td>
                    <td>${order.recipHp}</td>
                    <td rowspan="2">
                      ${order.name}<br/>
                      ${order.hp}
                    </td>
                  </tr>
                  <tr>
                    <td>배송지 주소</td>
                    <td>${order.recipAddr1} &nbsp; ${order.recipAddr2}</td>
                  </tr>
                </table>
              </article>
            
              <!-- 꼭 알아두세요. -->
              <article class="alert">
                <h1>꼭 알아두세요.</h1>
                <ul>
                  <li><span>케이마켓은 통신판매중개자이며 통신판매의 당사자가 아닙니다. 따라서 케이마켓은 상품, 거래정보 및 거래에 대하여 책임을 지지 않습니다.</span></li>
                  <li><span>구매주문내역, 배송상태 확인, 구매영수증 출력, 구매취소/반품/교환은 사이트 상단의 주문/배송조회에서 확인 할 수 있습니다.</span></li>
                  <li><span>고객님의 주문이 체결된 후 상품품절 및 단종 등에 의해 배송이 불가능할 경우, 전자상거래등에서의 소비자 보호에 관한 법률 제15조 2항에 의거하여 3영업일(공휴일 제외) 이내에 자동으로 취소될 수 있으며, 이 경우 취소 안내 메일이 고객님께 발송되오니 양지 바랍니다.</span></li>
                  <li><span>극히 일부 상품에 대해 수량부족, 카드결제승인 오류등의 사례가 간혹 있을 수 있으니 `나의쇼핑정보`에서 다시 한번 확인해 주세요.</span></li>
                  <li><span>현금잔고로 구매하셨을 경우, 나의 쇼핑정보에서 입금확인이 되었는지를 다시 한번 확인해 주세요.</span></li>
                  <li><span>배송주소를 추가하거나 변경, 삭제 등의 관리는 `나의쇼핑정보 > 나의정보` 에서 가능합니다.</span></li>
                </ul>
              </article>
            </section>
            <!-- 결제완료 페이지 끝 -->
        </main>
<jsp:include page="/product/_footer.jsp"/>
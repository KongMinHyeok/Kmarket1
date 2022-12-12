<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <div>
		            <a href="/Kmarket1/member/login.jsp">로그인</a>
		            <a href="/Kmarket1/member/join.jsp">회원가입</a>
		            <a href="/Kmarket1/member/login.jsp">마이페이지</a>
		            <a href="/Kmarket1/product/cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                </div>
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
                </ul>
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
                        <th>할인금액</th>
                        <th>수량</th>
                        <th>주문금액</th>
                      </tr>
                      <tr>
                        <td>
                          <article>
                            <img src="https://via.placeholder.com/80x80" alt="">
                            <div>
                              <h2><a href="#">상품명</a></h2>
                              <p>상품설명</p>
                            </div>
                          </article>
                        </td>
                        <td>17,000원</td>
                        <td>1,000원</td>
                        <td>1</td>
                        <td>16,000원</td>
                      </tr>
                      <tr>
                        <td>
                          <article>
                            <img src="https://via.placeholder.com/80x80" alt="">
                            <div>
                              <h2><a href="#">상품명</a></h2>
                              <p>상품설명</p>
                            </div>
                          </article>
                        </td>
                        <td>17,000원</td>
                        <td>1,000원</td>
                        <td>1</td>
                        <td>16,000원</td>
                      </tr>
                      <tr>
                        <td>
                          <article>
                            <img src="https://via.placeholder.com/80x80" alt="">
                            <div>
                              <h2><a href="#">상품명</a></h2>
                              <p>상품설명</p>
                            </div>
                          </article>
                        </td>
                        <td>17,000원</td>
                        <td>1,000원</td>
                        <td>1</td>
                        <td>16,000원</td>
                      </tr>
                      
                      <tr class="total">
                        <td colspan="4"></td>
                        <td>
                          <table border="0">
                            <tr>
                              <td>총 상품금액</td>
                              <td><span>34,000</span>원</td>
                            </tr>
                            <tr>
                              <td>총 할인금액</td>
                              <td><span>-2,000</span>원</td>
                            </tr>
                            <tr>
                              <td>배송비</td>
                              <td><span>3,000</span>원</td>
                            </tr>
                            <tr>
                              <td>총 결제금액</td>
                              <td><span>35,000</span>원</td>
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
                    <td>2008101324568</td>
                    <td rowspan="3">총 결제금액</td>
                    <td rowspan="3"><span>35,000</span>원</td>
                  </tr>
                  <tr>
                    <td>결제방법</td>
                    <td>신용카드</td>
                  </tr>
                  <tr>
                    <td>주문자/연락처</td>
                    <td>홍길동/010-1234-1234</td>
                  </tr>
                </table>
              </article>
            
              <!-- 배송정보 -->
              <article class="delivery">
                <h1>배송정보</h1>
                <table border="0">
                  <tr>
                    <td>수취인</td>
                    <td>홍길동</td>                    
                    <td>주문자 정보</td>
                  </tr>
                  <tr>
                    <td>연락처</td>
                    <td>010-1234-1234</td>
                    <td rowspan="2">
                      홍길동<br/>
                      010-1234-1234
                    </td>
                  </tr>
                  <tr>
                    <td>배송지 주소</td>
                    <td>부산광역시 강남구 대연동 123 10층</td>
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
        <footer>
            <ul>
                <li><a href="#">회사소개</a></li>
                <li><a href="#">서비스이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">전자금융거래약관</a></li>
            </ul>
            <div>
                <p><img src="../img/footer_logo.png" alt="로고"></p>
                <p>
                  <strong>(주)KMARKET</strong><br />
                  부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
                  대표이사 : 홍길동<br />
                  사업자등록번호 : 220-81-83676 사업자정보확인<br />
                  통신판매업신고 : 강남 10630호 Fax : 02-589-8842
                </p>
                <p>
                  <strong>고객센터</strong><br />
                  Tel : 1234-5678 (평일 09:00~18:00)<br />
                  스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
                  경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
                  Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
                </p>
              </div>              
        </footer>
        <button type="button" id="top">상단이동</button>
    </div>    
</body>
</html>
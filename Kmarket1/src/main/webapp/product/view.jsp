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
            <section class="view">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품보기</h1>
                    <p>HOME > 패션·의류·뷰티 > 남성의류</p>
                </nav>

                <!-- 상품 전체 내용 -->
                <article class="info">
                    <div class="image">
                        <img src="./img/460x460.png" alt="예시 이미지">
                    </div>
                    <div class="summary">
                        <nav>
                            <h1>(주)판매자명</h1>
                            <h2>상품번호 : 10010118412</h2>
                        </nav>
                        <nav>
                            <h3>상품명</h3>
                            <p>상품설명 출력</p>
                            <h5 class="rating star4">
                                <a href="#">상품평보기</a>
                            </h5>
                        </nav>
                        <nav>
                            <div class="original-price">
                                <del>30,000</del>
                                <span>10%</span>
                            </div>
                            <div class="discount-price">
                                <ins>27,000</ins>
                            </div>
                        </nav>
                        <nav>
                            <span class="delivery">무료배송</span>
                            <span class="arrival">모레(금) 7/8 도착예정</span>
                            <span class="desc">본 상품은 국내배송만 가능합니다.</span>
                        </nav>
                        <nav>
                            <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                            <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                        </nav>
                        <nav class="origin">
                            원산지-상세설명 참조
                        </nav>
                        <img src="./img/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립" class="banner">
                        <div class="count">
                            <button class="decrease"></button>
                            <input type="text" name="num" value="1" readonly>
                            <button class="increase"></button>
                        </div>
                        <div class="total">
                            <span>35,000</span>
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
                                <td>10110125435</td>
                            </tr>
                            <tr>
                                <td>상품상태</td>
                                <td>새상품</td>
                            </tr>
                            <tr>
                                <td>부가세 면세여부</td>
                                <td>과세상품</td>
                            </tr>
                            <tr>
                                <td>영수증발행</td>
                                <td>발행가능 - 신용카드 전표, 온라인 현금영수증</td>
                            </tr>
                            <tr>
                                <td>사업자구분</td>
                                <td>사업자 판매자</td>
                            </tr>
                            <tr>
                                <td>브랜드</td>
                                <td>블루포스</td>
                            </tr>
                            <tr>
                                <td>원산지</td>
                                <td>국내생산</td>
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
                                <td>A/S 책임자오 전화번호</td>
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
                        <li>
                            <div>
                                <h5 class="rating star1">상품평</h5>
                                <span>seo******	2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star2">상품평</h5>
                                <span>seo******	2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star3">상품평</h5>
                                <span>seo******	2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star4">상품평</h5>
                                <span>seo******	2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                        <li>
                            <div>
                                <h5 class="rating star5">상품평</h5>
                                <span>seo******	2018-07-10</span>
                            </div>
                            <h3>상품명1/BLUE/L</h3>
                            <p>
                                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요.
                                아주 약간 루즈한정도...?그래도 이만한 옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는
                                제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
                            </p>
                        </li>
                    </ul>    
                <!-- 상품목록 페이지번호 -->
              <div class="paging">
                <span class="prev">
                  <a href="#"><&nbsp;이전</a>
                </span>
                <span class="num">
                  <a href="#" class="on">1</a>
                  <a href="#">2</a>
                  <a href="#">3</a>
                  <a href="#">4</a>
                  <a href="#">5</a>
                  <a href="#">6</a>
                  <a href="#">7</a>
                </span>
                <span class="next">
                  <a href="#">다음&nbsp;></a>
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
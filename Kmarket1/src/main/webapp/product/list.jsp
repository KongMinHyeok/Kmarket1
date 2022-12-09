<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="./_header.jsp"/>

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
                <!-- 베스트상품 배너 -->
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
            <section class="list">
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품목록</h1>
                    <p>HOME > 패션·의류·뷰티 > 남성의류</p>
                </nav>
                <!-- 정렬 메뉴 -->
                <ul class="sort">
                    <li><a href="#" class="on">판매많은순</a></li>
                    <li><a href="#">낮은가격순</a></li>
                    <li><a href="#">높은가격순</a></li>
                    <li><a href="#">평점높은순</a></li>
                    <li><a href="#">후기많은순</a></li>
                    <li><a href="#">최근등록순</a></li>
                </ul>
                <!-- 상품 목록 -->
                <table border="0">
                    <tbody>
                        <tr>
                            <!-- img는 예시 사이트에서 받아왔음 -->
                            <td><a href="#" class="goods"><img src="./img/120x120.png" alt="상품이미지"></a></td>
                            <td>
                                <h3 class="name">상품명</h3>
                                <a href="#" class="desc">상품설명</a>
                            </td>
                            <td>
                                <ul>
                                    <li><ins class="discount-price">27,000</ins></li>
                                    <li>
                                        <!-- del태그는 텍스트 한가운데 라인을 추가하여 문서에서 삭제된 텍스트 표현-->
                                        <del class="original-price">30,000</del>
                                        <span class="discount">10%</span>
                                    </li>
                                    <li><span class="free-delivery">무료배송</span></li>
                                </ul>
                            </td>
                            <td>
                                <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                                <h5 class="badge power">판매자등급</h5>
                                <h6 class="rating star1">상품평</h6>
                              </td>
                        </tr>
                        <tr>
                            <td><a href="#" class="goods"><img src="./img/120x120.png" alt="상품이미지"></a></td>
                            <td>
                                <h3 class="name">상품명</h3>
                                <a href="#" class="desc">상품설명</a>
                            </td>
                            <td>
                                <ul>
                                    <li><ins class="discount-price">27,000</ins></li>
                                    <li>
                                        <!-- del태그는 텍스트 한가운데 라인을 추가하여 문서에서 삭제된 텍스트 표현-->
                                        <del class="original-price">30,000</del>
                                        <span class="discount">10%</span>
                                    </li>
                                    <li><span class="free-delivery">무료배송</span></li>
                                </ul>
                            </td>
                            <td>
                                <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                                <h5 class="badge power">판매자등급</h5>
                                <h6 class="rating star2">상품평</h6>
                              </td>
                        </tr>
                        <tr>
                            <td><a href="#" class="goods"><img src="./img/120x120.png" alt="상품이미지"></a></td>
                            <td>
                                <h3 class="name">상품명</h3>
                                <a href="#" class="desc">상품설명</a>
                            </td>
                            <td>
                                <ul>
                                    <li><ins class="discount-price">27,000</ins></li>
                                    <li>
                                        <!-- del태그는 텍스트 한가운데 라인을 추가하여 문서에서 삭제된 텍스트 표현-->
                                        <del class="original-price">30,000</del>
                                        <span class="discount">10%</span>
                                    </li>
                                    <li><span class="free-delivery">무료배송</span></li>
                                </ul>
                            </td>
                            <td>
                                <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                                <h5 class="badge power">판매자등급</h5>
                                <h6 class="rating star3">상품평</h6>
                              </td>
                        </tr>
                        <tr>
                            <td><a href="#" class="goods"><img src="./img/120x120.png" alt="상품이미지"></a></td>
                            <td>
                                <h3 class="name">상품명</h3>
                                <a href="#" class="desc">상품설명</a>
                            </td>
                            <td>
                                <ul>
                                    <li><ins class="discount-price">27,000</ins></li>
                                    <li>
                                        <!-- del태그는 텍스트 한가운데 라인을 추가하여 문서에서 삭제된 텍스트 표현-->
                                        <del class="original-price">30,000</del>
                                        <span class="discount">10%</span>
                                    </li>
                                    <li><span class="free-delivery">무료배송</span></li>
                                </ul>
                            </td>
                            <td>
                                <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                                <h5 class="badge power">판매자등급</h5>
                                <h6 class="rating star4">상품평</h6>
                              </td>
                        </tr>
                        <tr>
                            <td><a href="#" class="goods"><img src="./img/120x120.png" alt="상품이미지"></a></td>
                            <td>
                                <h3 class="name">상품명</h3>
                                <a href="#" class="desc">상품설명</a>
                            </td>
                            <td>
                                <ul>
                                    <li><ins class="discount-price">27,000</ins></li>
                                    <li>
                                        <!-- del태그는 텍스트 한가운데 라인을 추가하여 문서에서 삭제된 텍스트 표현-->
                                        <del class="original-price">30,000</del>
                                        <span class="discount">10%</span>
                                    </li>
                                    <li><span>배송비 2500</span></li>
                                </ul>
                            </td>
                            <td>
                                <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                                <h5 class="badge power">판매자등급</h5>
                                <h6 class="rating star5">상품평</h6>
                              </td>
                        </tr>
                    </tbody>
                </table>
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
            </section>
        </main>
        <jsp:include page="./_footer.jsp"/>

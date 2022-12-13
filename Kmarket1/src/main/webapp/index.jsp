<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
      <main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
            <c:forEach var="cate" items="${cates}" >
            <li>
              <a href="#">
              	<c:choose>
              	<c:when test="${cate.cate1 == 10 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
				<c:when test="${cate.cate1 == 11 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 12 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 13 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 14 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 15 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 16 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 17 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
                <c:when test="${cate.cate1 == 18 }">
                <i class="fas fa-tshirt"></i>${cate.c1Name}<i class="fas fa-angle-right"></i>
                </c:when>
				</c:choose>
              </a>
               <ol>
                <li><a href="#">노트북/PC</a></li>
                <li><a href="#">가전</a></li>
                <li><a href="#">휴대폰</a></li>
                <li><a href="#">기타</a></li>
              </ol>
            </li>

            </c:forEach>
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
        <section>
          <!-- 슬라이더 영역 -->
          <section class="slider">
            <div class="slideshow-container">

              <!-- 메인화면 베너 이미지 및 이미지 number -->
              <div class="mySlides fade">
                <div class="numbertext">1 / 5</div>
                <img src="./img/slider_item1.jpg" style="width:100%">
                <div class="text">K마켓</div>
              </div>
        
              <div class="mySlides fade">
                <div class="numbertext">2 / 5</div>
                <img src="./img/slider_item2.jpg" style="width:100%">
                <div class="text">K마켓</div>
              </div>
        
              <div class="mySlides fade">
                <div class="numbertext">3 / 5</div>
                <img src="./img/slider_item3.jpg" style="width:100%">
                <div class="text">K마켓</div>
              </div>
        
              <div class="mySlides fade">
                <div class="numbertext">4 / 5</div>
                <img src="./img/slider_item4.jpg" style="width:100%">
                <div class="text">K마켓</div>
              </div>
        
              <div class="mySlides fade">
                <div class="numbertext">5 / 5</div>
                <img src="./img/slider_item5.jpg" style="width:100%">
                <div class="text">K마켓</div>
              </div>
        
              <!-- 다음 이전 버튼 -->
              <a class="prev" onclick="moveSlides(-1)">&#10094;</a>
              <a class="next" onclick="moveSlides(1)">&#10095;</a>
            </div>
            <br/>
        
            <!-- 하단부 버튼 -->
            <div style="text-align:center">
              <span class="dot" onclick="currentSlide(0)"></span>
              <span class="dot" onclick="currentSlide(1)"></span>
              <span class="dot" onclick="currentSlide(2)"></span>
              <span class="dot" onclick="currentSlide(3)"></span>
              <span class="dot" onclick="currentSlide(4)"></span>
            </div>
          </section>
          <!-- 히트상품 영역 -->
          <section class="hit">
            <h3><span>히트상품</span></h3>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
          </section>
          <!-- 추천상품 영역 -->
          <section class="recommend">
            <h3><span>추천상품</span></h3>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span>배송비 2500</span>
                </div>
              </a>
            </article>
          </section>
          <!-- 최신상품 영역 -->
          <section class="new">
            <h3><span>최신상품</span></h3>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
          </section>
          <!-- 할인상품 영역 -->
          <section class="discount">
            <h3><span>할인상품</span></h3>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="https://via.placeholder.com/230x230" alt="t1" />
                </div>
                <h2>상품명</h2>
                <p>간단한 상품 설명</p>
                <div class="org_price">
                  <del>30,000</del>
                  <span>10%</span>
                </div>
                <div class="dis_price">
                  <ins>27,000</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
          </section>
        </section>
      </main>
<jsp:include page="./_footer.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
      <main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
            <c:forEach var="Cate1" items="${cates1}">
            <li>
              <a href="#">
				<c:choose>
              	<c:when test="${Cate1.cate1 == 10 }">
              	<i class="fas fa-folder" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
				<c:when test="${Cate1.cate1 == 11 }">
              	<i class="fas fa-tshirt" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 12 }">
              	<i class="fas fa-baby" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 13 }">
              	<i class="fas fa-utensils" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 14 }">
              	<i class="fas fa-home" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 15 }">
              	<i class="fas fa-laptop" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 16 }">
              	<i class="fas fa-running" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 17 }">
              	<i class="fas fa-shuttle-van" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
              	<c:when test="${Cate1.cate1 == 18 }">
              	<i class="fas fa-plane" aria-hidden="true"></i>${Cate1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
              	</c:when>
               	</c:choose>
              </a>
               <ol>
               <c:forEach var="Cate2" items="${cates2}">
               	<c:if test="${Cate1.cate1 eq Cate2.cate1}">
                <li><a href="#">${Cate2.c2Name}</a></li>
                </c:if>
                </c:forEach>
              </ol>
            </li>
            </c:forEach>
          </ul>

          <!-- 베스트상품 배너 -->
          <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
              <li>
				<c:forEach var="sold" items="${bestsold}">
	                <a href="#">
	                  <div class="thumb">
	                    <i>1</i>
	                    <img src="${sold.thumb1}" alt="sold1" />
	                  </div>
	                  <h2>${sold.prodName}</h2>
	                  <div class="org_price">
	                    <del>${sold.price}</del><span>${sold.discount}%</span>
	                  </div>
	                  <c:choose>
		                  <c:when test="${sold.discount ne 0}">
			                  <div class="dis_price">
			                    <ins>${sold.price- Math.round(sold.price*(sold.discount/100))}</ins>
			                  </div>
		                  </c:when>
		                  <c:otherwise>
							  <div class="dis_price">
			                    <ins>${sold.price}</ins>
			                  </div>
		                  </c:otherwise>
	                  </c:choose>
	                </a>
				</c:forEach>
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
            <c:forEach var="hit" items="${hitprod}">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="${hit.thumb1}" alt="히트상품" />
                </div>
                <h2>${hit.prodName}</h2>
                <p>${hit.descript}</p>
                <div class="org_price">
                  <del>${hit.price}</del>
                  <span>${hit.discount}</span>
                </div>
                <c:choose>
                <c:when test="${hit.discount ne 0}">
	               <div class="dis_price">
	                 <ins>${hit.price- Math.round(hit.price*(hit.discount/100))}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:when>
	            <c:otherwise>
	            	<div class="dis_price">
	                 <ins>${hit.price}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:otherwise>
                </c:choose>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 추천상품 영역 -->
          <section class="recommend">
            <h3><span>추천상품</span></h3>
            <c:forEach var="score" items="${scoreprod}">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="${score.thumb1}" alt="추천상품" />
                </div>
                <h2>${score.prodName}</h2>
                <p>${score.descript}</p>
                <div class="org_price">
                  <del>${score.price}</del>
                  <span>${score.discount}</span>
                </div>
                <c:choose>
                <c:when test="${score.discount ne 0}">
	               <div class="dis_price">
	                 <ins>${score.price- Math.round(score.price*(score.discount/100))}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:when>
	            <c:otherwise>
	            	<div class="dis_price">
	                 <ins>${score.price}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:otherwise>
                </c:choose>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 최신상품 영역 -->
          <section class="new">
            <h3><span>최신상품</span></h3>
            <c:forEach var="newprods" items="${newprod}">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="${newprods.thumb1}" alt="최신상품" />
                </div>
                <h2>${newprods.prodName}</h2>
                <p>${newprods.descript}</p>
                <div class="org_price">
                  <del>${newprods.price}</del>
                  <span>${newprods.discount}</span>
                </div>
                <c:choose>
                <c:when test="${newprods.discount ne 0}">
	               <div class="dis_price">
	                 <ins>${newprods.price- Math.round(newprods.price*(newprods.discount/100))}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:when>
	            <c:otherwise>
	            	<div class="dis_price">
	                 <ins>${newprods.price}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:otherwise>
                </c:choose>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 할인상품 영역 -->
          <section class="discount">
            <h3><span>할인상품</span></h3>
            <c:forEach var="dcprod" items="${discountprod}">
            <article>
              <a href="#">
                <div class="thumb">
                  <img src="${dcprod.thumb1}" alt="최신상품" />
                </div>
                <h2>${dcprod.prodName}</h2>
                <p>${dcprod.descript}</p>
                <div class="org_price">
                  <del>${dcprod.price}</del>
                  <span>${dcprod.discount}</span>
                </div>
                <c:choose>
                <c:when test="${newprods.discount ne 0}">
	               <div class="dis_price">
	                 <ins>${dcprod.price- Math.round(dcprod.price*(dcprod.discount/100))}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:when>
	            <c:otherwise>	
	            	<div class="dis_price">
	                 <ins>${dcprod.price}</ins>
	                 <span class="free">무료배송</span>
	               </div>
	            </c:otherwise>
                </c:choose>
              </a>
            </article>
            </c:forEach>
          </section>
        </section>
      </main>
<jsp:include page="./_footer.jsp"/>

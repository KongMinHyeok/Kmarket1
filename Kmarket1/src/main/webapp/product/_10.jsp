<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	String prodCate2 = request.getParameter("prodCate2");
%>
        <main id="product">
            <aside>
                <ul class="category">
                    <!-- 아이콘들 Font Awesome에서 들고온거라 복붙했음 -->     
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <li>
                        <a href="#"><i class="fas fa-tshirt"></i>패션·의류·뷰티</a>
                        <ol>
                            <li><a href="./list.do?prodCate1=10&prodCate2=10">여성의류</a></li>
                            <li><a href="./list.do?prodCate1=10&prodCate2=11">남성의류</a></li>
                            <li><a href="./list.do?prodCate1=10&prodCate2=12">진/캐쥬얼</a></li>
                            <li><a href="./list.do?prodCate1=10&prodCate2=13">신발/가방</a></li>
                            <li><a href="./list.do?prodCate1=10&prodCate2=14">쥬얼리/시계</a></li>
                            <li><a href="./list.do?prodCate1=10&prodCate2=15">아웃도어</a></li>
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
	            <form action="/Kmarket1/product/list.do" method="get">
	        	<input type="hidden" name="prodCate1" value="${prodCate1}">
	        	<input type="hidden" name="prodCate2" value="${prodCate2}">
	        	</form>
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품목록</h1>
                    <p>HOME > 패션·의류·뷰티 > 
	                    <% if(prodCate2.equals("10")){ %> 
	                    <em>여성의류</em>
	                    <% }else if(prodCate2.equals("11")){ %>
	                    <em>남성의류</em>
	                    <% }else if(prodCate2.equals("12")){ %>
	                    <em>진/캐쥬얼</em>
	                    <% }else if(prodCate2.equals("13")){ %>
	                    <em>신발/가방</em>
	                    <% }else if(prodCate2.equals("14")){ %>
	                    <em>주얼리/시계</em>
	                    <% }else if(prodCate2.equals("15")){ %>
	                    <em>아웃도어</em>
	                    <% } %>
					</p>
                </nav>
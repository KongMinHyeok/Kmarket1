<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="./_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 마지막에 /admin/product 폴더 만들고 이름 register로 바꾸고 경로 재설정 해야됨 -->
<main>
    <aside>
        <ul id="gnb">
            <li>
                <a href="#"><i class="fa fa-cogs" aria-hidden="true"></i>환경설정</a>
                <ol>
                    <li><a href="#">기본환경설정</a></li>
                    <li><a href="#">배너관리</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fa fa-store" aria-hidden="true"></i>상점관리</a>
                <ol>
                    <li><a href="#">판매자현황</a></li>
                    <li><a href="#">재고관리</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fa fa-users" aria-hidden="true"></i>회원관리</a>
                <ol>
                    <li><a href="#">회원현황</a></li>
                    <li><a href="#">포인트관리</a></li>
                    <li><a href="#">비회원관리</a></li>
                    <li><a href="#">접속자집계</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fa fa-box-open" aria-hidden="true"></i>상품관리</a>
                <ol>
                    <li><a href="/Kmarket1/admin/productList.do">상품현황</a></li>
                    <li><a href="/Kmarket1/admin/productRegister.do">상품등록</a></li>
                    <li><a href="#">재고관리</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fa fa-credit-card" aria-hidden="true"></i>주문관리</a>
                <ol>
                    <li><a href="#">주문현황</a></li>
                    <li><a href="#">매출현황</a></li>
                    <li><a href="#">결제관리</a></li>
                    <li><a href="#">배송관리</a></li>
                </ol>
            </li>
            <li>
                <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>게시판관리</a>
                <ol>
                    <li><a href="#">게시판현황</a></li>
                    <li><a href="#">고객문의</a></li>
                </ol>
            </li>
        </ul>
    </aside>
    <section id="admin-product-list">
        <nav>
            <h3>상품목록</h3>
            <p>
                HOME > 상품관리 > 
                <strong>상품목록</strong>
            </p>
        </nav>
        <section>
            <div>
                <select name="search">
                    <option value="search1">상품명</option>
                    <option value="search1">상품코드</option>
                    <option value="search1">제조사</option>
                    <option value="search1">판매자</option>
                </select>
                <input type="text" name="search">
            </div>
            <table>
                <tr>
                    <th>
                        <label>
                            <input type="checkbox" name="all">
                        </label>
                    </th>
                    <th>이미지</th>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>판매가격</th>
                    <th>할인율</th>
                    <th>포인트</th>
                    <th>재고</th>
                    <th>판매자</th>
                    <th>조회</th>
                    <th>관리</th>
                </tr>
                <c:forEach var="vo" items="${products}">
                <tr>
                	<td><input type="checkbox" name="상품코드"></td>
                	<td><img src="./img/sample_thumb.jpg" class="thumb"></td>
                	<td>${vo.prodNo}</td>
                    <td>${vo.prodName}</td>
                    <td>${vo.price}</td>
                    <td>${vo.discount}</td>
                    <td>${vo.point}</td>
                    <td>${vo.stock}</td>
                    <td>${vo.seller}</td>
                    <td>${vo.hit}</td>
                    <td>
                        <a href="#">[삭제]</a>
                        <a href="#">[수정]</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <input type="button" value="선택삭제">
            <div class="paging">
            	<c:if test="${pageGroupStart > 1}">
		            <a href="/Kmarket1/admin/productlist.do?pg=${pageGroupStart - 1}" class="prev"><&nbsp;이전</a>
	            </c:if>
	            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
		            <a href="/Kmarket1/admin/productlist.do?pg=${num}" class="num ${num == currentPage ? 'current':'off'}">${num}</a>
	            </c:forEach>
	            <c:if test="${pageGroupEnd < lastPageNum}">
		            <a href="/Kmarket1/admin/productlist.do?pg=${pageGroupEnd + 1}" class="next">다음&nbsp;></a>
	            </c:if>
            </div>
        </section>
        <p class="ico info">
            <strong>Tip!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>
    </section>
</main>
<jsp:include page="./_footer.jsp"/>
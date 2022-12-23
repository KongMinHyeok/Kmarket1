<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../_header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form action="/Kmarket1/admin/product/list.do" method="get">
	                <select name="type">
	                    <option value="prodName">상품명</option>
	                    <option value="prodCode">상품코드</option>
	                    <option value="company">제조사</option>
	                    <option value="seller">판매자</option>                               
	                </select>
	                <input type="text" name="search">
	                <button type="submit">검색</button>
                </form>
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
                	<td><input type="checkbox" name="상품코드"><input type="hidden" name="size" value="${products.size()}"/></td>
                	<td><img src="../../img/sample_thumb.jpg" class="thumb"></td>
                	<td>${vo.prodNo}</td>
                    <td>${vo.prodName}</td>
                    <td>${vo.price}</td>
                    <td>${vo.discount}</td>
                    <td>${vo.point}</td>
                    <td>${vo.stock}</td>
                    <td>${vo.seller}</td>
                    <td>${vo.hit}</td>
                    <td>
                        <a href="/Kmarket1/admin/product/delete.do?prodNo=${vo.prodNo}">[삭제]</a>
                        <a href="/Kmarket1/admin/product/modify.do?prodNo=${vo.prodNo}">[수정]</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <input type="button" value="선택삭제">
            <div class="paging">
	        	<c:if test="${pageGroupStart > 1}">
		            <a href="/Kmarket1/admin/product/list.do?pg=${pageGroupStart - 1}" class="prev"><&nbsp;이전</a>
	            </c:if>
	            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
		            <a href="/Kmarket1/admin/product/list.do?pg=${num}" class="num ${num == currentPage ? 'current':'off'}">${num}</a>
	            </c:forEach>
	            <c:if test="${pageGroupEnd < lastPageNum}">
		            <a href="/Kmarket1/admin/product/list.do?pg=${pageGroupEnd + 1}" class="next">다음&nbsp;></a>
	            </c:if>
	        </div>
        </section>
        <p class="ico info">
            <strong>Tip!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>
    </section>
</main>
<jsp:include page="../_footer.jsp"/>
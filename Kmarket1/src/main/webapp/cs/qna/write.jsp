<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
      <section id="cs">
        <div class="qna">
          <nav>
            <div>
              <p>홈<span>></span>문의하기</p>
            </div>
          </nav>
          <section class="write">
            <aside>
              <h2>문의하기</h2>
              <ul>
                <li class="${cate eq null || cate eq 'member' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=member">회원</a></li>
                <li class="${cate eq 'event' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=event">쿠폰/이벤트</a></li>
                <li class="${cate eq 'order' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=order">주문/결제</a></li>
                <li class="${cate eq 'ship' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=ship">배송</a></li>
                <li class="${cate eq 'cancel' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=cancel">취소/반품/교환</a></li>
                <li class="${cate eq 'trip' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=trip">여행/숙박/항공</a></li>
                <li class="${cate eq 'safe' ? 'on':'off'}"><a href="/Kmarket1/cs/qna/list.do?cate=safe">안전거래</a></li>
              </ul>
            </aside>
            <article>
              <form action="/Kmarket1/cs/qna/write.do" method="post">
              <input type="text" name="uid" value="${sessUser.uid}">
                <table>
                  <tr>
                    <td>문의유형</td>
                    <td>
                      <select name="type">
                        <option value="0">1차 선택</option>
                        <option value="member" <c:if test="${cate eq 'member'}">selected</c:if>>회원</option>
                        <option value="event" <c:if test="${cate eq 'event'}">selected</c:if>>쿠폰/이벤트</option>
                        <option value="order" <c:if test="${cate eq 'order'}">selected</c:if>>주문/결제</option>
                        <option value="ship" <c:if test="${cate eq 'ship'}">selected</c:if>>배송</option>
                        <option value="cancel" <c:if test="${cate eq 'cancel'}">selected</c:if>>취소/반품/교환</option>
                        <option value="trip" <c:if test="${cate eq 'trip'}">selected</c:if>>여행/숙박/항공</option>
                        <option value="safe" <c:if test="${cate eq 'safe'}">selected</c:if>>안전거래</option>
                      </select>
                      <select>
                      	<option value="">2차선택</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>문의제목</td>                  
                    <td>
                      <input type="text" name="title" placeholder="제목을 입력하세요."/>
                    </td>
                  </tr>                
                  <tr>
                    <td>문의내용</td>                  
                    <td>
                      <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                    </td>
                  </tr>
                </table>
                <div>
                  <a href="/Kmarket1/cs/qna/list.do?cate=${cate}" class="btnList">취소하기</a>
                  <input type="submit" class="btnSubmit" value="등록하기"/>
                </div>
              </form>
            </article>
          </section>
        </div>
      </section>
<jsp:include page="../_footer.jsp"/>

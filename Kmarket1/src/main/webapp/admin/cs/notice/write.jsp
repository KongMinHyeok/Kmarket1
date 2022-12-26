<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/admin/_header.jsp"/>
            <section id="admin-notice-view">
                <nav>
                    <h3>공지사항 작성</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <form action="/Kmarket1/admin/cs/notice/write.do" method="post">
                <input type="hidden" name="uid" value="${uid}">
                <article class="list">
	               <table>
	               	<tr>
	               		<th>유형</th>
	               		<td>
	               			<select name="cate">
	               				<option value="0">유형 선택</option>
	               				<option value="service">고객 서비스</option>
	               				<option value="safe">안전거래</option>
	               				<option value="product">위해상품</option>
	               				<option value="event">이벤트 당첨</option>
	               			</select>
	               		</td>
	               	</tr>
	               	<tr>
	               		<th>제목</th>
	               		<td><input type="text" name="title" placeholder="제목을 입력해주세요"></td>
	               	</tr>
	               	<tr>
	               		<th>내용</th>
	               		<td><textarea name="content" placeholder="내용을 입력해주세요"></textarea></td>
	               	</tr>
	               </table>
	               <div class="btnNotice">
                      <a href="/Kmarket1/admin/cs/notice/list.do" class="noticecancel">취소하기</a>
                      <input name="submit"  class="noticeWrite" type="submit" value="등록하기">      
					</div>
	        	</article>
	        	</form>        
            </section>
        </main>
<jsp:include page="/admin/_footer.jsp"/>
        
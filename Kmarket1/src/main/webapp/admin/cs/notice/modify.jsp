<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/admin/_header.jsp"/>
            <section id="admin-notice-view">
                <nav>
                    <h3>공지사항 수정</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <form action="/Kmarket1/admin/cs/notice/modify.do" method="post">
                <input type="hidden" name="no" value="${notice.no}"/>
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
	               		<td><input type="text" name="title" value="${notice.title}"> </td>
	               	</tr>
	               	<tr>
	               		<th>내용</th>
	               		<td><textarea name="content">${notice.content}</textarea></td>
	               	</tr>
	               </table>
	               <div class="btnNotice">
						<button class="noticeList" onclick ="/Kmarket/admin/cs/notice/view.do?no=${vo.no}">취소하기</button>
	                    <input class="noticeModify" type="submit" name="submit" value="수정하기">
					</div>
	        	</article>
	        	</form>        
            </section>
        </main>
<jsp:include page="/admin/_footer.jsp"/>
        
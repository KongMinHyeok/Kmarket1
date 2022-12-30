<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:include page="/admin/_header.jsp"/>
<script>

	$(document).ready(function(){
	    //최상단 체크박스 클릭
	    $("#AllCheck").click(function(){
	        //클릭되었으면
	        if($("#AllCheck").prop("checked")){
	            $("input[name=RowCheck]").prop("checked",true);
	        }else{
	            $("input[name=RowCheck]").prop("checked",false);
	        }
	    })
	})
	function deleteCheck(){
		var chkarr = new Array();
		var cnt = $("input[name='RowCheck']:checked").length;
		$("input:checkbox[name='RowCheck']:checked").each(function(){
			chkarr.push($(this).val());
			console.log(chkarr);
		});
		
		if($("input:checkbox[name='RowCheck']:checked").length === 0) {
			alert("삭제할 항목을 선택해 주세요.");
			return;
		}
		let chk = confirm("삭제하시겠습니까?");
		if(chk){
			$.ajax({
				url:'/Kmarket1/admin/cs/qna/delete.do',
				type:'post',
				traditional: true,
				data:{'chkarr':chkarr},
				dataType:'json',
				success:function(data){
					if(data.result > 0){
						alert("삭제완료");
						location.reload();
					}else{
						alert('삭제실패');
					}
				}
			});
		}
	}
</script>
     <section id="admin-notice-list">
         <nav>
             <h3>문의하기 목록</h3>
             <p>
                 HOME > 고객센터 > <strong>문의하기</strong>
             </p>
         </nav>
         <article class="list">
             <select name="cate1">
              <option value="0">1차선택</option>
              <c:forEach var="cate" items="${faqct}">
              	<option value="${cate.cate}">${cate.cate}</option>
              </c:forEach>
         	</select>
         	<select name="cate2">
              <option value="0">2차선택</option>
              <c:forEach var="cate2" items="${faqct2}">
              	<option value="${cate2.cate2}">${cate2.cate2}</option>
              </c:forEach>
         	</select>
                 <table>
                      <tr>
                       <th><input type="checkbox" id="AllCheck"/></th>
                       <th>번호</th>
                       <th>1차유형</th>
                       <th>2차유형</th>
                       <th>제목</th>
                       <th>작성자</th>
                       <th>작성일</th>
                       <th>상태</th>
                      </tr>
                      <c:forEach var="qna" items="${articles}" begin="0" end="9">
        			  <tr>
         			   <td><input type="checkbox" name="RowCheck" value="${qna.no}"></td>
                	   <td>${qna.no}</td>
                       <td>${qna.cate}</td>
                       <td>${qna.cate2}</td>
                       <td>
                       <c:if test="${qna.comment eq null}"><a href="/Kmarket1/admin/cs/qna/reply.do?cate=${qna.cate}&no=${qna.no}&cate2=${qna.cate2}&pg=${pg}">${qna.title}</a></c:if>
                       <c:if test="${qna.comment ne null}"><a href="/Kmarket1/admin/cs/qna/view.do?cate=${qna.cate}&no=${qna.no}&cate2=${qna.cate2}&pg=${pg}">${qna.title}</a></c:if>
                       </td>
	                   <c:choose>
						<c:when test="${fn:length(qna.uid) gt 5}">
							<td>${fn:substring (qna.uid,0,fn:length(qna.uid)-3)}***</td>
	                    </c:when>
		                <c:otherwise>
		                   	<td>${fn:substring (qna.uid,0,fn:length(qna.uid)-2)}**</td>
		                </c:otherwise>
	                   </c:choose>
                       <td>${qna.rdate}</td>
				 	   <td>
						<c:if test="${qna.comment eq null}"><span style="color:#8C8C8C; font-weight:bold; font-size:13px">검토중</span></c:if>
	                  	<c:if test="${qna.comment ne null}"><span style="color:#3DB7CC; font-weight:bold; font-size:13px">답변완료</span></c:if>
                  	   </td>
        			  </tr>
    			 	  </c:forEach>
                 </table>
					<div class="page">
		          	<c:if test="${pageGroupStart gt 1 && cate ne null}">
		            	<a href="/Kmarket1/admin/cs/qna/list.do?pg=${pageGroupStart-1}&cate=${cate}" class="prev">이전</a>
		          	</c:if>
		          	<c:if test="${pageGroupStart gt 1 && cate eq null}">
		            	<a href="/Kmarket1/admin/cs/qna/list.do?pg=${pageGroupStart-1}" class="prev">이전</a>
		          	</c:if>
		            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
		            <c:choose>
		             <c:when test="${cate ne null}">
		             	<a href="/Kmarket1/admin/cs/qna/list.do?pg=${num}&cate=${cate}" class="num ${currentPage eq num ? 'on' : 'off' }">${num}</a>
		            	</c:when>
		           	</c:choose>
		           	<c:choose>
		             <c:when test="${cate eq null}">
						<a href="/Kmarket1/admin/cs/qna/list.do?pg=${num}" class="num ${currentPage eq num ? 'on' : 'off' }">${num}</a>
		            	</c:when>
		           	</c:choose>
		            </c:forEach>
		            <c:if test="${pageGroupEnd lt lastPageNum && cate ne null}">
		            	<a href="/Kmarket1/admin/cs/qna/list.do?pg=${pageGroupStart+1}&cate=${cate}" class="next">다음</a>
		            </c:if>
		            <c:if test="${pageGroupEnd lt lastPageNum && cate eq null}">
		            	<a href="/Kmarket1/admin/cs/qna/list.do?pg=${pageGroupStart+1}" class="next">다음</a>
		            </c:if>
                 </div>
                    <a href="#" class="btnDelete" onclick="deleteCheck();">선택삭제</a>
		</article>
     </section>
    </main>
<jsp:include page="/admin/_footer.jsp"/>
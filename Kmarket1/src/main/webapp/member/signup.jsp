<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/member/_header.jsp"/>
<script>
	$(function(){
		$('.agree').click(function(){
			let type = '${type}';
			let agree1 = $('input:checkbox[name=agree1]').is(':checked');
			let agree2 = $('input:checkbox[name=agree2]').is(':checked');
			let agree3 = $('input:checkbox[name=agree3]').is(':checked');
			let agree4 = $('input:checkbox[name=agree4]').is(':checked');
			let agree5 = $('input:checkbox[name=agree5]').is(':checked');
			console.log(agree5);
			
			if(type == 'normal'){
				if(agree1 && agree2 && agree3){
					location.href ='/Kmarket1/member/register.do';
				}else{
					alert('모든 항목에 동의하셔야 다음으로 넘어갈 수 있습니다');
				}
			}else{
				if(agree1 && agree2 && agree3 && agree5){
					location.href ='/Kmarket1/member/registerSeller.do';
				}else{
					alert('모든 항목에 동의하셔야 다음으로 넘어갈 수 있습니다');
				}
			}
		});
	});
</script>
        <main id="member">
            <div class="signup">
                <nav>
                    <h1>약관동의</h1>
                </nav>
                <section>
                    <h3>
                        <span class="essential">(필수)</span>
                        케이마켓 이용약관
                    </h3>
                    <textarea class="terms" readonly>${term}</textarea>
                    <label>
                        <input type="checkbox" name="agree1">
                        동의합니다.
                    </label>
                    <h3>
                        <span class="essential">(필수)</span>
                        전자금융거래 이용약관
                    </h3>
                    <textarea class="financial" readonly>${finance}</textarea>
                    <label>
                        <input type="checkbox" name="agree2">
                        동의합니다.
                    </label>
                    <c:if test="${type eq 'seller'}">
                    	<h3>
                        <span class="essential">(필수)</span>
                        오픈마켓 판매자약관
                    </h3>
                    <textarea class="financial" readonly>${tax}</textarea>
                    <label>
                        <input type="checkbox" name="agree5">
                        동의합니다.
                    </label>
                    </c:if>
                    <h3>
                        <span class="essential">(필수)</span>
                        개인정보 수집동의
                    </h3>
                    <textarea class="privacy" readonly>${privacy}</textarea>
                    <label>
                        <input type="checkbox" name="agree3">
                        동의합니다.
                    </label>
                </section>
                <section>
                    <h3>
                        <span class="optional">(선택)</span>
                        위치정보 이용약관
                    </h3>
                    <textarea class="location" readonly>${location}</textarea>
                    <label>
                        <input type="checkbox" name="agree4">
                        동의합니다.
                    </label>
                </section>
                <div>
                    <input type="button" class="agree" value="동의하기">
                </div>
            </div>
        </main>
<jsp:include page="/member/_footer.jsp" />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
<script>
	$(function(){
		$('#btnVerifyId').click(function(){
			let id = $('input[name=findPw_id]').val();
			
			$.ajax({
				url: '/Kmarket1/member/findPw.do',
				method: 'POST',
				data: {"id": id},
				dataType: 'json',
				success: function(data){
					if(data.result > 0){
						location.href="/Kmarket1/member/changePwVerify.do?id=" + id;
					}else{
						alert('일치하는 회원 정보가 없습니다\n아이디를 다시 확인하시거나 아이디 찾기를 이용해주시기 바랍니다');
					}
				}
			});
		});
	});
</script>
<main id="member">
    	<div class="findId">
    			<div class="findTabContainer">
                    <div class="findTab tabId" onclick="location.href='/Kmarket1/member/findId.do';" style="cursor:pointer">
                        <a href="/Kmarket1/member/findId.do">아이디 찾기</a>
                    </div>
                    <div class="findTab tabPw on" onclick="location.href='/Kmarket1/member/findPw.do';" style="cursor:pointer">
                        <a href="/Kmarket1/member/findPw.do" class="on">비밀번호 재설정</a>
                    </div>
                </div>
               	<ul id="member_gnb" style="height:250px;">
                    <li>
                        <a class="findPwA">
                            비밀번호를 변경하고자 하는 아이디를 입력해주세요.
                        </a>
                        <div class="findPwDiv">
                            <form action="#" method="post" onsubmit="return false;">
                                <table border="0">
                                    <tr>
                                        <td>
                                            <input type="text" name="findPw_id" placeholder="아이디를 입력하세요">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="submit" value="확인" id="btnVerifyId">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
    </main>
<jsp:include page="/member/_footer.jsp"/>
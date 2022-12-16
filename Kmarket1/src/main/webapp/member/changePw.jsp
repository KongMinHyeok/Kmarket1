<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
<script>
let passReg = /^.*(?=^.{8,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/; // 영문, 숫자, 특문 조합 8~12자리
let isPassOk = false;

	$(function(){
		// 비밀번호 유효성 검사
		$('input[name=newPw2]').focusout(function(){
			let pass1 = $('input[name=newPw1]').val();
			let pass2 = $('input[name=newPw2]').val();
			if(pass1 == pass2){
				// 유효성 검사
				if(!pass2.match(passReg)){
					$('.msgPass2').css('color', 'red').text('영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요');
					return;
				}else{
					isPassOk = true;
					$('.msgPass2').css('color', 'black').text('사용 가능한 비밀번호입니다');
				}
			}else{
				$('.msgPass2').css('color', 'red').text('비밀번호가 일치하지 않습니다');
				return;
			}
		});
		
		$('#btnUpdatePw').click(function(){
			let pass1 = $('input[name=newPw1]').val();
			let pass2 = $('input[name=newPw2]').val();
			let id = $('input[name=id]').val();
			
			console.log(pass2);
			$.ajax({
				url: '/Kmarket1/member/changePw.do',
				method: 'POST',
				data: {"pass":pass2, "id":id},
				dataType: 'json',
				success: function(data){
					if(data.result > 0){
						alert('비밀번호가 성공적으로 변경되었습니다\n다시 로그인해주세요');
						$.ajax({
							url: '/Kmarket1/member/logout.do',
							method: 'GET',
							data: {"uid" : id},
							success: function(data){
								location.href = "/Kmarket1/index.do";
							}
						});
					}else{
						alert('일시적인 오류가 발생하였습니다\n다시 시도해주세요');
					}
				}
			});
		});
	});
</script>
<main id="member">
    	<div class="changePw">
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
                        <a class="changePwA">
                            새로운 비밀번호를 입력해주세요.
                        </a>
                        <div class="changePwDiv">
                            <form action="#" method="post" onsubmit="return false;">
                            	<input type="hidden" name="id" value="${id}">
                                <table border="0">
                                    <tr>
                                        <td>
                                            <input type="password" name="newPw1" placeholder="비밀번호를 입력하세요">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="password" name="newPw2" placeholder="비밀번호를 다시 입력하세요">
                                        </td>
                                    </tr>
                                    <tr>
                                    	<td>
                                    		<span class="msgPass2"></span>
                                    	</td>
                                  	</tr>
                                    <tr>
                                        <td>
                                            <input type="submit" value="확인" id="btnUpdatePw">
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
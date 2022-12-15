<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
<script src="/Kmarket1/member/js/memberGnb.js"></script>
<script>
let isEmailAuthOk = false;
let receivedCode = 0;
let isEmailAuthCodeOk = false;
	$(function(){
		$('#btnGetCode1').click(function(){
			alert('오류가 발생하였습니다\n잠시 후 다시 시도해주세요');
			return;
		});
		
		$('#btnGetCode2').click(function(){
			// 인증번호 받기 버튼은 사라지게하고 인증코드 넣는 input 보이게하기
			$(this).hide();
			
			// 이메일 인증
			let email = $('input[name=findId_email]').val();
			$.ajax({
				url: '/Kmarket1/member/emailAuth.do',
				method: 'GET',
				data: {"email":email},
				dataType: 'json',
				success: function(data){
					if(data.status > 0){
						isEmailAuthOk = true;
						$('input[name=findId_email_verify]').show();
						$('#btnVerify').show();
						receivedCode = data.code;
					}else{
						alert('메일 전송에 실패하였습니다\n다시 시도해주세요');
						$('#btnGetCode2').show();
					}
				}
			});
		});
		
		$('#btnVerify').click(function(){
			let name = $('input[name=findId_name2]').val();
			let email = $('input[name=findId_email]').val();
			let code = $('input[name=findId_email_verify]').val();
			console.log(name);
			console.log(email);
			
			if(code == ''){
				alert('이메일 확인 후 인증 코드를 입력하세요');
				return;
			}
			
			if(code == receivedCode){
				isEmailAuthCodeOk = true;
				$('input[name=findId_name]').attr('readonly', true);
				$('input[name=findId_email]').attr('readonly', true);
				
				$.ajax({
					url: '/Kmarket1/member/findIdEmailVerify.do',
					method: 'GET',
					data: {"name":name, "email":email},
					dataType: 'json',
					success: function(data){
						if(data.result != null){
							alert('회원님의 아이디는 ' + data.result + ' 입니다');
							$('#btnVerify').hide();
							$('#btnVerifiedLogin').show();
						}else{
							alert('일치하는 회원 정보가 없습니다');
						}
					}
				});
				
				
			}else{
				alert('인증코드가 틀립니다\n다시 확인해주세요');
			}
		});
	});
</script>
	<main id="member">
    	<div class="findId">
    			<div class="findTabContainer">
                    <div class="findTab tabId on" onclick="location.href='/Kmarket1/member/findId.do';" style="cursor:pointer">
                        <a href="/Kmarket1/member/findId.do" class="on">아이디 찾기</a>
                    </div>
                    <div class="findTab tabPw" onclick="location.href='/Kmarket1/member/findPw.do';" style="cursor:pointer">
                        <a href="/Kmarket1/member/findPw.do">비밀번호 재설정</a>
                    </div>
                </div>
               	<ul id="member_gnb">
                    <li>
                        <a>
                            <i class="fa-solid fa-circle-check off" aria-hidden="true" style="color: #0e6ad3;"></i>
                            휴대폰으로 찾기
                        </a>
                        <div>
                            <form action="#" method="post">
                                <table border="0">
                                    <tr>
                                        <td>
                                            <input type="text" name="findId_name" placeholder="이름">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="text" name="findId_hp" placeholder="휴대폰(숫자만 입력)">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="submit" value="인증번호 받기" id="btnGetCode1">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </li>
                    <li>
                        <a>
                            <i class="fa-solid fa-circle-check off" aria-hidden="true" style="color: #0e6ad3;"></i>
                            이메일로 찾기
                        </a>
                        <div>
                            <form action="#" method="post" onsubmit="return false;">
                                <table border="0">
                                    <tr>
                                        <td>
                                            <input type="text" name="findId_name2" placeholder="이름">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="text" name="findId_email" placeholder="이메일">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="text" name="findId_email_verify" placeholder="인증코드를 입력하세요" style="display:none;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="button" value="인증번호 받기" id="btnGetCode2">
                                        </td>
                                    </tr>
                                    <tr>
                                    	<td>
                                    		<input type="submit" value="인증하기" id="btnVerify" style="display:none;">
                                    	</td>
                                    </tr>
                                    <tr>
                                    	<td>
                                    		<a href="/Kmarket1/member/login.do"><input type="button" value="로그인하기" id="btnVerifiedLogin" style="display:none"></a>
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
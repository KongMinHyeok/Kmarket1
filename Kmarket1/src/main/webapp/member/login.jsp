<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp" />
<script>
	let success = '${success}';
	
	if(success == '100'){
		alert('일치하는 회원이 없습니다');
	}else if(success == '111'){
		alert('이미 탈퇴한 회원입니다\n재가입 후 서비스 이용이 가능합니다');
	}else if(success == '201'){
		alert('정상적으로 로그아웃되었습니다');
	}
</script>
        <main id="member">
            <div class="login">
               <nav>
                    <h1>로그인</h1>
                    <p>
                         HOME > 
                        <strong>로그인</strong>
                    </p>
               </nav> 
               <form action="/Kmarket1/member/login.do" method="post">
                    <table border="0">
                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="uid" placeholder="아이디 입력">
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td>
                                <input type="password" name="pass" placeholder="비밀번호 입력">
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인">
                    <span>
                        <label>
                            <input type="checkbox" name="auto">
                            자동 로그인
                        </label>
                        <a href="/Kmarket1/member/findId.do">아이디찾기</a>
                        <a href="/Kmarket1/member/findPw.do">비밀번호찾기</a>
                        <a href="/Kmarket1/member/join.do">회원가입</a>
                    </span>
                    <a href="#" class="banner">
                        <img src="./img/member_login_banner.jpg" alt="1만원 할인 쿠폰 받기">
                    </a>
               </form>
               <img src="./img/member_certifi_logo.gif" alt="banner">
            </div>
        </main>
<jsp:include page="/member/_footer.jsp" />
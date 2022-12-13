/**
 * 
 */
 // 정규표현식
let idReg = /^[a-zA-Z](?=.*[a-zA-Z])(?=.*[0-9]).{4,12}$/g; // 영문, 숫자 조합 4~12자리
let passReg = /^.*(?=^.{8,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/; // 영문, 숫자, 특문 조합 8~12자리
let nameReg = /^[가-힣]{2,10}$/;
let emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
let hpReg = /^\d{3}-\d{3,4}-\d{4}$/;
let companyReg = /\B(주)\S+/g;
let regReg = /([0-9]{3})-?([0-9]{2})-?([0-9]{5})/;
let telReg = /^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]))-(\d{3,4})-(\d{4})$/;

// 중복 및 유효성 검증 변수
let isUidOk = false;
let isPassOk = false;
let isNameOk = false;
let isEmailOk = false;
let isEmailAuthOk = false;
let receivedCode = 0;
let isEmailAuthCodeOk = false;
let isHpOk = false;
let isCompanyOk = false;
let isRegOk = false;
let isTelOk = false;
let isFaxOk = false;

	$(function(){
		// 아이디
		$('input[name=km_uid]').focusout(function(){
			let uid = $(this).val();
			
			// 유효성 확인
			if(!uid.match(idReg)){
				$('.msgId').css('color', 'red').text('영문, 숫자로 4~12자까지 설정해 주세요');
				return;
			}
			
			// 중복 검사
			$.ajax({
				url: '/Kmarket1/member/checkUid.do',
				method: 'GET',
				data: {"uid":uid},
				dataType: 'json',
				success: function(data){
					if(data.result < 1){
						isUidOk = true;
						$('.msgId').css('color', 'black').text('사용 가능한 아이디입니다');
					}else{
						isUidOk = false;
						$('.msgId').css('color', 'red').text('이미 존재하는 아이디입니다');
					}
				}
			});
		});
		
		// 비밀번호
		$('input[name=km_pass2]').focusout(function(){
			let pass1 = $('input[name=km_pass1]').val();
			let pass2 = $(this).val();
			
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
		
		// 이름
		$('input[name=km_name]').focusout(function(){
			let name = $(this).val();
			
			if(!name.match(nameReg)){
				$('.msgName').css('color', 'red').text('한글 이름만 입력 가능합니다');
			}else{
				isNameOk = true;
				$('.msgName').css('color', 'black').text('사용 가능한 이름입니다');
			}
		});
		
		// 이메일 유효성 검사
		$('input[name=km_email]').focusout(function(){
			let email = $(this).val();
			
			if(!email.match(emailReg)){
				isEmailOk = false;
				$('.msgEmail').css('color', 'red').text('유효한 이메일 주소가 아닙니다');
				return;
			}else{
				isEmailOk = true;
				$('.msgEmail').css('color', 'black').text('사용 가능한 이메일입니다');
			}
		});
		
		// 이메일 인증코드 받기
		$('#btnEmail').click(function(){
			$(this).hide();
			let email = $('input[name=km_email]').val();
			
			if(isEmailAuthOk){
				return;
			}
		
			if(isEmailOk){
				$('.msgEmail').text('인증코드 이메일을 발송하였습니다\n잠시만 기다려주세요');
				console.log(isEmailOk);
				
				setTimeout(function(){
					$.ajax({
						url: '/Kmarket1/user/emailAuth.do',
						method: 'GET',
						data: {"email":email},
						dataType: 'json',
						success: function(data){
							if(data.status > 0){
								isEmailAuthOk = true;
								$('.msgEmail').text('이메일을 확인 후 인증코드를 입력하세요');
								$('.auth').show();
								receivedCode = data.code;
							}else{
								alert('메일 전송에 실패하였습니다\n다시 시도해주세요');
								$('#btnEmail').show();
							}
						}
					});
				}, 500);
			}else{
				alert('이메일을 확인하세요');
				$('#btnEmail').show();
			}
		});
		
		// 이메일 인증코드 확인
		$('#btnEmailConfirm').click(function(){
			let code = $('input[name=auth]').val();
			
			if(code == ''){
				alert('이메일 확인 후 인증 코드를 입력하세요');
				return;
			}
			
			if(code == receivedCode){
				isEmailAuthCodeOk = true;
				$('input[name=km_email]').attr('readonly', true);
				$('.msgEmail').text('이메일이 인증되었습니다');
				$('.auth').hide();
			}else{
				alert('인증코드가 틀립니다\n다시 확인해주세요');
			}
		});
		
		// 휴대폰
		$('input[name=km_hp]').focusout(function(){
			let hp = $(this).val();
			
			if(!hp.match(hpReg)){
				$('.msgHp').css('color', 'red').text('유효하지 않은 번호입니다');
			}else{
				isHpOk = true;
				$('.msgHp').css('color', 'black').text('사용 가능한 번호입니다');
			}
		});
		
		// 전화번호
		$('input[name=kms_tel]').focusout(function(){
			let tel = $(this).val();
			
			if(!tel.match(telReg)){
				$('.msgTel').css('color', 'red').text('유효하지 않은 번호입니다');
			}else{
				isTelOk = true;
				$('.msgTel').css('color', 'black').text('사용 가능한 번호입니다');
			}
		});
		
		// 팩스
		$('input[name=kms_fax]').focusout(function(){
			let fax = $(this).val();
			
			if(!fax.match(telReg)){
				$('.msgFax').css('color', 'red').text('유효하지 않은 번호입니다');
			}else{
				isFaxOk = true;
				$('.msgFax').css('color', 'black').text('사용 가능한 번호입니다');
			}
		});
		
		// 회사 이름
		$('input[name=kms_company]').focusout(function(){
			let company = $(this).val();
			
			if(!company.match(companyReg)){
				$('.msgCompany').css('color', 'red').text('회사 이름은 (주)로 시작하여야 합니다');
			}else{
				isCompanyOk = true;
				$('.msgCompany').css('color', 'black').text('사용 가능한 회사이름입니다');
			}
		});
		
		// 사업자등록번호
		$('input[name=kms_corp_reg]').focusout(function(){
			let reg = $(this).val();
			
			// 유효성 확인
			if(!reg.match(regReg)){
				$('.msgCorp').css('color', 'red').text('유효한 사업자 등록번호가 아닙니다');
				return;
			}
			// 중복 검사
			$.ajax({
				url: '/Kmarket1/member/checkReg.do',
				method :'GET',
				data: {"reg": reg},
				dataType: 'json',
				success: function(data){
					console.log('here');
					
					if(data.result < 1){
						isRegOk = true;
						$('.msgCorp').css('color', 'black').text('사용 가능한 사업자 등록번호입니다');
					}else{
						console.log(data.result);
						isRegOk = false;
						$('.msgCorp').css('color', 'red').text('이미 존재하는 사업자 등록번호입니다');
					}
				}
			});
		});
		
		
		
		// 폼 전송
		$('.register > form').submit(function(){
			if(!isUidOk){
				alert('아이디를 확인하세요');
				return false;
			}
			if(!isPassOk){
				alert('패스워드를 확인하세요');
				return false;
			}
			if(!isNameOk){
				alert('이름을 확인하세요');
				return false;
			}
			if(!isEmailAuthCodeOk){
				alert('이메일 인증을 완료하세요');
				return false;
			}
			if(!isHpOk){
				alert('휴대폰 번호를 확인하세요');
				return false;
			}
			if(!isCompanyOk){
				alert('회사 이름을 확인하세요');
				return false;
			}
			if(!isTelOk){
				alert('회사 전화번호를 확인하세요');
				return false;
			}
			if(!isFaxOk){
				alert('팩스 번호를 확인하세요');
				return false;
			}
			if(!isRegOk){
				alert('사업자 등록번호를 확인하세요');
				return false;
			}
			return true;
		});
	});
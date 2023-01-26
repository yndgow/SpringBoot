document.addEventListener('DOMContentLoaded', ()=>{
	const currentUrl = window.location.href;
	const url = new URL(currentUrl);
	const urlParams = url.searchParams;
	let success = urlParams.get('success');
	if(success == '100'){
		alert('아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.');
	}else if(success == '200'){
		alert('안전하게 로그아웃 되었습니다.');
	}else if(success == '403'){
		alert('접근권한이 없습니다.');
	}
	
	
});
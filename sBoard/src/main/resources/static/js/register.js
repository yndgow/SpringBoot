/*$(()=>{
	$('#checkUid').click(()=>{
		
		let uid = $('input[name=uid]').val()
		
		$.ajax({
			url:'/SBoard/user/checkUid/'+uid,
			method:'get',
			dataType:'json',
			success:(data)=>{
				if(data.result > 0){
					alert('이미 사용중인 아이디입니다.')
				}else{
					alert('사용가능한 아이디입니다.')
				}
			}
			
		})
	})
})*/
document.addEventListener("DOMContentLoaded", ()=>{
	
	let btnCheckUid = document.getElementById('checkUid');
	
	// 아이디 중복 체크
	btnCheckUid.addEventListener('click', (e)=>{
		let uid = document.querySelector('input[name=uid]')
		url = '/SBoard/user/checkUid/'+uid.value;
		fetch(url)
		.then(res => {
			if(!res.ok) throw new Error(res.statusText);
			return res.json();
			})
		.then(data => {
			if(data.result > 0){
				alert('이미 사용중인 아이디입니다.')
			}else{
				alert('사용가능한 아이디입니다.')
			}
			})
		.catch(err => console.log(err)) ;
	})
	
});
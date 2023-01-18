$(()=>{
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
})
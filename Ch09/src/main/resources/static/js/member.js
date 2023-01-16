$(()=>{
	// member1 목록 요청1
	$('.member_list1').click(()=>{
		
		$.ajax({
			url:'/Ch09/member',
			method:'GET',
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	
	// member2 목록 요청2
	$('.member_list2').click(()=>{
		
		$.ajax({
			url:'/Ch09/member/r101',
			method:'GET',
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	
	// user1 등록 요청
	$('.member_register').click(()=>{
		
		let jsonData = {
				uid:'r101',
				name:'홍길동',
				hp:'010-1234-1111',
				pos:'사원'
				
		}
		
		$.ajax({
			url:'/Ch09/member',
			method:'POST',
			data:jsonData,
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	// user1 수정 요청
	$('.member_modify').click(()=>{
		let jsonData = {
				uid:'r101',
				name:'홍길동',
				hp:'010-1234-2222',
				pos:'대리'
		}
		
		$.ajax({
			url:'/Ch09/member',
			method:'PUT',
			data:jsonData,
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	// user1 삭제 요청
	$('.member_delete').click(()=>{
		
		$.ajax({
			url:'/Ch09/member/r101',
			method:'DELETE',
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
});
$(()=>{
	// user1 목록 요청1
	$('.user1_list1').click(()=>{
		
		$.ajax({
			url:'/Ch09/user1',
			method:'GET',
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	
	// user1 목록 요청2
	$('.user1_list2').click(()=>{
		
		$.ajax({
			url:'/Ch09/user1/a101',
			method:'GET',
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	
	// user1 등록 요청
	$('.user1_register').click(()=>{
		
		let jsonData = {
				uid:'r101',
				name:'홍길동',
				hp:'010-1234-1111',
				age:21,
				
		}
		
		$.ajax({
			url:'/Ch09/user1',
			method:'POST',
			data:jsonData,
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	// user1 수정 요청
	$('.user1_modify').click(()=>{
		let jsonData = {
				uid:'r101',
				name:'홍길동',
				hp:'010-1234-2222',
				age:25,
				
		}
		
		$.ajax({
			url:'/Ch09/user1',
			method:'PUT',
			data:jsonData,
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
	// user1 삭제 요청
	$('.user1_delete').click(()=>{
		
		$.ajax({
			url:'/Ch09/user1/r101',
			method:'DELETE',
			dataType:'json',
			success:((data)=>{
				console.log(data);
			})
		})
	})
});
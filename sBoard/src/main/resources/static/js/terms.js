document.addEventListener('DOMContentLoaded', ()=>{
	const terms = document.getElementById('terms');
	const privacy = document.getElementById('privacy');
	const btnNext = document.getElementById("btnNext");
	
	btnNext.addEventListener('click',(e)=>{
		e.preventDefault();
		if(terms.checked && privacy.checked){
			location.href = '/sBoard/user/register';
		}else{
			alert('모두 동의하셔야 합니다.')
			return false;
		}
		
		
	});
	
	
	
	
});
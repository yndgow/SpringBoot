package kr.co.ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.repository.User2Repo;
import kr.co.ch08.vo.User2VO;

@Service
public class User2Service{ // 로그인 수행 인터페이스
	
	@Autowired
	private User2Repo repo;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	
	public void inserUser2(User2VO vo) {
		
		// Spring Security 암호화 처리
		vo.setPass(passEncoder.encode(vo.getPass()));
		repo.save(vo);
	}
	public void selectUser2List() {}
	public User2VO selectUser2One(User2VO vo) {
		return repo.findUser2VOByUidAndPass(vo.getUid(), vo.getPass());
	}
	public void updateUser2() {}
	public void deleteUser2() {}
	
	// 인증처리
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User2VO user = repo.findById(username).get();
//		if(user == null) {
//			System.out.println("user empty...");
//			throw new UsernameNotFoundException(username);
//		}
//		
//		/*
//		UserDetails userDts = User.builder()
//									.username(user.getUid())
//									.password(user.getPass())
//									.roles("ADMIN")
//									.build();
//									*/
//		MyUserDetails myUser = new MyUserDetails();
//		myUser.setUid(user.getUid());
//		myUser.setPass(user.getPass());
//		myUser.setHp(user.getHp());
//		myUser.setName(user.getName());
//		myUser.setAge(user.getAge());
//		myUser.setRdate(user.getRdate().toString());
//		
//		return myUser;
//	}
	
}

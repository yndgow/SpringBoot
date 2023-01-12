package kr.co.ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.repository.User2Repo;
import kr.co.ch08.vo.User1VO;
import kr.co.ch08.vo.User2VO;

@Service
public class User2Service implements UserDetailsService{ // 로그인 수행 인터페이스
	
	
	@Autowired
	private User2Repo repo;
	
	public void inserUser2(User1VO vo) {
		
	}
	public void selectUser2List() {}
	public User2VO selectUser2One(User1VO vo) {
		return repo.findUser2VOByUidAndPass(vo.getUid(), vo.getPass());
	}
	public void updateUser2() {}
	public void deleteUser2() {}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 인증처리
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User2VO user = repo.findById(username).get();
		
		if(user == null) {
			System.out.println("user empty...");
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails userDts = User.builder()
									.username(user.getUid())
									.password(passwordEncoder.encode(user.getPass()))
									.roles("ADMIN")
									.build();
		System.out.println(passwordEncoder.encode(user.getPass()));
		return userDts;
	}
}

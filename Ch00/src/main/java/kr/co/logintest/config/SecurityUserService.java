package kr.co.logintest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.logintest.entity.Member;
import kr.co.logintest.repo.MemberRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityUserService implements UserDetailsService{

	@Autowired
	private MemberRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member user = null;
		
		user = repo.findByUid(username);
		
		log.info("LoginUser : " + user);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails userDts = MyUserDetails.builder()
										   .user(user)
										   .build();
		
		return userDts;
	}

}

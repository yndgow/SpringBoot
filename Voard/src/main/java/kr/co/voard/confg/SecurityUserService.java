package kr.co.voard.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.voard.repository.UserEntity;
import kr.co.voard.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityUserService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = null;
		try {
			user = repo.findById(username).get();
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		MyUserDetails userDts = MyUserDetails.builder()
										   .user(user)
										   .build();
		
		return userDts;
	}

}

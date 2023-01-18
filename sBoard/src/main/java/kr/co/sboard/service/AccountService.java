package kr.co.sboard.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AccountService implements UserDetailsService{

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
//		User2VO user = repo.findById(username).get();
//		MyUserDetails myUser = new MyUserDetails();
//		myUser.setUid(user.getUid());
//		myUser.setPass(user.getPass());
//		myUser.setHp(user.getHp());
//		myUser.setName(user.getName());
//		myUser.setAge(user.getAge());
//		myUser.setRdate(user.getRdate().toString());
//		return myUser;
	}

}

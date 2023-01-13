package kr.co.ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.ch08.config.MyUserDetails;
import kr.co.ch08.repository.User2Repo;
import kr.co.ch08.vo.User2VO;

@Service
public class AccountService implements UserDetailsService{

	@Autowired
	private User2Repo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User2VO user = repo.findById(username).get();
		MyUserDetails myUser = new MyUserDetails();
		myUser.setUid(user.getUid());
		myUser.setPass(user.getPass());
		myUser.setHp(user.getHp());
		myUser.setName(user.getName());
		myUser.setAge(user.getAge());
		myUser.setRdate(user.getRdate().toString());
		return myUser;
	}

}

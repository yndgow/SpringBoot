package kr.co.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.repository.UserRepo;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;

	@Autowired
	private PasswordEncoder passEnCoEncoder;
	
	@Autowired
	private UserRepo repo;
	
	
	public int insertUser(UserVO vo) {
		vo.setPass(passEnCoEncoder.encode(vo.getPass2()));
		int result = dao.insertUser(vo);
		
		return result;
	}; 
	public UserVO selectUser(String uid) {
		return null;
	};
	public void updateUser(UserVO vo) {};
	public void deleteUser(String uid) {};
	
	public int countUser(String uid) {
		return repo.countByUid(uid);
	};
}

package kr.co.voard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.voard.dao.UserDAO;
import kr.co.voard.repository.UserEntity;
import kr.co.voard.repository.UserRepo;
import kr.co.voard.vo.UserVO;


@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;

	@Autowired
	private PasswordEncoder passEnCoEncoder;
	
	@Autowired
	private UserRepo repo;
	
	
	public void insertUser(UserVO vo, HttpServletRequest req) {
		//vo.setPass(passEnCoEncoder.encode(vo.getPass2()));
		//int result = dao.insertUser(vo);
		//return result;
		UserEntity user = new UserEntity();
		user.setUid(vo.getUid());
		
		String newPass = passEnCoEncoder.encode(vo.getPass2());
		user.setPass(newPass);
		
		user.setName(vo.getName());
		user.setNick(vo.getNick());
		user.setGrade(2);
		user.setEmail(vo.getEmail());
		user.setHp(vo.getHp());
		user.setZip(vo.getZip());
		user.setAddr1(vo.getAddr1());
		user.setAddr2(vo.getAddr2());
		user.setRegip(req.getRemoteAddr());
		repo.save(user);
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

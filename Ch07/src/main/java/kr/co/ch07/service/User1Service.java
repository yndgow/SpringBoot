package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User1DAO;
import kr.co.ch07.repository.User1Repo;
import kr.co.ch07.vo.User1VO;

@Service
public class User1Service implements User1DAO{

	// Mybatis
	@Autowired
	User1DAO dao;
	
	// JPA
	@Autowired
	private User1Repo repo;
	
	
	@Override
	public List<User1VO> selectUser1List() {
		List<User1VO> users = null;
		// Mybatis
		// users = dao.selectUser1List();
		
		// JPA
		users = repo.findAll();
		return users;
	}

	@Override
	public User1VO selectUser1vo(String uid) {
		User1VO user = null;
		// Mybatis
		// user = dao.selectUser1vo(uid);
		
		// JPA
		user = repo.findById(uid).get();
		return user;
	}

	@Override
	public void insertUser1vo(User1VO vo) {
		// Mybatis
		//dao.insertUser1vo(vo);
		
		// JPA
		repo.save(vo);
	}

	@Override
	public void updateUser1vo(User1VO vo) {
		// Mybatis
		// dao.updateUser1vo(vo);;
		
		// JPA
		repo.save(vo);
	}

	@Override
	public void deleteUser1vo(String uid) {
		// Mybatis
		// dao.deleteUser1vo(uid);
		
		// JPA
		repo.deleteById(uid);
	}
}

package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.repository.User6Repo;
import kr.co.ch07.vo.User6VO;

@Service
public class User6Service {
	
	@Autowired
	private User6Repo repo;
	
	public List<User6VO> selelctUser6List(){
		return repo.findAll();
	}
	
	public User6VO selectUser6One(String name) {
		return repo.findById(name).get();
	}
	
	public void insertUser6(User6VO vo) {
		repo.save(vo);
	}
	
	public void updateUser6(User6VO vo) {
		repo.save(vo);
	}
	
	public void deleteUser6(String name) {
		repo.deleteById(name);
	}
}

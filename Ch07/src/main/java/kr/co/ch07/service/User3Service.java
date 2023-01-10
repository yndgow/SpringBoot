package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User3DAO;
import kr.co.ch07.vo.User3VO;

@Service
public class User3Service implements User3DAO{

	@Autowired
	User3DAO dao;
	
	@Override
	public List<User3VO> selectUser3List() {
		return dao.selectUser3List();
	}

	@Override
	public User3VO selectUser3One(String uid) {
		return dao.selectUser3One(uid);
	}

	@Override
	public void insertUser3(User3VO vo) {
		dao.insertUser3(vo);
	}

	@Override
	public void updateUser3(User3VO vo) {
		dao.updateUser3(vo);
	}

	@Override
	public void deleteUser3(String uid) {
		dao.deleteUser3(uid);
	}
}

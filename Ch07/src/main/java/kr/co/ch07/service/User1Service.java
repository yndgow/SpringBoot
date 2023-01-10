package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User1DAO;
import kr.co.ch07.vo.User1VO;

@Service
public class User1Service implements User1DAO{

	@Autowired
	User1DAO dao;
	
	@Override
	public List<User1VO> selectUser1List() {
		return dao.selectUser1List();
	}

	@Override
	public User1VO selectUser1vo(String uid) {
		return dao.selectUser1vo(uid);
	}

	@Override
	public void insertUser1vo(User1VO vo) {
		dao.insertUser1vo(vo);
	}

	@Override
	public void updateUser1vo(User1VO vo) {
		dao.updateUser1vo(vo);
	}

	@Override
	public void deleteUser1vo(String uid) {
		dao.deleteUser1vo(uid);
	}
}

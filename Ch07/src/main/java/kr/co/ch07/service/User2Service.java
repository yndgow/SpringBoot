package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User2DAO;
import kr.co.ch07.vo.User2VO;

@Service
public class User2Service implements User2DAO{

	@Autowired
	User2DAO dao;

	@Override
	public List<User2VO> selectUser2List() {
		return dao.selectUser2List();
	}

	@Override
	public User2VO selectUser2vo(String uid) {
		return dao.selectUser2vo(uid);
	}

	@Override
	public void insertUser2vo(User2VO vo) {
		dao.insertUser2vo(vo);
	}

	@Override
	public void updateUser2vo(User2VO vo) {
		dao.updateUser2vo(vo);
	}

	@Override
	public void deleteUser2vo(String uid) {
		dao.deleteUser2vo(uid);
	}

	
	
	
}

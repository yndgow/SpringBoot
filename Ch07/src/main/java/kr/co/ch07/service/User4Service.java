package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User4DAO;
import kr.co.ch07.vo.User4VO;

@Service
public class User4Service implements User4DAO{

	@Autowired
	private User4DAO dao;
	
	
	@Override
	public List<User4VO> selectUser4List() {
		return dao.selectUser4List();
	}

	@Override
	public User4VO selectUser4One(int seq) {
		return dao.selectUser4One(seq);
	}

	@Override
	public void insertUser4(User4VO vo) {
		dao.insertUser4(vo);
	}

	@Override
	public void updateUser4(User4VO vo) {
		dao.updateUser4(vo);
	}

	@Override
	public void deleteUser4(int seq) {
		dao.deleteUser4(seq);
	}

}

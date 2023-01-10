package kr.co.ch07.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.mapper.User1Mapper;
import kr.co.ch07.service.User1Service;
import kr.co.ch07.vo.User1VO;

@Service
public class User1ServiceImpl implements User1Service{

	@Autowired
	User1Mapper mapper;
	
	@Override
	public List<User1VO> selectUser1List() {
		return mapper.selectUser1List();
	}

	@Override
	public User1VO selectUser1vo(String uid) {
		return mapper.selectUser1vo(uid);
	}

	@Override
	public void insertUser1vo(User1VO vo) {
		mapper.insertUser1vo(vo);
	}

	@Override
	public void updateUser1vo(User1VO vo) {
		mapper.updateUser1vo(vo);
	}

	@Override
	public void deleteUser1vo(String uid) {
		mapper.deleteUser1vo(uid);
	}
}

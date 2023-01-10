package kr.co.ch07.service;

import java.util.List;

import kr.co.ch07.vo.User1VO;

public interface User1Service{

	List<User1VO> selectUser1List();
	User1VO selectUser1vo(String uid);
	void insertUser1vo(User1VO vo);
	void updateUser1vo(User1VO vo);
	void deleteUser1vo(String uid);
}

package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User2VO;

@Mapper
@Repository
public interface User2DAO {

	public List<User2VO> selectUser2List();
	public User2VO selectUser2vo(String uid);
	public void insertUser2vo(User2VO vo);
	public void updateUser2vo(User2VO vo);
	public void deleteUser2vo(String uid);
}

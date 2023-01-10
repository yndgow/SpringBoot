package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User4VO;

@Repository
@Mapper
public interface User4DAO {

	public List<User4VO> selectUser4List();
	public User4VO selectUser4One(int seq);
	public void insertUser4(User4VO vo);
	public void updateUser4(User4VO vo);
	public void deleteUser4(int seq);
	
}

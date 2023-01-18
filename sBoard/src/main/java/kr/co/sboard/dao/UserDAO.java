package kr.co.sboard.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.UserVO;

@Mapper
@Repository
public interface UserDAO {
	
	public int insertUser(UserVO vo); 
	public UserVO selectUser(String uid);
	public void updateUser(UserVO vo);
	public void deleteUser(String uid);
}

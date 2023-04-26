package kr.co.voard.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.voard.vo.UserVO;


@Mapper
@Repository
public interface UserDAO {
	
	public int insertUser(UserVO vo); 
	public UserVO selectUser(String uid);
	public void updateUser(UserVO vo);
	public void deleteUser(String uid);
}

package kr.co.ch07.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User1VO;

@Mapper
@Repository
public interface User1Mapper {

	public List<User1VO> selectUser1List();
	public User1VO selectUser1vo(String uid);
	public void insertUser1vo(User1VO vo);
	public void updateUser1vo(User1VO vo);
	public void deleteUser1vo(String uid);
}

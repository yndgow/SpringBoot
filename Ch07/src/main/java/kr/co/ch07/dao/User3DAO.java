package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User3VO;

@Repository
@Mapper
public interface User3DAO {

	public List<User3VO> selectUser3List();
	public User3VO selectUser3One(String uid);
	public void insertUser3(User3VO vo);
	public void updateUser3(User3VO vo);
	public void deleteUser3(String uid);
}

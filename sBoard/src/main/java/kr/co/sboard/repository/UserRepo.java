package kr.co.sboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.sboard.entity.UserVO;

public interface UserRepo extends JpaRepository<UserVO, String>{
	public int countByUid(String uid);
}

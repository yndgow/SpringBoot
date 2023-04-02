package kr.co.logintest.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.logintest.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Long>{
	 Optional<Member> findByEmailAndProvider(String email, String provider);
	 Member findByNickname(String nickname);
}

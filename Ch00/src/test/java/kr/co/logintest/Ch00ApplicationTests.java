package kr.co.logintest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.logintest.entity.Member;
import kr.co.logintest.repo.MemberRepo;

@SpringBootTest
class Ch00ApplicationTests {

	@Autowired
	MemberRepo repo;
	
	
	@Test
	void contextLoads() {
		
	}

}

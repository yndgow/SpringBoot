package kr.co.sboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.sboard.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SBoardApplicationTests {

	@Autowired
	private UserRepo repo;
	
	void contextLoads() {
	}	
	
	@Test
	public void countTest() {
		int result = repo.countByUid("qwqwqw12");
		log.info("result:" + result);
	}
	
	
	
}

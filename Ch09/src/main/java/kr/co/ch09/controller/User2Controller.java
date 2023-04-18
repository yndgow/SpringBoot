package kr.co.ch09.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.entity.User2;
import kr.co.ch09.repository.User2Repo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class User2Controller {

	private final User2Repo repo;
	
	public User2Controller(User2Repo repo) {
		this.repo = repo;
	}
	
	@GetMapping("/user2")
	public List<User2> list() {
		return repo.findAll();
	}
	
	@GetMapping("/user2/{uid}")
	public User2 user(@PathVariable String uid) {
		log.info("getUser");
		return repo.findById(uid).orElseThrow();
	}
	
	@PostMapping("/user2")
	public void register(@RequestBody User2 user) {

		LocalDateTime curTime = LocalDateTime.now();
		user.setRdate(curTime.toString());
		log.info("post : " + user);
		repo.save(user);
	}
	
	@Transactional
	@PutMapping("/user2/{uid}")
	public void modify(@PathVariable String uid,@RequestBody User2 user){
		User2 oriUser = repo.findById(uid).get();
		oriUser.setName(user.getName());
		oriUser.setHp(user.getHp());
		oriUser.setAge(user.getAge());
	}
	
	@DeleteMapping("/user2/{uid}")
	public List<User2> delete(@PathVariable String uid) {
		repo.deleteById(uid);
		return repo.findAll();
	}
	
	
}

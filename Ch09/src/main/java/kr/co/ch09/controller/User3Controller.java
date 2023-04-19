package kr.co.ch09.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.entity.User3;
import kr.co.ch09.repository.User3Repo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class User3Controller {

	private final User3Repo repo;
	
	public User3Controller(User3Repo repo) {
		this.repo = repo;
	}
	
	@GetMapping("/user3")
	public List<User3> list() {
		return repo.findAll();
	}
	
	@GetMapping("/user3/{uid}")
	public User3 user(@PathVariable String uid) {
		log.info("getUser");
		return repo.findById(uid).orElseThrow();
	}
	
	@PostMapping("/user3")
	public void register(@RequestBody User3 user) {
		log.info("post : " + user);
		repo.save(user);
	}
	
	@Transactional
	@PutMapping("/user3/{uid}")
	public void modify(@PathVariable String uid,@RequestBody User3 user){
		User3 oriUser = repo.findById(uid).get();
		oriUser.setName(user.getName());
		oriUser.setHp(user.getHp());
		oriUser.setAge(user.getAge());
	}
	
	@DeleteMapping("/user3/{uid}")
	public List<User3> delete(@PathVariable String uid) {
		repo.deleteById(uid);
		return repo.findAll();
	}
	
	
}

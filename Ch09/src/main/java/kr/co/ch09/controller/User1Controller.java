package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ch09.service.User1Service;
import kr.co.ch09.vo.User1VO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class User1Controller {
	
	@Autowired
	private User1Service service;
	
	@ResponseBody
	@GetMapping("/user1s")
	public List<User1VO> list() {
		log.info("list");
		return service.selectUser1s();
	}
	
	@ResponseBody
	@GetMapping("/user1")
	public User1VO user1(String uid) {
		return service.selectUser1(uid);
	}
	
	@ResponseBody
	@GetMapping("/user1/{uid}")
	public User1VO list(@PathVariable("uid")String uid) {
		log.info("user1/{uid}");
		return service.selectUser1(uid);
	}
	
	
	@ResponseBody
	@PostMapping("/user1")
	public List<User1VO> register(@RequestBody User1VO vo) {
		log.info("vo : " + vo);
		service.insertUser1(vo);
		return service.selectUser1s();
	}
	
	@ResponseBody
	@PutMapping("/user1")
	public List<User1VO> modify(@RequestBody User1VO vo) {
		service.updateUser1(vo);
		return service.selectUser1s();
	}
	
	@ResponseBody
	@DeleteMapping("/user1/{uid}")
	public List<User1VO> delete(@PathVariable("uid") String uid) {
		service.deleteUser1(uid);
		return service.selectUser1s();
	}
}

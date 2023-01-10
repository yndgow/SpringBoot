package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.User3Service;
import kr.co.ch07.vo.User3VO;

@Controller
public class User3Controller {
	
	@Autowired
	private User3Service service;
	
	@GetMapping("/user3/list")
	public String selectUser3List(Model m) {
		m.addAttribute("users",service.selectUser3List());
		return "/user3/list";
	}
	
	@GetMapping("/user3/register")
	public String registerUser3() {
		return "/user3/register";
	}
	@PostMapping("/user3/register")
	public String registerUser3(User3VO vo) {
		service.insertUser3(vo);
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/modify")
	public String modifyUser3(Model m, String uid) {
		m.addAttribute("user",service.selectUser3One(uid));
		return "/user3/modify";
	}
	@PostMapping("/user3/modify")
	public String modifyUser3(User3VO vo) {
		service.updateUser3(vo);
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/delete")
	public String deleteUser3(String uid) {
		service.deleteUser3(uid);
		return "redirect:/user3/list";
	}
	
}

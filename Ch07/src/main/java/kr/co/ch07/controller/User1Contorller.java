package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.User1Service;
import kr.co.ch07.vo.User1VO;

@Controller
public class User1Contorller {
	
	@Autowired
	User1Service service;
	
	@GetMapping("/user1/list")
	public String user1List(Model m) {
		m.addAttribute("users", service.selectUser1List());
		return "/user1/list";
	}
	
	@GetMapping("/user1/register")
	public String user1Register() {
		return "/user1/register";
	}
	@PostMapping("/user1/register")
	public String user1Register(User1VO vo) {
		service.insertUser1vo(vo);
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/modify")
	public String user1Modify(String uid, Model m) {
		m.addAttribute("user", service.selectUser1vo(uid));
		return "/user1/modify";
	}
	@PostMapping("/user1/modify")
	public String user1Modify(User1VO vo) {
		service.updateUser1vo(vo);
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/delete")
	public String user1Delete(String uid) {
		service.deleteUser1vo(uid);
		return "redirect:/user1/list";
	}
}

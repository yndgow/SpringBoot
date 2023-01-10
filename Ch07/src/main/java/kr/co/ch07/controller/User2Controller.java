package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.User2Service;
import kr.co.ch07.vo.User2VO;

@Controller
public class User2Controller {

	@Autowired
	User2Service service;
	
	@GetMapping("/user2/list")
	public String user2List(Model m) {
		m.addAttribute("users", service.selectUser2List());
		return "/user2/list";
	}
	
	@GetMapping("/user2/register")
	public String user2Register() {
		return "/user2/register";
	}
	@PostMapping("/user2/register")
	public String user2Register(User2VO vo) {
		service.insertUser2vo(vo);
		return "redirect:/user2/list";
	}

	@GetMapping("/user2/modify")
	public String user2Modify(String uid, Model m) {
		m.addAttribute("user", service.selectUser2vo(uid));
		return "/user2/modify";
	}
	@PostMapping("/user2/modify")
	public String user2Modify(User2VO vo) {
		service.updateUser2vo(vo);
		return "redirect:/user2/list";
	}
	
	@GetMapping("/user2/delete")
	public String user2Delete(String uid) {
		service.deleteUser2vo(uid);
		return "redirect:/user2/list";
	}
	
}

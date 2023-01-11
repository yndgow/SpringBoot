package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.User5Service;
import kr.co.ch07.vo.User5VO;

@Controller
public class User5Controller {

	@Autowired
	private User5Service service;
	
	@GetMapping("/user5/list")
	public String user5LIst(Model m) {
		m.addAttribute("users", service.selectUser5List()); 
		return "/user5/list";
	}
	
	@GetMapping("/user5/register")
	public String user5Register() {
		return "/user5/register";
	}
	@PostMapping("/user5/register")
	public String user5Register(User5VO vo) {
		service.insertUser5(vo);
		return "redirect:/user5/list";
	}
	
	@GetMapping("/user5/modify")
	public String user5Modify(Model m, String uid) {
		m.addAttribute("user", service.selectUser5One(uid)); 
		return "/user5/modify";
	}
	@PostMapping("/user5/modify")
	public String user5Modify(User5VO vo) {
		service.insertUser5(vo);
		return "redirect:/user5/list";
	}
	
	@GetMapping("/user5/delete")
	public String user5Delete(String uid) {
		service.deleteUser5(uid);
		return "redirect:/user5/list";
	}
	
	
}

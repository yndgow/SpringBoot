package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.User6Service;
import kr.co.ch07.vo.User6VO;

@Controller
public class User6Controller {

	@Autowired
	private User6Service service;
	
	
	@GetMapping("/user6/list")
	public String user6List(Model m) {
		m.addAttribute("users", service.selelctUser6List());
		return "/user6/list";
	}
	
	@GetMapping("/user6/register")
	public String user6Register() {
		return "/user6/register";
	}
	
	@PostMapping("/user6/register")
	public String user6Register(User6VO vo) {
		service.insertUser6(vo);
		return "redirect:/user6/list";
	}
	
	@GetMapping("/user6/modify")
	public String user6Modify(String name, Model m) {
		m.addAttribute("user", service.selectUser6One(name));
		return "/user6/modify";
	}
	
	@PostMapping("/user6/modify")
	public String user6Modify(User6VO vo) {
		service.updateUser6(vo);
		return "redirect:/user6/list";
	}
	
	@GetMapping("/user6/delete")
	public String user6Delete(String name) {
		service.deleteUser6(name);
		return "redirect:/user6/list";
	}
}

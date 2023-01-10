package kr.co.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch07.service.User4Service;
import kr.co.ch07.vo.User4VO;

@Controller
public class User4Controller {

	@Autowired
	private User4Service service;
	
	@GetMapping("/user4/list")
	public String user4List(Model m) {
		m.addAttribute("users", service.selectUser4List());
		return "/user4/list";
	}
	
	@GetMapping("/user4/register")
	public String user4Register() {
		return "/user4/register";
	}
	@PostMapping("/user4/register")
	public String user4Register(User4VO vo)	{
		service.insertUser4(vo);
		return "redirect:/user4/list";
	}
	
	@GetMapping("/user4/modify")
	public String user4Modify(Model m, int seq)	{
		m.addAttribute("user", service.selectUser4One(seq));
		return "/user4/modify";
	}
	@PostMapping("/user4/modify")
	public String user4Modify(User4VO vo) {
		service.updateUser4(vo);
		return "redirect:/user4/list";
	}
	
	@GetMapping("/user4/delete")
	public String user4Delete(int seq) {
		service.deleteUser4(seq);
		return "redirect:/user4/list";
	}
	
	
}

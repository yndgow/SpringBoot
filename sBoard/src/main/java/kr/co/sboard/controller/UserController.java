package kr.co.sboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private TermsService termSer;
	
	@Autowired
	private UserService userSer;

	@GetMapping("user/login")
	public String login() {
		return "user/login";
	}
	@GetMapping("user/register")
	public String register() {
		return "user/register";
	}
	
	@PostMapping("user/register")
	public String register(UserVO vo, HttpServletRequest req) {
		vo.setRegip(req.getRemoteAddr());
		int result = userSer.insertUser(vo);
		return "redirect:/user/login?success=" + result;
	}
	@GetMapping("user/terms")
	public String terms(Model m) {
		List<TermsVO> termsList = termSer.selectTerms();
		m.addAttribute("terms", termsList.get(0).getTerms());
		m.addAttribute("privacy", termsList.get(0).getPrivacy());
		return "user/terms";
	}
	
	@ResponseBody
	@GetMapping("user/uid/{uid}")
	public Map<String, Integer> checkUid(@PathVariable("uid") String uid) {
		int result = userSer.countUser(uid);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
}

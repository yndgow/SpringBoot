package kr.co.ch06.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch06.vo.UserVO;

@Controller
public class MainController {

	@GetMapping(value = {"/", "/index"})
	public String index(Model model)	{
		
		String tit = "Spring Boot!";
		String name = "Thymeleaf!";
		
		UserVO user1 = new UserVO();
		user1.setUid("a101");
		user1.setName("김유신");
		user1.setHp("010-1234-1234");
		user1.setAge(19);
		
		UserVO user2 = new UserVO();
		user2 = null;
		
		List<UserVO> users = new ArrayList<>();
		users.add(user1);
		users.add(new UserVO("a102", "홍길동", "010-1234-0002", 21));
		users.add(new UserVO("a103", "김유신", "010-1234-0003", 31));
		users.add(new UserVO("a104", "강감찬", "010-1234-0004", 32));
		users.add(new UserVO("a105", "이성계", "010-1234-0005", 41));
		
		
		model.addAttribute("tit", tit);
		model.addAttribute("name", name);
		model.addAttribute("user1", user1);
		model.addAttribute("user2", user2);
		model.addAttribute("users", users);
		
		
		return "/index";
	}
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "/layout/layout";
	}
}

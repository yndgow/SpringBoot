package kr.co.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

	@GetMapping("accessDenied")
	public String accessDenied() {
		return "redirect:/user/login?success=403";
	}
}

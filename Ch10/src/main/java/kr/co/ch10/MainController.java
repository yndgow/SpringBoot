package kr.co.ch10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@GetMapping(value = {"/", "/index"})
	public String index() {
		logger.trace("trace 로그...");
		logger.debug("debug 로그...");
		logger.warn("warn 로그...");
		logger.info("info 로그...");
		logger.error("error 로그...");
		
		return "/index";
	}
	
	@GetMapping("/sub/index")
	public String subIndex() {
		return "/sub/index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "/hello";
	}
	@GetMapping("/greeting")
	public String greeting() {
		return "/greeting";
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "/welcome";
	}
}

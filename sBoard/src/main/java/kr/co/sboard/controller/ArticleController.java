package kr.co.sboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.config.ClientUtils;
import kr.co.sboard.config.MyUserDetails;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	

	@GetMapping("/list")
	public String list(Model m) {
		m.addAttribute("articles", articleService.selectArticles());
		return "/list";
	}
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(ArticleVO vo, @AuthenticationPrincipal MyUserDetails user, HttpServletRequest req) {
		vo.setRegip(ClientUtils.getRemoteIP(req));
		//vo.setUid(user.getUser().getUid());
		articleService.insertArticle(vo);
		return "redirect:/list";
	}
}

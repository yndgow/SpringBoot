package kr.co.sboard.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.config.ClientUtils;
import kr.co.sboard.config.MyUserDetails;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	

	@GetMapping("list")
	public String list(Model m, String pg) {
		
		int total = articleService.selectCountTotalArticle();
		
		int currentPage = articleService.getCurrentPage(pg);
		int start = articleService.getLimitStart(currentPage);
		int lastPageNum = articleService.getLastPageNum(total);
		int pageStartNum = articleService.getPageStartNum(total, start);
		int groups[] = articleService.getPageGroup(currentPage, lastPageNum);
		
		m.addAttribute("articles", articleService.selectArticles(start));
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("lastPageNum", lastPageNum);
		m.addAttribute("pageStartNum", pageStartNum);
		m.addAttribute("groups", groups);
		 
		return "list";
	}
	@GetMapping("modify")
	public String modify() {
		return "modify";
	}
	@GetMapping("view")
	public String view(int no, Model m) {
		
		m.addAttribute("article", articleService.selectArticle(no));
		return "view";
	}
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	@PostMapping("write")
	public String write(ArticleVO vo, @AuthenticationPrincipal MyUserDetails user, HttpServletRequest req) {
		vo.setRegip(ClientUtils.getRemoteIP(req));
		//vo.setUid(user.getUser().getUid());
		articleService.insertArticle(vo);
		return "redirect:/list";
	}
	
	@GetMapping("download")
	public ResponseEntity<Resource> download(int fno) throws IOException {
		FileVO vo = articleService.selectFile(fno);
		articleService.updateFileDownload(fno);
		
		ResponseEntity<Resource> responseEntity = null;
		
		responseEntity = articleService.fileDownload(vo);
		
		return responseEntity;
	}
}

package kr.co.voard.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;
import kr.co.voard.entity.ArticleEntity;
import kr.co.voard.service.ArticleService;
import kr.co.voard.vo.ArticleVO;
import kr.co.voard.vo.FileVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("api")
@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping("list")
	public Map<String, Object> list(String pg) {
		
		int total = articleService.selectCountTotalArticle();
		int currentPage = articleService.getCurrentPage(pg);
		int start = articleService.getLimitStart(currentPage);
		int lastPageNum = articleService.getLastPageNum(total);
		int pageStartNum = articleService.getPageStartNum(total, start);
		int groups[] = articleService.getPageGroup(currentPage, lastPageNum);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("articles", articleService.selectArticles(start));
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPageNum", lastPageNum);
		resultMap.put("pageStartNum", pageStartNum);
		resultMap.put("groups", groups);
		 
		return resultMap;
	}
	
	@GetMapping("{no}")
	public ArticleEntity view(@PathVariable int no) {
		
		return articleService.selectArticle(no);
	}
	
	@PostMapping("write")
	public int write(@RequestBody ArticleVO vo, HttpServletRequest req) {
		vo.setRegip(req.getRemoteAddr());
		log.info("vo : " + vo);
		int result = articleService.insertArticle(vo);
		return result;
	}
	
	@GetMapping("download")
	public ResponseEntity<Resource> download(int fno) throws IOException {
		FileVO vo = articleService.selectFile(fno);
		articleService.updateFileDownload(fno);
		
		ResponseEntity<Resource> responseEntity = null;
		
		responseEntity = articleService.fileDownload(vo);
		
		return responseEntity;
	}
	
	@DeleteMapping("{no}")
	public void deleteArticle(@PathVariable int no) {
		articleService.deleteArticle(no);
	}
}

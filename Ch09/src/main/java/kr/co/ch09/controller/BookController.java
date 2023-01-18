package kr.co.ch09.controller;



import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ch09.vo.BooksVO;



@Controller
public class BookController {
	

	@GetMapping("/book/list")
	public String list(String text, Model m) throws JsonMappingException, JsonProcessingException {
		
		// 네이버 open API 헤더 설정
        String clientId = "SotPVU2pyldtxz6WN_l6"; //애플리케이션 클라이언트 아이디
        String clientSecret = "CHXEN_ub4W"; //애플리케이션 클라이언트 시크릿
        
        URI uri = UriComponentsBuilder
        		.fromUriString("https://openapi.naver.com")
        		.path("/v1/search/book.json")
        		.queryParam("query", text)
        		.queryParam("display", 10)
        		.queryParam("start", 1)
        		.queryParam("sort", "sim")
        		.encode()
        		.build()
        		.toUri();
        		
        RequestEntity<Void> req = RequestEntity.get(uri)
					        		.header("X-Naver-Client-Id", clientId)
					        		.header("X-Naver-Client-Secret", clientSecret)
					        		.build();

        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        System.out.println("StatusCode : " + result.getStatusCode());
        
        
        // JSON 파싱
        ObjectMapper obm = new ObjectMapper();
        
		BooksVO books = obm.readValue(result.getBody(), BooksVO.class);
		
		m.addAttribute("books", books.getItems());
        
        return "/book/list";
        
       
	}
}

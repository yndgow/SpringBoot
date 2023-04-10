package kr.co.logintest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.logintest.config.MyUserDetails;
import kr.co.logintest.entity.Member;
import kr.co.logintest.repo.MemberRepo;
import kr.co.logintest.token.NaverResp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Main {
	
	@Autowired
	private MemberRepo repo;
	@Autowired
	private PasswordEncoder encoder;

	//private RestTemplate restTemplate;

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("join")
	public String join(Member member) {
		String nPass = encoder.encode(member.getPass());
		member.setUid(member.getUid());
		member.setPass(nPass);
		member.setLevel(1);
		repo.save(member);
		
		return "redirect:/login";
	}
	
	@GetMapping("list")
	public String list(Authentication authentication, Model model) {
		
		// 로그인 체크
	    if (authentication == null) {
	        return "redirect:/logout";
	    }
	    
	    Object principal = authentication.getPrincipal();
	    Member member = null;
	    
	    // oAuth2 로그인일 경우
	    if (principal instanceof OAuth2User) {
	        OAuth2User oauth2User = (OAuth2User) principal;
	        String provider = (String) oauth2User.getAttributes().get("provider");
	        
	        // oAuth2 제공 회사에 따라 id값 구하기
	        switch (provider) {
	            case "naver":
	                member = repo.findByUid((String) ((Map<String, Object>) oauth2User.getAttributes().get("response")).get("id"));
	                break;
	            case "kakao":
	                member = repo.findByUid((String) oauth2User.getAttributes().get("id").toString());
	                break;
	            case "google":
	                member = repo.findByUid((String) oauth2User.getAttributes().get("sub"));
	                break;
	            default:
	                throw new IllegalArgumentException("Unknown OAuth2 provider: " + provider);
	        }
	        
	    // 일반 로그인일 경우
	    } else if (principal instanceof MyUserDetails) {
	        member = ((MyUserDetails) principal).getUser();
	    } else {
	        throw new IllegalArgumentException("Unknown authentication type: " + principal.getClass().getName());
	    }
	    
	    model.addAttribute("attr", member);
	    return "list";
	}
	
	@ResponseBody
	@GetMapping("ok")
	public String ok(Authentication authentication) {
		OAuth2User auth2User = (OAuth2User)authentication.getPrincipal();
		Map<String, Object> attributes = auth2User.getAttributes();
		return attributes.toString();
	}
	
	
	
/*	@GetMapping("ok")
	public String ok(String code, String state) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://nid.naver.com/oauth2.0/token";
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("code", code);
		requestBody.add("state", state);
		requestBody.add("grant_type", "authorization_code");
		requestBody.add("client_id", "er4btgK9JCf2iWZiQ2bJ");
		requestBody.add("client_secret", "");
		//갱신시 토큰 추가
		requestBody.add("refresh_token", "LxbQaXWvBWjAprripyoBvDPh0qp6Tsl6BJZCvxOeisJ6DWcZvKkqUSwacT2fUcFwooSvZ9Mf1J8U0nKZr1RIbEfsKGNpGqkpYgTNdCbipAfI1ZH8FchpLPGC0JQThisGvxZq");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				url,
				HttpMethod.POST,
				requestEntity,
				String.class);
		
		String responseBody = response.getBody();
		
		ObjectMapper om = new ObjectMapper();
		NaverResp token = null;
		try {
			token = om.readValue(responseBody,NaverResp.class);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		
		RestTemplate restTemplate2 = new RestTemplate();
		String url2 = "https://openapi.naver.com/v1/nid/me";
		HttpHeaders headers2 = new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//String token2 = token.getToken_type() +" "+ token.getAccess_token();
		String token2 = "Bearer " + token.getAccess_token();
		//String token2 = token.getToken_type() +" "+ token.getRefresh_token();
		headers2.set("Authorization", token2);
		HttpEntity<String> requestEntity2 = new HttpEntity<>(headers2);

		ResponseEntity<String> response2 = restTemplate2.exchange(
		        url2,
		        HttpMethod.POST,
		        requestEntity2,
		        String.class);

		String responseBody2 = response2.getBody();
		
		log.info(responseBody2);
		
		return "ok";
	}*/
	
	
	
	
}

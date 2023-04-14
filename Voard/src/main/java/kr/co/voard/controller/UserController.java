package kr.co.voard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.voard.confg.MyUserDetails;
import kr.co.voard.confg.SecurityUserService;
import kr.co.voard.jwt.JWTUtil;
import kr.co.voard.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private SecurityUserService securityUserService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@PostMapping("/user/login")
	public Map<String, Object> login(@RequestBody UserVO vo) {
		log.info("vo : " + vo);
		
		// 사용자 정보 객체 생성
		String uid = vo.getUid();
		String pass = vo.getPass();
		MyUserDetails myUserDetails = securityUserService.loadUserByUsername(uid);
		log.info("login...1");
		
		// Security 인증처리
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUserDetails, pass));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		log.info("login...2");
		
		// JWT 생성
		String token = jwtUtil.generateToken(uid);
		log.info("login...3 : " + token);
		
		// 데이터 출력
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("accessToken", token);
		
		return resultMap;
	}
	
	@GetMapping("/user/logout")
	public void logout() {
		
	}
}

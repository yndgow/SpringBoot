package kr.co.voard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.voard.confg.MyUserDetails;
import kr.co.voard.confg.SecurityUserService;
import kr.co.voard.jwt.JWTUtil;
import kr.co.voard.repository.UserEntity;
import kr.co.voard.service.TermsService;
import kr.co.voard.service.UserService;
import kr.co.voard.vo.TermsVO;
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
	
	@Autowired
	private TermsService termsService;
	
	@Autowired
	private UserService userService;
	
	// 약관 보기
	@GetMapping("/user/terms")
	public List<TermsVO> terms() {
		return termsService.selectTerms();
		
	}
	
	// 가입하기
	@PostMapping("/user/register")
	public void register(@RequestBody UserVO vo, HttpServletRequest req) {
		userService.insertUser(vo, req);
	}
	
	// 아이디 중복확인
	@GetMapping("/user/countUid")
	public int countUid(String uid) {
		return userService.countUser(uid);
	}
	
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
		
		resultMap.put("user", myUserDetails.getUser());
		
		return resultMap;
	}
	
	@GetMapping("/user/auth")
	public Map<String, Object> auth(Authentication authentication) {
		
		MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
		
		// 토큰 유효성 검사
		UserEntity user = myUserDetails.getUser();
		
		// 데이터 출력
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("user", user);
		
		return resultMap;
	}
	
	@GetMapping("/user/logout")
	public void logout() {
		
	}
}

package kr.co.voard.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.voard.confg.MyUserDetails;
import kr.co.voard.confg.SecurityUserService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private SecurityUserService securityUserService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = jwtUtil.resolveToken(request);
		if(token != null && jwtUtil.validateToken(token)) {
			String uid = jwtUtil.getUsernameFromToken(token);
			MyUserDetails myUserDetails = securityUserService.loadUserByUsername(uid);
			
			// Security 인증 처리
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(myUserDetails, null, myUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		
		// 다음 필터로 이동
		filterChain.doFilter(request, response);
	}
}

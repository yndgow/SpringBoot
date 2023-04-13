package kr.co.voard.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private SecurityUserService userService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(basic -> basic.disable()) // UI를 사용하는 기본 Security 비활성
                .csrf(csrf -> csrf.disable()) // 브라우저를 사용하는 환경이 아니기 떄문에 비활성
                .formLogin(formLogin -> formLogin.disable()) // 폼 로그인 비활성
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // JWT 인증을 사용하기 때문에 Session을 끔
//                .addFilterBefore(null, null);
            
		return http.build();
	}
	
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}

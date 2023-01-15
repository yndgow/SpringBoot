package kr.co.ch08.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.ch08.service.AccountService;
import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	DataSource dataSource;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	// 접근권한 설정
        http.authorizeHttpRequests()
        	.antMatchers("/").permitAll()
        	.antMatchers("/admin/**").hasRole("ADMIN")
        	.antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
        	.antMatchers("/member/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER");
        	
		http.formLogin()
			.loginPage("/user2/login")
			.defaultSuccessUrl("/user2/loginSuccess")
			.usernameParameter("uid")
			.passwordParameter("pass");
        
        // 사이트 위조 방지 설정
        http.csrf().disable();
        
        // 로그아웃
        http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
		.logoutSuccessUrl("/user2/login");
        
        // 자동 로그인
        http.rememberMe()
        				.userDetailsService(accountService)
        				.tokenRepository(tokenRepository())
        				.tokenValiditySeconds(60);
        
        return http.build();
    }
    
    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
    @Bean
    public PersistentTokenRepository tokenRepository() {
      // JDBC 기반의 tokenRepository 구현체
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource); // dataSource 주입
        return jdbcTokenRepository;
    }
}

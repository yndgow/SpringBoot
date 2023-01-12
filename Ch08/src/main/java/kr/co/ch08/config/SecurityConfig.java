package kr.co.ch08.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
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
        
        return http.build();
    }
    
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		String encodingId = "noop";
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());
		encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
		encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
		encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
		encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
		encoders.put("SHA-256", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
		encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
		encoders.put("argon2", new Argon2PasswordEncoder());

		return new DelegatingPasswordEncoder(encodingId, encoders);
	}
}
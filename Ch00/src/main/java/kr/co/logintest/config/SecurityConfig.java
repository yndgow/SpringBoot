package kr.co.logintest.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.logintest.service.OAuthService;
import lombok.RequiredArgsConstructor;


@Configuration
public class SecurityConfig {

	@Autowired
	private OAuthService oAuthService;
	
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	// 주소 허용
        http.authorizeHttpRequests((authorize) -> authorize
        		.requestMatchers("/h2-console/**").permitAll()
        		.anyRequest().permitAll()
        		
		        );
        // 로그인 설정
//        http.formLogin(login -> login
//                .loginPage("/login")
//                .defaultSuccessUrl("/list")
//                .failureUrl("/login?success=100")
//                .usernameParameter("uid")
//                .passwordParameter("pass")
//                );

       
        http.csrf(csrf -> csrf
        		.ignoringRequestMatchers("/h2-console/**")
        		.disable());
        
//        http.logout(logout -> logout
//                .invalidateHttpSession(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?success=200")
//                .permitAll()
//                );
        // h2 데이터베이스용
        http.headers().frameOptions().disable();
        
        // oAuth2
        http.oauth2Login()
        .defaultSuccessUrl("/list", true)
        .userInfoEndpoint()
        .userService(oAuthService);

        
        
        return http.build();
    }

//     비밀번호 암호화
    @Bean
    PasswordEncoder passwordEncoder() {
    	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
 
}
package kr.co.ch08.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.ch08.service.User2Service;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		// 접근 권한 설정
//		http.authorizeRequests().antMatchers("/").permitAll();
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER");
//		http.authorizeRequests().antMatchers("/member/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER");
//		
//		// 사이트 위조 방지 설정
//		http.csrf().disable();
//		
//		// 로그인 설정
//		http.formLogin()
//			.loginPage("/user2/login")
//			.defaultSuccessUrl("/user2/loginSuccess")
//			.usernameParameter("uid")
//			.passwordParameter("pass");
//		
//		
//		// 로그아웃 설정
//		http.logout()
//			.invalidateHttpSession(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
//			.logoutSuccessUrl("/user2/login");
//		
//		return http.build();
//	}
//	
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.builder()
//				        		.username("uid")
//				        		.password("pass")
//				        		.roles("ADMIN")
//				        		.build();
//        return new InMemoryUserDetailsManager(user);
//    }
//    @Bean
//    public InMemoryUserDetailsManager managerDetailsService() {
//    	 UserDetails manager = User.builder()
//         		.username("manager")
//         		.password("{noop}1234")
//         		.roles("MANAGER")
//         		.build();
//         return new InMemoryUserDetailsManager(manager);
//    }
//    @Bean
//    public InMemoryUserDetailsManager memberDetailService() {
//        UserDetails member = User.builder()
//        		.username("member")
//        		.password("{noop}1234")
//        		.roles("MEMBER")
//        		.build();
//        return new InMemoryUserDetailsManager(member);
//    }
    

    
	protected void configure(HttpSecurity http) throws Exception {
		// 접근 권한 설정
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER");
		http.authorizeRequests().antMatchers("/member/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER");
		
		// 사이트 위조 방지 설정
		http.csrf().disable();
		
		// 로그인 설정
		http.formLogin()
			.loginPage("/user2/login")
			.defaultSuccessUrl("/user2/loginSuccess")
			.usernameParameter("uid")
			.passwordParameter("pass");
		
		
		// 로그아웃 설정
		http.logout()
			.invalidateHttpSession(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
			.logoutSuccessUrl("/user2/login");
	}
	@Autowired
	private User2Service userService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Sercurity 사용자에 대한 권한 설정
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
    
    	// 로그인 인증 처리 서비스, 암호화 방식 설정
    	auth.userDetailsService(userService).passwordEncoder(new MessageDigestPasswordEncoder("SHA-256"));
	}
	
}

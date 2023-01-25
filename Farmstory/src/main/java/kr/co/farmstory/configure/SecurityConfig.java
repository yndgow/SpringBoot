package kr.co.farmstory.configure;

import lombok.RequiredArgsConstructor;
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

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private DataSource dataSource;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
//                    .requestMatchers("/", "/user/**").permitAll()
//                    .requestMatchers("/article", "/article/*").hasAnyRole("2", "3", "4", "5")
//                    .anyRequest().denyAll()
                      .anyRequest().permitAll()
        );

//        http.formLogin(form -> form
//                .loginPage("/user/login")
//                .defaultSuccessUrl("/article")
//                .failureUrl("/user/login?success=100")
//                .usernameParameter("uid")
//                .passwordParameter("pass")
//        );

        http.csrf().disable();

//        http.logout(logout -> logout
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/login"))
//                .logoutSuccessUrl("/user/login?success=100")
//        );

//        http.rememberMe( rememberMe -> remeberme.userDetailsService(securityUserService)
//                .tokenRepository(tokenRepository())
//                .tokenValiditySeconds(600)
//        );

//        http.exceptionHandling().accessDeniedPage("/user/login?success=101");

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}

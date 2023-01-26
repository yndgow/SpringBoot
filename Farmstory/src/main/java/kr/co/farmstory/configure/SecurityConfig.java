package kr.co.farmstory.configure;

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

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final DataSource dataSource;
    private final SecurityUserService securityUserService;

    public SecurityConfig(DataSource dataSource, SecurityUserService securityUserService) {
        this.dataSource = dataSource;
        this.securityUserService = securityUserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                    .antMatchers("/").permitAll()
                    .antMatchers("/board/*").hasAnyRole("2", "3", "4", "5")
//                    .anyRequest().denyAll()
        );

        http.formLogin(form -> form
                .loginPage("/user/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/user/login?success=103")
                .usernameParameter("uid")
                .passwordParameter("pass")
        );

        http.csrf().disable();

        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login?success=100")
        );

        http.rememberMe( (rememberMe) -> rememberMe
                .userDetailsService(securityUserService)
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(600)
        );

        http.exceptionHandling().accessDeniedPage("/user/login?success=101");
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

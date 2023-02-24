package com.yechy.dailypic.config;

import com.yechy.dailypic.handler.NavAuthenticationFailureHandler;
import com.yechy.dailypic.security.DpUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {
    private static final String[] BY_PASS_URLS = {"/accounts", "/accountList.html", "/hello", "/user/register", "/*/*.css", "/favicon.ico",
            "/login.html", "/login", "/user/login"};

    private static final String[] ANONYMOUS_URLS = {"/register.html"};

    @Autowired
    private DataSource dataSource;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(BY_PASS_URLS).permitAll()
                            .requestMatchers(ANONYMOUS_URLS).anonymous()
                            .anyRequest().authenticated();
                })
                // 自定义登录页面
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .loginPage("/login.html")
                                .loginProcessingUrl("/user/login")
                                .defaultSuccessUrl("/index", true)
                                .failureHandler(new NavAuthenticationFailureHandler())
                )
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600)
                .and()
                .sessionManagement()
                .and()
                // 自定义登出页面
//                .logout()
//                .logoutUrl("/user/logout")
////                .logoutSuccessUrl("/login.html")
//                .and()

                .csrf().disable()
                .build();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new DpUserDetailsService();
    }


}

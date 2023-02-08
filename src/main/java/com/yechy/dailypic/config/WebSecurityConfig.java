package com.yechy.dailypic.config;

import com.yechy.dailypic.security.DpUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {

    private static final String[] BY_PASS_URLS = {"/accounts", "/accountList.html", "/login","/register.html", "/hello", "/user/register"};

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(BY_PASS_URLS).permitAll()
                            .anyRequest().authenticated();
                })
                // 自定义登录页面
                .formLogin()
//                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/index", true)
                .permitAll()
                .and()
                // 自定义登出页面
                .logout()
                .logoutUrl("/user/logout")
//                .logoutSuccessUrl("/login.html")
                .and()
                // 访问路径权限设置
                .csrf().disable()
                .build();
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
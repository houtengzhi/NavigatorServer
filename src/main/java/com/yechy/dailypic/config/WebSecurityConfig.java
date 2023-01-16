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

    private static final String[] BY_PASS_URLS = {"/hello"};

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
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
                .logoutSuccessUrl("/login.html")
                .and()
                // 访问路径权限设置
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(BY_PASS_URLS).permitAll()
                            .anyRequest().authenticated();
                })
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }

    @Bean
    UserDetailsService userDetailsService() {
        return new DpUserDetailsService();
    }

//    @Bean
//    UserDetailsManager userDetailsManager(DataSource source) {
//        UserDetails userDetails = User.builder()
//                .username("")
//                .password("")
//                .roles("")
//                .build();
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(source);
//        manager.createUser(userDetails);
//        return manager;
//    }
}

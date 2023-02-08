package com.yechy.dailypic.security;

import com.yechy.dailypic.entity.Account;
import com.yechy.dailypic.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DpUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(DpUserDetailsService.class);

    @Autowired
    private IAccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("loadUserByUsername(), username={}", username);
        Account account = accountService.queryAccountByName(username);
        return new User("cloud", "123456", true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

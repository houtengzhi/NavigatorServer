package com.yechy.dailypic.controller;

import com.yechy.dailypic.entity.Account;
import com.yechy.dailypic.entity.UserProfile;
import com.yechy.dailypic.service.IAccountService;
import com.yechy.dailypic.util.ResponseResult;
import com.yechy.dailypic.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private IAccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Account getAccount() {
        Account account = new Account();
        account.setUserName("Cloud");
        account.setAccountId("jdasjad");
        UserProfile user = getUser();
        account.setUserProfile(user);
        return account;
    }

    @ResponseBody
    @PostMapping(value = "/user/register")
    public Account registerAccount(@RequestParam("username") String userName, @RequestParam("password") String pwd) {
        Account existedAccount = accountService.queryAccountByName(userName);
        if (existedAccount != null) {
            logger.info("Account already exist");
            return existedAccount;
        }
        Account account = new Account(userName, String.valueOf(System.currentTimeMillis()), pwd, null);
        int id = accountService.addAccount(account);
        logger.debug("Create account success");
        account.setId(id);
        return account;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserProfile getUser() {
        UserProfile user = new UserProfile();
        user.setUserName("Cloud");
        user.setAge(30);
        return user;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String getAccountList(Model m) {
        List<Account> list = new ArrayList<>();
        list.add(new Account("KangKang", "00001", "xxx", "17777777777"));
        list.add(new Account("Mike", "00002", "e10adc3949ba59abbe56e", "13444444444"));
        list.add(new Account("Jane","00003","e10adc3949ba59abbe56e","18666666666"));
        list.add(new Account("Maria", "0004", "e10adc3949ba59abbe56e", "19999999999"));
        m.addAttribute("accountList",list);
        logger.debug("getAccountList: account size={}", list.size());
        return "accountList";
    }
}

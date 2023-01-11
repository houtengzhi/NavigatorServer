package com.yechy.dailypic.controller;

import com.yechy.dailypic.entity.Account;
import com.yechy.dailypic.entity.DpUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @ResponseBody
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Account getAccount() {
        Account account = new Account();
        account.setName("Cloud");
        account.setAccountId("jdasjad");
        DpUser user = getUser();
        account.setUser(user);
        return account;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public DpUser getUser() {
        DpUser user = new DpUser();
        user.setUserName("Cloud");
        user.setAge(30);
        return user;
    }

    @RequestMapping(value = "/accountList", method = RequestMethod.GET)
    public String getAccountList(Model m) {
        List<Account> list = new ArrayList<Account>();
        list.add(new Account("KangKang", "00001", "xxx", "17777777777"));
        list.add(new Account("Mike", "00002", "e10adc3949ba59abbe56e", "13444444444"));
        list.add(new Account("Jane","00003","e10adc3949ba59abbe56e","18666666666"));
        list.add(new Account("Maria", "0004", "e10adc3949ba59abbe56e", "19999999999"));
        m.addAttribute("accountList",list);
        return "accountList";
    }
}

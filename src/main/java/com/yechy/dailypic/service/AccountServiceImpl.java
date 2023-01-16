package com.yechy.dailypic.service;

import com.yechy.dailypic.entity.Account;
import com.yechy.dailypic.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int addAccount(Account account) {
        return accountMapper.addAccount(account);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccount(Account account) {
        return 0;
    }

    @Override
    public Account queryAccount(String userName) {
        return null;
    }
}

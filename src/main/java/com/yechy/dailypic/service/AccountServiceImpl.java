package com.yechy.dailypic.service;

import com.yechy.dailypic.entity.Account;
import com.yechy.dailypic.mapper.AccountMapper;
import com.yechy.dailypic.mapper.BookmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{
    @Autowired
    private AccountMapper accountMapper;

    private BookmarkMapper bookmarkMapper;

    @Override
    public void createTable() {
        accountMapper.createTable("account");
    }

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
    public Account queryAccountByName(String userName) {
        return new Account("cloud", "id_123456", "123456", null);
//        return accountMapper.queryAccountByName(userName);
    }
}

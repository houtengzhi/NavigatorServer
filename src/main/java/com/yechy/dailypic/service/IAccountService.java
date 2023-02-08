package com.yechy.dailypic.service;

import com.yechy.dailypic.entity.Account;

public interface IAccountService {
    void createTable();
    int addAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Account account);
    Account queryAccountByName(String userName);
}

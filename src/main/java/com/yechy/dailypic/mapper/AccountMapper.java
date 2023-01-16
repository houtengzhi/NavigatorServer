package com.yechy.dailypic.mapper;

import com.yechy.dailypic.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    int addAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Account account);
    Account queryAccount(Account account);
    List<Account> queryAccountList();
    Account queryAccount(String userName, String pwd);
}

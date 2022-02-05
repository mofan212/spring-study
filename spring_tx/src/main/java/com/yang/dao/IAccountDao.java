package com.yang.dao;

import com.yang.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    // 根据id查询用户
    Account findAccountById(Integer accountId);

    // 根据名称查询用户
    Account findAccountByName(String accountName);

    // 更新用户
    void updateAccount(Account account);
}

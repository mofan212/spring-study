package com.yang.service;

import com.yang.domain.Account;

/**
 * @author 默烦 2020/10/21
 */
public interface AccountService {

    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转出金额
     */
    void transfer(String sourceName, String targetName, Float money);
}

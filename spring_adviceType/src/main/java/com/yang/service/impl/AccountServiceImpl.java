package com.yang.service.impl;

import com.yang.service.AccountService;

/**
 * @author 默烦 2020/10/21
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
//        int i = 1 / 0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新 " + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}

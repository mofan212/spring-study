package com.yang.service.impl;

import com.yang.service.IAccountService;

/**
 * @author 默烦 2020/10/15
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了...");
    }

    public void init() {
        System.out.println("对象初始化了...");
    }

    public void destroy() {
        System.out.println("对象销毁了...");
    }
}

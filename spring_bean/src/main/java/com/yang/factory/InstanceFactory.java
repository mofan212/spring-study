package com.yang.factory;

import com.yang.service.IAccountService;
import com.yang.service.impl.AccountServiceImpl;

/**
 * @author 默烦 2020/10/19
 *
 * 模拟一个工厂类（工厂创建的类可能是存在 jar 包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {
    public IAccountService getAccountService() {
        // 假设 AccountServiceImpl 类是存在 jar 包中的
        return new AccountServiceImpl();
    }
}

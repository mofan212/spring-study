package com.yang.service.impl;

import com.yang.dao.IAccountDao;
import com.yang.dao.impl.AccountDaoImpl;
import com.yang.service.IAccountService;

/**
 * @author 默烦 2020/10/15
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}

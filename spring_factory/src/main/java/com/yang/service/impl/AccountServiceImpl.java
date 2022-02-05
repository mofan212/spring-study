package com.yang.service.impl;

import com.yang.dao.IAccountDao;
import com.yang.dao.impl.AccountDaoImpl;
import com.yang.factory.BeanFactory;
import com.yang.service.IAccountService;

/**
 * @author 默烦 2020/10/15
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = ((IAccountDao) BeanFactory.getBean("accountDao"));

    private int i = 1;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}

package com.yang.dao.impl;

import com.yang.dao.IAccountDao;
import com.yang.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

// 继承 JdbcDaoSupport，使用基于XML的配置时可以去除多余代码
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}

package com.yang.test;

import com.yang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 默烦 2020/10/21
 * 测试 AOP 的配置
 */
public class AOPTest {
    public static void main(String[] args) {
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 获取对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        // 执行方法
        as.saveAccount();
    }
}

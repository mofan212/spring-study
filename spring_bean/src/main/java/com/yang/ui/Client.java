package com.yang.ui;

import com.yang.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 默烦 2020/10/15
 *
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /*
    * 获取 Spring 的 IoC 容器，并根据 id 获取对象
    * */
    public static void main(String[] args) {
        // 1. 获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据 id 获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();

        // 手动关闭容器
        ac.close();
    }
}

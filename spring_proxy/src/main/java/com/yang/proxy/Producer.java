package com.yang.proxy;

/**
 * @author 默烦 2020/10/20
 *
 * 生产厂家
 */
public class Producer implements IProducer{

    public void saleProduct(float money) {
        System.out.println("销售商品，并拿到钱 " + money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱 " + money);
    }
}

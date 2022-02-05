package com.yang.proxy;

/**
 * @author 默烦 2020/10/20
 *
 * 对生产厂家要求的接口
 */
public interface IProducer {

    void saleProduct(float money);

    void afterService(float money);
}

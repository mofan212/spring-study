package indi.mofan.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author mofan
 * @date 2022/1/3 16:42
 */
public class Product implements InitializingBean, DisposableBean {
    private String name;

    public void setName(String name) {
        System.out.println("Product.setName");
        this.name = name;
    }

    public Product() {
        System.out.println("Product.Product");
    }


    public void myInitMethod() {
        System.out.println("Product.myInitMethod");
    }

    public void myDestroyMethod() {
        System.out.println("Product.myDestroyMethod");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }
}

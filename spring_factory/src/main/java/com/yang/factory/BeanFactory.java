package com.yang.factory;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 默烦 2020/10/15
 * <p>
 * 一个创建 Bean 对象的工厂
 * Bean:在计算机英语中，Bean 有可重用组件的含义
 * JavaBean:用 Java 语言创建的可重用组件。因此，JavaBean并不等于实体类，它的范围大于实体类
 * <p>
 * 因此，BeanFactory 就是创建service和dao对象的工厂
 * <p>
 * 如何创建？
 * 1. 需要一个配置文件来配置我们的service和dao
 * 配置的内容：唯一标识符 = 全限定类名 （类似于 key = value）
 * 2. 通过反射读取配置文件中的配置内容，反射创建对象
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    // 定义一个 Properties 对象
    private static Properties properties;
    // 定义一个 Map，用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;

    // 使用静态代码块为 Properties 对象赋值
    static {
        try {
            // 实例化对象
            properties = new Properties();
            // 获取 Properties 文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            // 实例化容器
            beans = new HashMap<>();
            // 取出配置文件中所有的 key
            Enumeration<Object> keys = properties.keys();
            // 遍历枚举
            while (keys.hasMoreElements()) {
                // 取出每个 key
                String key = keys.nextElement().toString();
                // 根据 key 获取 value
                String beanPath = properties.getProperty(key);
                // 反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                // 把 key 和 value 存入容器
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化 properties 失败");
        }
    }

    // 根据 bean 的名称获取对象
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    // 根据Bean的名称获取Bean对象
//    public static Object getBean(String beanName) {
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanName);
////            System.out.println(beanPath);
//            // 每次都会调用默认构造函数创建对象
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return bean;
//    }
}

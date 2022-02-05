package com.yang.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 默烦 2020/10/21
 * <p>
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    // 前置通知
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了...");
    }

    // 后置通知
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了...");
    }

    // 异常通知
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了...");
    }

    // 最终通知
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了...");
    }

    /*
     * 环绕通知
     * 问题：当我们配置了环绕通知之后，切入点方法没有执行，但通知方法执行了
     * 分析：
     *   通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点调用，而我们的代码没有
     * 解决：
     *  Spring 框架为我们提供了一个接口：ProceedingJoinPoint，该接口有一个proceed()方法，此方法就相当于明确调用切入点方法
     *   该接口可以作为环绕通知的方法参数，在程序执行时，Spring 框架会为我们提供该接口的实现类供我们使用。
     * Spring 中的环绕通知：它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     * */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue;
        try {
            Object[] args = pjp.getArgs(); // 得到方法执行所需的参数

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...前置");

            rtValue = pjp.proceed(args); // 明确调用业务层（切入点）方法

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...后置");
            return rtValue;
        } catch (Throwable throwable) { // 不能抛出 Exception
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...异常");
           throw new RuntimeException(throwable);
        } finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...最终");
        }
    }
}
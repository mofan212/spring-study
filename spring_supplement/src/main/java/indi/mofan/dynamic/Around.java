package indi.mofan.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author mofan
 * @date 2022/1/17 22:07
 */
public class Around implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("----- around -----");
        Object proceed = methodInvocation.proceed();
        return proceed;
    }
}

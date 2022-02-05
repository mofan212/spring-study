package indi.mofan.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author mofan
 * @date 2022/1/16 22:05
 */
public class Before implements MethodBeforeAdvice {
    /**
     * 把运行在原始方法之前运行的额外功能写在 before 方法内
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("----- method before advice log -----");
    }
}

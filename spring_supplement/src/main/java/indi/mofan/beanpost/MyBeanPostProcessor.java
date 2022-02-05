package indi.mofan.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author mofan
 * @date 2022/1/16 21:17
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setName("Mobile Phone");
        }
        return bean;
    }
}

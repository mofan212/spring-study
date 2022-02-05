package indi.mofan;

import indi.mofan.beanpost.Category;
import indi.mofan.domain.Person;
import indi.mofan.domain.User;
import indi.mofan.life.Product;
import indi.mofan.proxy.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mofan
 * @date 2021/10/11 23:22
 */
public class SpringBeanTest {
    @Test
    public void testApplicationContestMethod() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p1 = (Person) applicationContext.getBean("person");
        System.out.println(p1);

        Person p2 = applicationContext.getBean("person", Person.class);
        System.out.println(p2);

        // 此时配置文件中只能有一个 <bean> 标签的 class 是 Person 类型
        Person p3 = applicationContext.getBean(Person.class);
        System.out.println(p3);

        // 获取 Spring 配置文件中所有 <bean> 标签的 id 值
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        // 根据类型获得 Spring 配置文件中对应的 id 值
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNamesForType) {
            System.out.println("beanName = " + beanName);
        }

        // 用于判断 Spring 配置文件中是否存在指定 id 值的 Bean
        boolean containPerson = applicationContext.containsBeanDefinition("person");
        System.out.println("id 为 person 的 Bean 是存在的？" + containPerson);
        boolean notContainPeople = applicationContext.containsBeanDefinition("people");
        System.out.println("id 为 people 的 Bean 是存在的？" + notContainPeople);

        // 用于判断 Spring 配置文件中是否存在指定 id 值的 Bean
        containPerson = applicationContext.containsBean("person");
        System.out.println("id 为 person 的 Bean 是存在的？" + containPerson);
        notContainPeople = applicationContext.containsBean("people");
        System.out.println("id 为 people 的 Bean 是存在的？" + notContainPeople);
    }

    @Test
    public void testName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p1 = (Person) applicationContext.getBean("p");
        System.out.println(p1);
    }

    @Test
    public void testNameSpaceP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        Assert.assertEquals("mofan", user.getUsername());
        Assert.assertEquals("yang", user.getPerson().getName());
    }

    @Test
    public void testObjectLife() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = applicationContext.getBean("product", Product.class);
        applicationContext.close();
    }

    @Test
    public void testConverter() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        indi.mofan.converter.Person p1 = applicationContext.getBean("p1", indi.mofan.converter.Person.class);
        System.out.println(p1);
    }

    @Test
    public void testBeanPostProcessor() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Category category = applicationContext.getBean("c", Category.class);
        Assert.assertEquals("Mobile Phone", category.getName());
    }

    @Test
    public void testSpringDynamicProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        /*
         * Spring 工厂通过原始对象的 id 值得到的是代理对象
         * 获得代理对象后，可以通过声明接口类型，进行对象的存储
         */
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.login("mofan", "123456");
        userService.register(new indi.mofan.proxy.User());
    }
}

package kasei.spring.ioc.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class XmlTest {

    @Test
    public void test() {
        //1. 采用 classpath：springioc.xml 文件创建 Spring 的IOC 容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("a01xml/b01beanConfigure/xmlBeanConfigure.xml");
    }
}
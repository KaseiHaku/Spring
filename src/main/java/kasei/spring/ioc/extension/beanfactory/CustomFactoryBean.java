package kasei.spring.ioc.extension.beanfactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

// @Component  // 注释掉，这个会替换 spring ioc 默认的 BeanFactory
public class CustomFactoryBean implements FactoryBean {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}

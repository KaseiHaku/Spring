package kasei.spring.ioc.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AnnotationTest {

    @Test
    public void test() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("annotationBeanConfigure.xml");

        Component component = (Component) ioc.getBean("myComponent");
        component.run();
        Controller controller = (Controller) ioc.getBean("b04Controller");
        Service service = (Service) ioc.getBean("b03Service");
        Repository repository = (Repository) ioc.getBean("b04Repository");
    }
}
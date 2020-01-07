package kasei.spring;

import kasei.spring.ioc.annotationbase.ComponentBean;
import kasei.spring.ioc.config.MasterSpringConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MasterSpringConfig.class})
@DisplayName("spring tests")
public class SpringTests {




    @BeforeEach
    void beforeEach(){
        System.out.println("\n\nJUnit Test Start ===================");
    }

    @AfterEach
    void afterEach(){
        System.out.println("JUnit Test End ===================\n\n");
    }


    @Autowired
    private ComponentBean componentBean;

    @Test
    void test(){
        System.out.println(componentBean.getName());
    }
}

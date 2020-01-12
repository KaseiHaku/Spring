package kasei.spring;

import kasei.spring.ioc.annotationbase.ComponentBean;
import kasei.spring.ioc.config.MasterSpringConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.File;


// jupiter 相关的 spring 注解
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = {MasterSpringConfig.class})
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
        throw new RuntimeException("1324");
    }
}

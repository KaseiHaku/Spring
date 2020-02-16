package kasei.spring;

import kasei.spring.binding.bean.convert.Color;
import kasei.spring.binding.converter.String2ColorConverter;
import kasei.spring.ioc.annotationbase.ComponentBean;
import kasei.spring.ioc.config.MasterConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


// jupiter 相关的 spring 注解
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = {MasterConfig.class})
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
        String2ColorConverter converter = new String2ColorConverter();
        Color red = converter.convert("RED");
        System.out.println(red.getCurrentVal());
    }
}

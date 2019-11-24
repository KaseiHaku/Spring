package kasei.spring.ioc.config;

import kasei.spring.ioc.javabase.JavaBaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration // 使用 CGLIB 创建一个子类来作为实际运行类，添加额外代码，来进行 spring 框架的定制
@Import({SlaveSpringConfig.class}) // 导入其他配置类
// @ImportResource  // 导入 xml 格式的配置文件
@PropertySource("classpath:mysql.properties")
public class MasterSpringConfig {


    @Autowired
    Environment env;  // 该接口保存者所有当前 IOC 容器的配置项，比如 profile 和 properties 配置文件

    // @Bean 注解默认使用方法名作为 IOC 容器中的 Bean ID
    @Bean(name = {"initialBean", "javaBaseBean"}, initMethod = "", destroyMethod = "")
    @Scope("prototype")
    @Description("Provides a basic example of a bean")
    public JavaBaseBean initialBean(){
        return new JavaBaseBean();
    }

}

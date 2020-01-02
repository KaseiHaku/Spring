package kasei.spring.ioc.config;

import kasei.spring.ioc.javabase.JavaBaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration // 使用 CGLIB 创建一个子类来作为实际运行类，添加额外代码，来进行 spring 框架的定制
@Import({SlaveSpringConfig.class}) // 导入其他配置类
// @ImportResource  // 导入 xml 格式的配置文件
@PropertySource("classpath:mysql.properties")
@EnableAsync        // 开启线程池
@EnableScheduling   // 开启定时任务
/** 开启 AOP
 * 使 AspectJ 注解起作用:自动为匹配的类生成代理对象
 * proxy-target-class="true": 表示强制采用 CGLIB 工具生成代理类，
 * CGLIB 采用继承的方式生成代理类，而默认的方式是采用 实现接口动态代理的方式
 * */
@EnableAspectJAutoProxy(proxyTargetClass = false)
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
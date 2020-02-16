package kasei.spring.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = {"kasei.spring"})
@Profile("development") // 表示什么执行环境下，该配置才生效
public class SlaveConfig {



}

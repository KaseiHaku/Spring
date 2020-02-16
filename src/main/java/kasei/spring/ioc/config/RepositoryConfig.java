package kasei.spring.ioc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement  // 开启声明式事务
public class RepositoryConfig {

    @Autowired
    private Environment env;  // 该接口保存者所有当前 IOC 容器的配置项，比如 profile 和 properties 配置文件

    @Bean(name="dataSource") // Spring 持久层配置，至少要有一个 DataSource
    public DataSource dataSource(){

        String prefix = "h2.";
        Properties properties = new Properties();
        properties.put("username", env.getProperty(prefix + "username"));
        properties.put("password", env.getProperty(prefix + "password"));
        properties.put("driverClassName", env.getProperty(prefix + "driverClassName"));
        properties.put("jdbcUrl", env.getProperty(prefix + "jdbcUrl"));
        HikariConfig hikariConfig = new HikariConfig(properties);
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource());
        return jdbcTemplate;
    }

    @Bean("transactionManager") // 关系型数据库的事务管理器
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
        return dataSourceTransactionManager;
    }



}

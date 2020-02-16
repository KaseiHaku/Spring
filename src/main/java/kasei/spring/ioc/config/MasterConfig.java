package kasei.spring.ioc.config;

import kasei.spring.binding.bean.convert.Telephone;
import kasei.spring.binding.converter.BigDecimalFormatter;
import kasei.spring.binding.converter.CustomPropertyEditorRegistrar;
import kasei.spring.binding.converter.String2ColorConverter;
import kasei.spring.binding.converter.TelephonePropertyEditor;
import kasei.spring.ioc.javabase.JavaBaseBean;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.beans.PropertyEditor;
import java.util.*;

@Configuration // 使用 CGLIB 创建一个子类来作为实际运行类，添加额外代码，来进行 spring 框架的定制
@Import({SlaveConfig.class, RepositoryConfig.class, MailConfig.class, TemplateConfig.class}) // 导入其他配置类
@ImportResource(locations = {"classpath:applicationContext.xml"})  // 导入 xml 格式的配置文件
@PropertySource({"classpath:contextInitParam.properties", "classpath:h2.properties"}) // 导入 .properties 文件
@EnableAsync        // 开启线程池
@EnableScheduling   // 开启定时任务
/** 开启 AOP
 * 使 AspectJ 注解起作用:自动为匹配的类生成代理对象
 * proxy-target-class="true": 表示强制采用 CGLIB 工具生成代理类，
 * CGLIB 采用继承的方式生成代理类，而默认的方式是采用 实现接口动态代理的方式
 * */
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class MasterConfig {


    @Autowired
    Environment env;  // 该接口保存者所有当前 IOC 容器的配置项，比如 profile 和 properties 配置文件

    // @Bean 注解默认使用方法名作为 IOC 容器中的 Bean ID
    @Bean(name = {"initialBean", "javaBaseBean"}, initMethod = "", destroyMethod = "")
    @Scope("prototype")
    @Description("Provides a basic example of a bean")
    public JavaBaseBean initialBean(){
        return new JavaBaseBean();
    }



    /** TODO 注册自定义类型转换器 */
    @Bean
    public CustomEditorConfigurer customEditorConfigurer(){
        /* TODO 该 Bean 主要用于注册 PropertyEditor 类型的转换器 */

        /* 单个注册自定义转换器 */
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
        map.put(Telephone.class, TelephonePropertyEditor.class); // 注释掉，查看 PersonEntity 是否能自动转换
        // 该方法主要用于配置单个的自定义 PropertyEditor
        customEditorConfigurer.setCustomEditors(map);


        /* 注册一个自定义类型转换器注册人：主要用于批量注册 PropertyEditor 到不同的场景中 */
        CustomPropertyEditorRegistrar customPropertyEditorRegistrar = new CustomPropertyEditorRegistrar();
        // customEditorConfigurer.setCustomEditors(); // PropertyEditorRegistrar 使用该方法将一个 PropertyEditor 添加到当前组
        PropertyEditorRegistrar[] PropertyEditorRegistrars = {
                customPropertyEditorRegistrar
        };
        // 该方法主要用于配置一组自定义的 PropertyEditor，一个 PropertyEditorRegistrar 代表一组 PropertyEditor
        customEditorConfigurer.setPropertyEditorRegistrars(PropertyEditorRegistrars);
        return customEditorConfigurer;
    }
    @Bean // 该 Bean id 固定
    public FormattingConversionServiceFactoryBean conversionService(){
        /* TODO 该 FactoryBean 只能注册 Converter 类型的转换器 */
        // ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();

        /* TODO 该 FactoryBean 可以注册 Converter 和 Formatter 类型的转换器 */
        FormattingConversionServiceFactoryBean factoryBean = new FormattingConversionServiceFactoryBean();

        Set<Object> converters = new HashSet<>();
        converters.add(new String2ColorConverter());
        factoryBean.setConverters(converters);

        Set<Object> formatters = new HashSet<>();
        formatters.add(new BigDecimalFormatter());
        factoryBean.setFormatters(formatters);


        return factoryBean;
    }


    /** TODO 配置 Spring validator */
    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        return factoryBean;
    }
    /** TODO 开启 spring 方法级校验 */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }

}

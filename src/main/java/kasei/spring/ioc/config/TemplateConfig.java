package kasei.spring.ioc.config;


import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Configuration
public class TemplateConfig {


    @Bean
    public freemarker.template.Configuration freeMarkerConfiguration() throws IOException, TemplateException {

        FreeMarkerConfigurationFactoryBean configurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        configurationFactoryBean.setTemplateLoaderPaths("classpath:template/mail");
        configurationFactoryBean.setDefaultEncoding("utf-8");
        freemarker.template.Configuration configuration = configurationFactoryBean.createConfiguration();
        // configuration.setDirectoryForTemplateLoading(new File("./src/main/resources/template/mail"));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(false);

        return configuration;
    }
}

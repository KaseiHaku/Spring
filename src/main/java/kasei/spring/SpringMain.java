package kasei.spring;

import kasei.spring.ioc.config.MasterSpringConfig;
import kasei.spring.ioc.di.*;
import kasei.spring.ioc.AnnotationBase;
import kasei.spring.ioc.annotationbase.ComponentBean;
import kasei.spring.ioc.annotationbase.ControllerBean;
import kasei.spring.ioc.annotationbase.RepositoryBean;
import kasei.spring.ioc.annotationbase.ServiceBean;
import kasei.spring.ioc.javabase.JavaBaseBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Set;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MasterSpringConfig.class);





        // todo JavaBase Inversion of Control Demo
        System.out.println("\n================ todo JavaBase Inversion of Control Demo");
        JavaBaseBean initialBean = context.getBean("initialBean", JavaBaseBean.class);
        System.out.println(initialBean.getName());

        // todo AnnotationBase Inversion of Control Demo
        System.out.println("\n================ todo AnnotationBase Inversion of Control Demo");
        ControllerBean controllerBean = context.getBean("controllerBean", ControllerBean.class);
        System.out.println(controllerBean.getName());

        ServiceBean serviceBean = context.getBean("serviceBean", ServiceBean.class);
        System.out.println(serviceBean.getName());

        RepositoryBean repositoryBean = context.getBean("repositoryBean", RepositoryBean.class);
        System.out.println(repositoryBean.getName());

        ComponentBean customNamedComponentBean = context.getBean("customNamedComponentBean", ComponentBean.class);
        System.out.println(customNamedComponentBean.getName());

        // todo Dependency Injection Demo
        System.out.println("\n================ todo Dependency Injection Demo");
        ControllerBean autowiredDi = context.getBean("autowiredDi", AutowiredDi.class).getControllerBean();
        System.out.println("autowired di: " + autowiredDi.getName());

        Set<AnnotationBase> autowiredDiSet = context.getBean("autowiredDi", AutowiredDi.class).getAnnotationBaseSet();
        autowiredDiSet.forEach( x -> System.out.println("autowired di set: " + x.getName()));

        Map<String, AnnotationBase> qualifierDiSet = context.getBean("qualifierDi", QualifierDi.class).getAnnotationBaseMap();
        qualifierDiSet.forEach( (k,v) -> System.out.println("autowired qualifier di map: " + k + " = " + v.getName()));


        NullableDi nullableDi = context.getBean("nullableDi", NullableDi.class);
        System.out.println("autowired qualifier di nullable: " + (nullableDi.getNullableBean() ==  null));


        PrimaryDi primaryDi = context.getBean("primaryDi", PrimaryDi.class);
        System.out.println("autowired qualifier di primary: " + primaryDi.getAnnotationBase().getName());

        ValueDi valueDi = context.getBean("valueDi", ValueDi.class);
        System.out.println("autowired qualifier di value: " + valueDi.getConfigFileValue());


        ((AnnotationConfigApplicationContext)context).stop();
        ((AnnotationConfigApplicationContext)context).close();
    }
}

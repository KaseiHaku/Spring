package kasei.spring;

import kasei.spring.aop.Obj;
import kasei.spring.aop.ObjImp;
import kasei.spring.aop.ObjProxy;
import kasei.spring.ioc.config.MasterSpringConfig;
import kasei.spring.ioc.di.*;
import kasei.spring.ioc.AnnotationBase;
import kasei.spring.ioc.annotationbase.ComponentBean;
import kasei.spring.ioc.annotationbase.ControllerBean;
import kasei.spring.ioc.annotationbase.RepositoryBean;
import kasei.spring.ioc.annotationbase.ServiceBean;
import kasei.spring.ioc.javabase.JavaBaseBean;
import kasei.spring.task.executor.TextThread;
import kasei.spring.task.schedule.WebSaleCardTaskScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Set;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MasterSpringConfig.class);


        // TODO JavaBase Inversion of Control Demo
        System.out.println("\n================ TODO JavaBase Inversion of Control Demo");
        JavaBaseBean initialBean = context.getBean("initialBean", JavaBaseBean.class);
        System.out.println(initialBean.getName());

        // TODO AnnotationBase Inversion of Control Demo
        System.out.println("\n================ TODO AnnotationBase Inversion of Control Demo");
        ControllerBean controllerBean = context.getBean("controllerBean", ControllerBean.class);
        System.out.println(controllerBean.getName());

        ServiceBean serviceBean = context.getBean("serviceBean", ServiceBean.class);
        System.out.println(serviceBean.getName());

        RepositoryBean repositoryBean = context.getBean("repositoryBean", RepositoryBean.class);
        System.out.println(repositoryBean.getName());

        ComponentBean customNamedComponentBean = context.getBean("customNamedComponentBean", ComponentBean.class);
        System.out.println(customNamedComponentBean.getName());

        // TODO Dependency Injection Demo
        System.out.println("\n================ TODO Dependency Injection Demo");
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



        // TODO Schedule: Spring IOC 容器关闭会取消执行
        System.out.println("\n================ TODO Spring Schedule Demo");
        WebSaleCardTaskScheduler webSaleCardTaskScheduler = context.getBean("webSaleCardTaskScheduler", WebSaleCardTaskScheduler.class);
        System.out.println(webSaleCardTaskScheduler.gg);

        // TODO Async: 不受 Spring IOC 容器的影响
        System.out.println("\n================ TODO Spring Async Demo");
        TextThread textThread = context.getBean("textThread", TextThread.class);
        textThread.test();  // 使用 spring 线程池执行
        textThread.test2(); // 使用 spring 线程池执行


        // TODO AOP
        System.out.println("\n================ TODO Spring AOP Demo");
        Obj target = new ObjImp();
        Obj proxy = new ObjProxy(target).getProxy();  // JDK 原生动态代理实现
        System.out.println(proxy.add(1, 2));
        System.out.println(proxy.sub(3, 2));


        Obj obj = (Obj) context.getBean("objImp");
        System.out.println(obj.add(6, 3)); // 测试切面 Priority
        System.out.println(obj.div(6, 0)); // 测试 @Around 通知，先把 LoggingAspect 这个类从切面中删除



        ((AnnotationConfigApplicationContext)context).stop();
        ((AnnotationConfigApplicationContext)context).close();
    }
}

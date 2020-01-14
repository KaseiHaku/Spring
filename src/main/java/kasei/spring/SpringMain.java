package kasei.spring;

import kasei.spring.aop.Obj;
import kasei.spring.aop.ObjImp;
import kasei.spring.aop.ObjProxy;
import kasei.spring.data.bean.bind.ChildEntity;
import kasei.spring.data.bean.bind.ParentEntity;
import kasei.spring.data.bean.convert.PersonEntity;
import kasei.spring.ioc.AnnotationBase;
import kasei.spring.ioc.annotationbase.ComponentBean;
import kasei.spring.ioc.annotationbase.ControllerBean;
import kasei.spring.ioc.annotationbase.RepositoryBean;
import kasei.spring.ioc.annotationbase.ServiceBean;
import kasei.spring.ioc.config.MasterSpringConfig;
import kasei.spring.ioc.di.*;
import kasei.spring.ioc.javabase.JavaBaseBean;
import kasei.spring.spel.Simple;
import kasei.spring.task.executor.TextThread;
import kasei.spring.task.schedule.WebSaleCardTaskScheduler;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpringMain {
    public static void main(String[] args) {

        try {
            Thread.sleep(1000*1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        // TODO Show All Beans in IOC Container
        System.out.println("\n================ TODO Show All Beans in IOC Container");
        context.getBeansOfType(Object.class, true, true).forEach((k,v) -> {
            System.out.format("%100s\t%s%n", k, v.getClass().getTypeName());
        });

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
        // System.out.println(obj.div(6, 0)); // 测试 @Around 通知，先把 LoggingAspect 这个类从切面中删除


        // TODO Type Converter
        System.out.println("\n================ TODO Type Converter");
        PersonEntity personEntity = context.getBean("personEntity", PersonEntity.class);
        System.out.println(personEntity.getTelephone());


        // TODO Data Binding
        System.out.println("\n================ TODO Data Binding");
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setStr("parentEntity");
        parentEntity.setList(List.of(1, 2));
        parentEntity.setMap(Map.of("key1", false, "key2", true));

        BeanWrapper parentWrapper = new BeanWrapperImpl(parentEntity);
        parentWrapper.setPropertyValue("str", "parent");

        BeanWrapper childWrapper = new BeanWrapperImpl(new ChildEntity());
        childWrapper.setPropertyValue("name", "kasei");
        parentWrapper.setPropertyValue("composed", childWrapper.getWrappedInstance());

        String str = (String)parentWrapper.getPropertyValue("str");
        Integer list = (Integer)parentWrapper.getPropertyValue("list[0]");
        Boolean map = (Boolean)parentWrapper.getPropertyValue("map[key1]");
        String composed = (String)parentWrapper.getPropertyValue("composed.name");
        System.out.println(str);
        System.out.println(list);
        System.out.println(map);
        System.out.println(composed);





        // TODO Validate
        System.out.println("\n================ TODO Validate");



        // TODO BeanWrapper: 提供 Spring 访问 Bean 字段的通用方法，运行时先把上面的异常语句注释掉








        // TODO SpEL
        System.out.println("\n================ TODO SpEL");
        ExpressionParser parser = new SpelExpressionParser();
        Simple simple = new Simple();
        simple.booleanList.add(true);
        EvaluationContext spelContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        parser.parseExpression("booleanList[0]").setValue(spelContext, simple, "false");
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);


        ((AnnotationConfigApplicationContext)context).stop();
        ((AnnotationConfigApplicationContext)context).close();
    }
}

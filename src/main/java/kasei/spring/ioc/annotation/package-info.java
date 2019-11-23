package kasei.spring.ioc.annotation;

/** 依赖注入
 * 1. 自动寻找类型相同的实例注入，如果存在多个，则报 Bug
 * 2. @Qualifier("tty") 可以指定 Bean 名称注入
 * 3. 泛型依赖注入：子类会自动寻找泛型类型相同的类进行装配
 * */
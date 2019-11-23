package kasei.spring;

/**
Spring 知识点：{

        1、ioc
        2、aop
        3、transaction
}


IOC 的使用方法：{
        1. 创建一个普通的 java 类，名字叫  Haku
        2. 在 src 目录下创建一个 spring 的配置文件，名字叫  applicationContext.xml
        3. 把类 Haku 配置到 applicationContext.xml 中
        4. 在程序中根据 applicationContext.xml 创建 spring 的 ioc 容器对象
        4. 从 IOC 容器中获取 Haku 类的对象
        5. 然后调用该对象的方法
}

AOP 的使用步骤：{
        1、创建一个普通的 java 类，名字叫  Haku ， 并把它加入到 ioc 容器中
        2、创建一个普通的 java 类，名字叫 Aspect ，也把它加入到 ioc 容器中
        3、在  applicationContext.xml 中配置切入点（就是 Haku 类中的方法名）；
        4、在  applicationContext.xml 中，绑定方法切入点和通知方法（就是 Aspect 类的方法）
}

Transaction 的使用步骤：{

}
 */

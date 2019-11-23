package kasei.spring.transaction.b02anno.impl;

import kasei.spring.transaction.b02anno.B05TransactionInOneClass;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * 本类主要用于测试同一个类中不同的事务方法间相互调用，而不使被调用方法的事务失效的 demo
 * */
@Service
public class B05TransactionInOneClassImpl implements B05TransactionInOneClass {
	
	
	
	 
    @Transactional(propagation = Propagation.REQUIRES_NEW)  
    public void b() {  
    }  
    
    @Transactional(propagation = Propagation.REQUIRED)  
    public void a() {  
        //this.b(); // 这种方法将使 b 方法的事务失效
        B05TransactionInOneClass aopProxy = (B05TransactionInOneClass) AopContext.currentProxy(); // 获取当前的动态代理对象
        
        /* 判断一个Bean是否是AOP代理对象可以使用如下三种方法：
    	 * AopUtils.isAopProxy(bean)        ： 是否是代理对象；
    	 * AopUtils.isCglibProxy(bean)       ： 是否是CGLIB方式的代理对象；
    	 * AopUtils.isJdkDynamicProxy(bean) ： 是否是JDK动态代理方式的代理对象；判断
    	 * */
        
        aopProxy.b(); // 通过动态代理对象调用方法 b 这样才不会使 b 方法的事务失效
    } 
}

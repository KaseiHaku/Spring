package kasei.spring.aop.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 把这个类声明为一个切面 
 * 1. 把这个类放到 ioc 容器当中 @Component
 * 2. 再声明为一个切面 @Aspect
 * */
@Order(1)//指定切面的优先级，值越小优先级越高
@Aspect
@Component  // 必须配合该注解使用，将当前类放到 IoC 容器中
public class LoggingAspect {

	@Before("execution(public int kasei.spring.aop.ObjImp.add(int, int))")
	/* 声明该方法在目标方法开始执行之前执行 */
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("@Before: " + methodName + "(" + args + ") -> 开始执行");
	}
	
	/* 定义一个方法，用于声明切入点的表达式，一般的，该方法中不再需要添加其他代码
	 * 使用@Pointcut 来声明切入点表达式
	 * 后面的其他通知直接使用方法名来引用当前的切入点
	 * */
	@Pointcut("execution(public int kasei.spring.aop.ObjImp.*(int, ..))")
	public void myJoinPointExpression(){}
	
	
	/**
	 * 后置通知：在目标方法执行后（无论是否发生异常），执行通知
	 * 在后置通知中不能访问目标方法的执行结果
	 * 如果 @After("val") val 的值不符合 切点表达式，那么 val 所指定的方法必须被 @Pointcut 注解注释
	 * */
	@After("kasei.spring.aop.aspect.LoggingAspect.myJoinPointExpression()") // 使用切入点表达式
	public void afterMethod(JoinPoint joinPoint) {		
		String methodName = joinPoint.getSignature().getName();		
		System.out.println("@After: " + methodName + " -> 执行完成");
	}
	
	/* 在方法正常结束时，所执行的代码
	 * 返回通知是可以访问方法的返回值的
	 * */
	@AfterReturning(value="execution(public * kasei.spring.aop.*.*(int, ..))",
					returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning: " +  methodName + " -> 执行完成，result = " + result);
	}
	
	
	/* 在目标方法出现 Exception 异常时会执行的代码
	 * 可以访问到异常对象；
	 * */
	@AfterThrowing(value="execution(public double kasei.spring.aop.*.*(int, ..))",
			throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing: " + methodName + " occurs exception:" + ex);
	}	
}

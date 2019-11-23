package kasei.spring.aop.b02anno;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)//指定切面的优先级，值越小优先级越高
@Aspect
@Component
public class AroundAspect {
	
	/* 环绕通知需要携带 ProceedingJoinPoin 类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoin 类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 * */
	@Around("execution(public int a04aop.b01imp.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result = null;
		String className = pjd.getTarget().getClass().getName();
		String methodName = pjd.getSignature().getName();
		
		try {
			//前置通知
			System.out.println("@Around-@Before: " + methodName + "(" + Arrays.asList(pjd.getArgs()) + ") -> 开始执行");
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			System.out.println("@Around-@AfterReturning: " +  methodName + " -> 执行完成，result = " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("@Around-@AfterThrowing: " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("@Around-@After: " + methodName + " -> 执行完成");
		return result;
	}
}

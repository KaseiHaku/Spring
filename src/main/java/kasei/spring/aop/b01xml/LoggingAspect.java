package kasei.spring.aop.b01xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;



public class LoggingAspect {

	
	
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("@Before: " + methodName + "(" + args + ") -> 开始执行");
	}
	
	
	public void myJoinPointExpression(){}
	
	
	
	public void afterMethod(JoinPoint joinPoint) {		
		String methodName = joinPoint.getSignature().getName();		
		System.out.println("@After: " + methodName + " -> 执行完成");
	}
	
	
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning: " +  methodName + " -> 执行完成，result = " + result);
	}
	
	
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing: " + methodName + " occurs exception:" + ex);
	}	
}

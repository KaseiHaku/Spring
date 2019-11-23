package kasei.spring.aop.b01xml;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;


public class AroundAspect {
	
	
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {

			System.out.println("Around-@Before: " + methodName + "(" + Arrays.asList(pjd.getArgs()) + ") -> 开始执行");

			result = pjd.proceed();

			System.out.println("Around-@AfterReturning: " +  methodName + " -> 执行完成，result = " + result);
		} catch (Throwable e) {

			System.out.println("Around-@AfterThrowing: " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}

		System.out.println("Around-@After: " + methodName + " -> 执行完成");
		return result;
	}
}

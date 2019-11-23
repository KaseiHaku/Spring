package kasei.spring.aop.b02anno;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JUnitTest {

	@BeforeClass//在这个 测试类执行之前执行的代码
	public static void beforeClass(){			
		
	}
	
	@AfterClass//在这个测试类之后执行的代码
	public static void afterClass(){		

	}
	
	@Test
	public void testAspect() {
		ApplicationContext ioc = 
				new ClassPathXmlApplicationContext("a04b01_aop_anno.xml");
		
		Obj obj = (Obj) ioc.getBean("objImp");
		
		System.out.println(obj.add(6, 3));
		System.out.println(obj.div(6, 0));
	}
	
	@Test
	public void testAround() {
		// 测试 @Around 通知，先把 LoggingAspect 这个类从切面中删除
		
		ApplicationContext ioc = 
				new ClassPathXmlApplicationContext("a04b01_aop_anno.xml");
		
		Obj obj = (Obj) ioc.getBean("objImp");		
		//System.out.println(obj.add(6, 3));
		System.out.println(obj.div(6, 0));
	}

	
	@Test
	public void testPriority() {
		ApplicationContext ioc = 
				new ClassPathXmlApplicationContext("a04b01_aop_anno.xml");
		
		Obj obj = (Obj) ioc.getBean("objImp");		
		System.out.println(obj.add(6, 3));
	}
}

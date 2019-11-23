package kasei.spring.aop;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {

	@BeforeClass//在这个 测试类执行之前执行的代码
	public static void beforeClass(){			
		
	}
	
	@AfterClass//在这个测试类之后执行的代码
	public static void afterClass(){		

	}
	
	@Test
	public void test() {
		
		Obj target = new ObjImp();
		
		Obj proxy = new ObjProxy(target).getProxy();
		
		System.out.println(proxy.add(1, 2));
		System.out.println(proxy.sub(3, 2));
		
	}
}

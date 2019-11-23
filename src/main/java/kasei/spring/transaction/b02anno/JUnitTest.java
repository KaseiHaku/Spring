package kasei.spring.transaction.b02anno;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JUnitTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("a06b02_transaction_anno.xml");
	
	@BeforeClass
	public static void beforeClass(){			
		
	}
	
	@AfterClass
	public static void afterClass(){		

	}
	
	@Test // 测试 spring 的声明式事务
	public void testTransaction() {
		B03Service service = ioc.getBean(B03Service.class);
		B02BuyerDao buyer = ioc.getBean(B02BuyerDao.class);
		B01SellerDao seller = ioc.getBean(B01SellerDao.class);
		//seller.deliverGood();
		//buyer.payMoney();
		service.purchaseAA();
	}
	
	
	@Test // 测试事务的传播行为，切记事务方法调用同类的事务方法会使内层事务失效
	public void testSpread() {
		B04Assistant assistant = ioc.getBean(B04Assistant.class);
		assistant.multiBuy();
	}
	
	
	@Test // 测试事务的传播行为，内层事务独立与外层事务
	public void testSpread2() {
		B04Assistant assistant = ioc.getBean(B04Assistant.class);
		//assistant.multiBuy2();
	}
	
}

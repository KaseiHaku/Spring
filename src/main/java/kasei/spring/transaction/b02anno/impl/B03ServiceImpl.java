package kasei.spring.transaction.b02anno.impl;

import kasei.spring.transaction.b02anno.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("b03Service")
public class B03ServiceImpl implements B03Service {
	
	@Autowired private B02BuyerDao b02BuyerDao;
	@Autowired private B01SellerDao b01SellerDao;
		
	@Transactional(propagation=Propagation.REQUIRED)// 测试事务，就是定义一个 @Transactional 注解标记的事务函数
	/* Propagation.REQUIRED 表示：如果本事务作为别的事务的内层事务时，融入到外层事务当中
	 * */
	public void purchaseAA() {
		b02BuyerDao.payMoney();
		b01SellerDao.deliverAA();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, // 指定事务的传播方式
			isolation=Isolation.READ_COMMITTED, // 指定事务的隔离级别
			noRollbackFor={UserMoneyException.class},  // 配置指定的异常不进行回滚
			rollbackFor={RepositoryException.class},  // 配置对指定的异常进行回滚
			readOnly=false,				// 配置说明这个事务里面只有对数据库读的操作
			timeout=3) 					// 配置该事务3秒后，强制回滚
	/* Propagation.REQUIRED 表示：如果本事务作为别的事务的内层事务时，任然是自己独立一个事务，
	 * 			外层事务执行到这个事务时先挂起，知道这个事务执行完毕后再执行
	 * */
	public void purchaseBB() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		b02BuyerDao.payMoney();
		b01SellerDao.deliverBB();
	}
}

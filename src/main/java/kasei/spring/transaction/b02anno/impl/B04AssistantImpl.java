package kasei.spring.transaction.b02anno.impl;

import kasei.spring.transaction.b02anno.B03Service;
import kasei.spring.transaction.b02anno.B04Assistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("b04Assistant")
@Transactional  // 加载类上面表示类中所有的方法都是事务方法
public class B04AssistantImpl implements B04Assistant {

	@Autowired
	private B03Service b03Service;
	
	@Override
	@Transactional
	public void multiBuy() {
		b03Service.purchaseAA();
		b03Service.purchaseBB();
	}
	
}

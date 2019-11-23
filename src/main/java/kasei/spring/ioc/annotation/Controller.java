package kasei.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller // 表示该类是受 Spring IOC 容器管理的，并且该类是一个展示层的类
public class Controller {

	
	@Autowired(required=false) // required=false 表示如果当前容器中没有这个类型的 bean 也无所谓
	private Component component;
	
	@Autowired  	
	private Service service;
	

	
	public void execute() {
		System.out.println("@Controller : 处理表现层传递过来的数据");
		service.add();
	}
	
}

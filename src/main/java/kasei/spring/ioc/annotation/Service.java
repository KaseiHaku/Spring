package kasei.spring.ioc.annotation;

@org.springframework.stereotype.Service  // 表示该类是受 Spring IOC 容器管理的，并且该类是一个业务层的类
public class Service {

	private Repository repository;
	
	public void add() {
		System.out.println("@Service : 相加业务");
		repository.save();
	}
}

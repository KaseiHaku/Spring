package kasei.spring.ioc.annotation;

@org.springframework.stereotype.Repository // 表示该类是受 Spring IOC 容器管理的，并且该类是一个持久层的类
public class Repository {

	public void save() {
		System.out.println("@Repository ： 把数据存入数据库");
	}
}

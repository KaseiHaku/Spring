package kasei.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component("myComponent")
/* 表示该类是受 Spring IOC 容器管理的，
 * 并指定 bean id="myComponent"
 * 默认的 bean id 为类名的首字母小写，即 id="b01Component" 
 * 如果类名的第二个字母也是大写字母，如：class QWer 那么 id="QWer"
 * */
public class Component {
	
	@Autowired(required=false) // required=false 表示如果当前容器中没有这个类型的 bean 也无所谓，不报错
	private Excluded other;
	
	@Autowired
	/* 从当前容器中查找类型兼容的 bean， 有的话就装配上，相当于 xml 中的 autowire="byType"
	 * 如果有多个类型兼容的 bean ，那么匹配 bean id 跟当前属性名相同的 bean 
	 * 如果都没有匹配的，那么报错
	 * 如果 @Autowired 标记在数组类型上，那么会获取当前容器中所有的与之类型匹配的 bean
	 * 如果 @Autowired 标记在集合类型上，那么会获取当前容器中所有的与之类型匹配的 bean
	 * 如果 @Autowired 标记在 Map 上，若该 Map 的 key 类型为 String，
	 * 		那么 Spring 会将与 Map value 类型兼容的 bean 全装进来，并以 bean id 作为 key
	 */
	//@Qualifier("tty") // 表示装载当前容器中 bean id="tty" 的 bean 到这个属性中
	private Controller controller;
	
	// @Autowired // 还能且只能标记在 set 方法上
	// @Qualifier("tty")
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void run() {
		System.out.println("@Component ： 组件执行");
		System.out.println(other);	
		controller.execute();
		System.out.println("这部分代码居然是不执行的");
	}
}

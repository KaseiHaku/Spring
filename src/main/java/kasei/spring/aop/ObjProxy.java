package kasei.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// AOP 实现原理：动态代理
public class ObjProxy {
	
	// 被代理的对象
	private Obj target;
	
	public ObjProxy(Obj target) {
		this.target = target;
	}
	
	public Obj getProxy() {
		// 代理对象
		Obj proxy = null;
		
		// loader = 代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		// interfaces = 代理对象需要实现哪些接口，即在代理对象中有哪些方法
		Class[] interfaces = new Class[]{ Obj.class };
		// 当调用代理对象其中的方法时要执行的代码
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy: 正在返回的那个代理对象，一般情况下，在 invoke 方法中不适用该对象
			 * method：正在被调用的方法
			 * args： 调用该方法时的参数
			 * */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) 
					throws Throwable {
				String methodName = method.getName();
				// 日志
				System.out.println(methodName + "(" + Arrays.asList(args) + ")");
				
				//执行方法：
				Object result = null;
				
				try {
					//前置通知：@Before
					result = method.invoke(target, args);
					//返回通知：@AfterReturning，可以访问方法的返回值
				}catch(Exception e) {
					e.printStackTrace();
					//异常通知：@AfterThrowing，可以访问到异常对象；且可以指定在出现特定异常时执行指定代码
				}
				//后置通知：@After，因为方法可能出异常，所以访问不到方法的返回值
				
				// 日志
				System.out.println(methodName + ": 执行完成");

				return result;
			}
		};
		
		proxy = (Obj) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}

package kasei.spring.ioc.xml;


// 通过构造方法配置 bean
public class B02Constructor {
	
	private int i;
	private double d;
	private String str;
	private Obj obj;
	
	
	public B02Constructor(int i, double d, String str, Obj obj) {
		super();
		this.i = i;
		this.d = d;
		this.str = str;
		this.obj = obj;
	}
	
	
}

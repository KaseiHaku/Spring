package kasei.spring.ioc.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;

// 通过 set 方法配置 bean
public class B01Set {
	private int i;
	private double d;
	private String str;	
	private Obj objA;
	private Obj objB;
	private List<Obj> listA;
	private List<Obj> listB;
	private Map<String, Obj> map;
	private Properties properties;
}

package kasei.spring.ioc.xml;

import java.util.HashMap;
import java.util.Map;

public class B07InstanceFactory {
	private static Map<String, Obj> objsMap = null;
	
	public B07InstanceFactory() {
		objsMap = new HashMap<String,Obj>();
		objsMap.put("obj9", new Obj());
		objsMap.put("obj10", new Obj());
	}
	
	public Obj getObj(String flag) {
		return objsMap.get(flag);
	}
}

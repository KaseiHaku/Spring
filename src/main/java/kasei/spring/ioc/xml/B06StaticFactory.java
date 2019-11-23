package kasei.spring.ioc.xml;

import java.util.HashMap;
import java.util.Map;


public class B06StaticFactory {

	private static Map<String, Obj> objsMap = new HashMap<String,Obj>();
	
	static {
		objsMap.put("obj7", new Obj());
		objsMap.put("obj8", new Obj());
	}
	
	public static Obj getObj(String flag) {
		return objsMap.get(flag);
	}
}

package kasei.spring.ioc.xml;

import org.springframework.beans.factory.FactoryBean;

public class B08FactoryBean implements FactoryBean<Obj>{

	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public Obj getObject() throws Exception {
		Obj obj = new Obj();
		obj.setName(name);
		return obj;
	}

	@Override
	public Class<?> getObjectType() {
		
		return Obj.class;
	}

}

package kasei.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class ObjImp implements Obj{

	@Override
	public int add(int i, int j) {		
		return i+j;
	}

	@Override
	public int sub(int i, int j) {		
		return i-j;
	}

	@Override
	public int mul(int i, int j) {
		return i*j;
	}

	@Override
	public int div(int i, int j) {
		return i/j;
	}
}

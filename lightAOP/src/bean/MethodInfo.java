package bean;

import java.lang.reflect.Method;

public class MethodInfo implements Comparable<MethodInfo>{
	private Method method;
	private int index;
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public int compareTo(MethodInfo o) {
		if(o.getIndex()<this.index) {
			return 1;
		}else if(o.getIndex()>this.index) {
			return -1;
		}
		return 0;
	}
	

}

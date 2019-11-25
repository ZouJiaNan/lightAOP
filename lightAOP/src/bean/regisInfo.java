package bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class regisInfo {
	private String className;
	private List<MethodInfo> methodsName;
	
	public regisInfo(List<MethodInfo> methodsName) {
		this.methodsName=methodsName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<MethodInfo> getMethodsName() {
		return methodsName;
	}

	public void setMethodsName(List<MethodInfo> methodsName) {
		this.methodsName = methodsName;
	}
	
	
	
	
}

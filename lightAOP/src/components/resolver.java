package components;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import bean.MethodInfo;
import bean.function;
import bean.regisInfo;

public class resolver<T> {
	//每个切面的注册信息
	private regisInfo info;
	//执行器
	private executor exe;
	public void resolvingBefores() {
		//获取遍历器
				Iterator<regisInfo> it=sectionRegistry.befores.iterator();
				while(it.hasNext()) {
					info=it.next();
					//解析方法
					resolvingMethods(info);
		}
	}
	
	public void resolvingAfters() {
		//获取遍历器
				Iterator<regisInfo> it=sectionRegistry.afters.iterator();
				while(it.hasNext()) {
					info=it.next();
					//解析方法
					resolvingMethods(info);
		}
	}
	
	private void resolvingMethods(regisInfo info) {
		String ClassName=info.getClassName();
		List<MethodInfo> MethodsName=info.getMethodsName();
		Iterator<MethodInfo> it=MethodsName.iterator();
		Method method;
		if(!MethodsName.isEmpty()) {
			exe=new executor();
		}
		//遍历注册中心拿到每个切面
		while(it.hasNext()) {
			MethodInfo methodInfo=it.next();
			method=methodInfo.getMethod();
			exe.execute(ClassName, method);
		}
	}
}

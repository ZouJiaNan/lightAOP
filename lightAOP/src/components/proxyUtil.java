package components;

import java.lang.annotation.Target;
import java.lang.reflect.Proxy;

import bean.function;
import handler.handler;
import interfaces.People;
import interfacesImpl.coder;

public class proxyUtil<Target,Interf> {
	//被代理对象
	private Target target;
	//被代理接口
	private Interf interf;
	
	private handler<Target> h;
	
	public synchronized Interf getProxy(Class clazz) {
		try {
			target=(Target)clazz.newInstance();
			h= new handler<Target>(target,function.class);
			Interf proxy=(Interf)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), h);
			
			return proxy;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

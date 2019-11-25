package components;

import java.lang.reflect.Proxy;

import bean.function;
import handler.handler;
import interfaces.People;
import interfacesImpl.coder;

public class factory<T> {
	private resolver<T> resov;
	
	public factory(Class clazz) {
		this.resov=new resolver<T>();
		if(sectionRegistry.befores.size()==0 && sectionRegistry.afters.size()==0) {
			scanner.scanf(clazz);
		}
	}
	
	public synchronized void before() {
		resov.resolvingBefores();
	}
	
	public synchronized void after() {
		resov.resolvingAfters();
	}
}

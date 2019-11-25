package handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import bean.function;
import components.factory;

public class handler<T> implements InvocationHandler{
	private T target;
	private Class clazz;
	public handler(T target,Class clazz) {
		this.target=target;
		this.clazz=clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		factory<T> f=new factory<T>(clazz);
		f.before();
		Object result=method.invoke(target, args);
		f.after();
		return result;
	}

}

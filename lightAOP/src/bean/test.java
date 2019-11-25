package bean;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

import components.factory;
import components.proxyUtil;
import components.resolver;
import components.scanner;
import components.sectionRegistry;
import handler.handler;
import interfaces.People;
import interfacesImpl.coder;

public class test {
	public static void main(String args[]) {
		proxyUtil<coder, People> proxy=new proxyUtil<coder, People>();
		People p=proxy.getProxy(coder.class);
		p.work();
	}	
}

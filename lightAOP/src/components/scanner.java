package components;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import annotations.after;
import annotations.before;
import annotations.section;
import bean.MethodInfo;
import bean.regisInfo;

public class scanner {
	private static Method[] methods;
	private static regisInfo info;
	private static regisInfo beforeRegisInfo;
	private static regisInfo afterRegisInfo;
	private static String ClassName;
	private static List<MethodInfo> beforeList;
	private static List<MethodInfo> afterList;
	
	public static void scanf(Class clazz) {
		//判断class是否为空
		if(clazz !=null) {
			//判断类是否被注解
			if(clazz.isAnnotationPresent(section.class)) {
				//获取类名
				ClassName=clazz.getName();
				//获取被注解类的所有方法
				methods=clazz.getDeclaredMethods();
				//判断类中是否有方法
				if(methods.length!=0) {
					//扫描类中所有方法
					scan(methods,ClassName);
				}
			}else {
				System.out.println("Class has not annotation");
			}
		}else {
			System.out.println("Class is null");
		}
	}
	//扫描动作
	private static void scan(Method[] methods,String ClassName) {
		beforeList=new ArrayList<MethodInfo>();
		afterList=new ArrayList<MethodInfo>();
		
		MethodInfo methinfo;
		for(Method method:methods) {
			//扫描@before
			if(method.isAnnotationPresent(before.class)) {
				methinfo=new MethodInfo();
				methinfo.setMethod(method);
				methinfo.setIndex(method.getAnnotation(before.class).index());
				beforeList.add(methinfo);
			}
			//扫描@after
			if(method.isAnnotationPresent(after.class)) {
				methinfo=new MethodInfo();
				methinfo.setMethod(method);
				methinfo.setIndex(method.getAnnotation(after.class).index());
				afterList.add(methinfo);
			}
		}
		//向注册中心登记注册被注解方法
		register(ClassName);
	}
	//注册动作
	public static void register(String ClassName) {
		if(beforeList.size()!=0) {
			//对List进行排序
			Collections.sort(beforeList);
			//封装注册
			beforeRegisInfo=new regisInfo(beforeList);
			beforeRegisInfo.setClassName(ClassName);
			sectionRegistry.befores.add(beforeRegisInfo);
		}
		if(afterList.size()!=0) {
			//对List进行排序
			Collections.sort(afterList);
			//封装注册
			afterRegisInfo=new regisInfo(afterList);
			afterRegisInfo.setClassName(ClassName);
			sectionRegistry.afters.add(afterRegisInfo);
		}
	}
	
}

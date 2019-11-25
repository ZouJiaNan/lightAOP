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
		//�ж�class�Ƿ�Ϊ��
		if(clazz !=null) {
			//�ж����Ƿ�ע��
			if(clazz.isAnnotationPresent(section.class)) {
				//��ȡ����
				ClassName=clazz.getName();
				//��ȡ��ע��������з���
				methods=clazz.getDeclaredMethods();
				//�ж������Ƿ��з���
				if(methods.length!=0) {
					//ɨ���������з���
					scan(methods,ClassName);
				}
			}else {
				System.out.println("Class has not annotation");
			}
		}else {
			System.out.println("Class is null");
		}
	}
	//ɨ�趯��
	private static void scan(Method[] methods,String ClassName) {
		beforeList=new ArrayList<MethodInfo>();
		afterList=new ArrayList<MethodInfo>();
		
		MethodInfo methinfo;
		for(Method method:methods) {
			//ɨ��@before
			if(method.isAnnotationPresent(before.class)) {
				methinfo=new MethodInfo();
				methinfo.setMethod(method);
				methinfo.setIndex(method.getAnnotation(before.class).index());
				beforeList.add(methinfo);
			}
			//ɨ��@after
			if(method.isAnnotationPresent(after.class)) {
				methinfo=new MethodInfo();
				methinfo.setMethod(method);
				methinfo.setIndex(method.getAnnotation(after.class).index());
				afterList.add(methinfo);
			}
		}
		//��ע�����ĵǼ�ע�ᱻע�ⷽ��
		register(ClassName);
	}
	//ע�ᶯ��
	public static void register(String ClassName) {
		if(beforeList.size()!=0) {
			//��List��������
			Collections.sort(beforeList);
			//��װע��
			beforeRegisInfo=new regisInfo(beforeList);
			beforeRegisInfo.setClassName(ClassName);
			sectionRegistry.befores.add(beforeRegisInfo);
		}
		if(afterList.size()!=0) {
			//��List��������
			Collections.sort(afterList);
			//��װע��
			afterRegisInfo=new regisInfo(afterList);
			afterRegisInfo.setClassName(ClassName);
			sectionRegistry.afters.add(afterRegisInfo);
		}
	}
	
}

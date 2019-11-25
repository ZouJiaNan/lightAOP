package components;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import bean.MethodInfo;
import bean.function;
import bean.regisInfo;

public class resolver<T> {
	//ÿ�������ע����Ϣ
	private regisInfo info;
	//ִ����
	private executor exe;
	public void resolvingBefores() {
		//��ȡ������
				Iterator<regisInfo> it=sectionRegistry.befores.iterator();
				while(it.hasNext()) {
					info=it.next();
					//��������
					resolvingMethods(info);
		}
	}
	
	public void resolvingAfters() {
		//��ȡ������
				Iterator<regisInfo> it=sectionRegistry.afters.iterator();
				while(it.hasNext()) {
					info=it.next();
					//��������
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
		//����ע�������õ�ÿ������
		while(it.hasNext()) {
			MethodInfo methodInfo=it.next();
			method=methodInfo.getMethod();
			exe.execute(ClassName, method);
		}
	}
}

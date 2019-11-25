package components;

import java.lang.reflect.Method;

public class executor {
	public synchronized void execute(String ClassName,Method method) {
		try {	
			Object instance=Class.forName(ClassName).newInstance();
			method.invoke(instance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

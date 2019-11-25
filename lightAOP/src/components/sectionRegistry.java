package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.regisInfo;

public class sectionRegistry {
	public static List<regisInfo> befores;
	public static List<regisInfo> afters;
	
	static {
		befores=new ArrayList<regisInfo>();
		afters=new ArrayList<regisInfo>();
	}
}

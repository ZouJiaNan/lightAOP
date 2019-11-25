package bean;

import annotations.after;
import annotations.before;
import annotations.section;

@section
public class function {	
	@before(index=3)
	public void eat() {
		System.out.println("³Ô·¹");
	}
	
	@before(index=2)
	public void washup() {
		System.out.println("Ï´Íë");
	}
	
	@after(index=1)
	public void sleep() {
		System.out.println("Ë¯¾õ");
	}
}

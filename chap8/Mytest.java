package chap8;

//interface GPI{
//	void test();
//	}
class GP {
	public void test() {
		System.out.println("GP - test 1");
	}
}
class PP extends GP{
	public void test() {
		System.out.println("PP - test2");
	}
	public void test1() {
		System.out.println("PP - test1 3");
	}
}
class CD extends PP{
	public void test() {
		System.out.println("CD - test 4");
	}
	public void test1() {
		System.out.println("CD - test1 5");
	}
	public void test2() {
		System.out.println("CD - test2 6");
	}
}
public class Mytest {
	
	public static void main(String[] args) {
		CD obj = new CD();
		obj.test();
		obj.test1();
		obj.test2();
		
		PP c = new PP();
		c.test();
		c.test1();
		//c.test2();
		
	}
}
	

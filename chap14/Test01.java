package chap14;
interface MyInterface{
	public void print();
}

class MyClass1 implements MyInterface{
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

public class Test01 {
	static void test(MyInterface m) {
		m.print();
	}
	static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스");
			}
		};
		return mi;
	}
	static MyInterface test3() {
		return new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스3");
			}
		};
	
	}
	public static void main(String[] args) {
		MyClass1 mc1 = new MyClass1();
		//mc1.print();
		test(mc1);

		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스");
			}
		};
		test(mi);
		mi.print();// 대신에
		new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스2");
			}
		}.print();// 참조변수가 없음으로 프린트 한 후 사라짐
		MyInterface mi2 = test2();
		mi2.print();
		MyInterface m3= test3();
		m3.print();
		//람다식
		MyInterface m4 = ()-> System.out.println("hello");
	}
}

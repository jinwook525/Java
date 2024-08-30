package chap6;

public class Members {
	private String name;
	private int age;
	
	public Members() {
		this("guest");
	}
	public Members(String name) {
		this(name,0);
	}
	public Members(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name+ ":"+age;
	}
	public static void main(String[] args) {
		Members m1 = new Members();
		Members m2 = new Members("Amy");
		Members m3 = new Members("Amy",23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}


package chap8;

class DD{
	String name;
	
	public DD(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		DD d = (DD)obj;
		if(name.equals(d.name))
			return true;
		return false;
	}
	
}
public class Equltest {
	public static void main(String[] args) {
		DD a = new DD("A");
		DD b = new DD("B");
		DD c = new DD("C");
		
		DD d = a;
		System.out.println((a==b)?"equal":"not equal");
		System.out.println((a==c)?"equal":"not equal");
		System.out.println((a==d)?"equal":"not equal");
		
		System.out.println((a.equals(b))?"equal":"not equal");
		System.out.println((a.equals(c))?"equal":"not equal");
	}

}

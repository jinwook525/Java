package chap11;


public class Test01 {	
	
	public static void test01() throws Exception {
		test02();
	}
	public static void test02() throws Exception {
		test03();
	}
	public static void test03() throws Exception {
		test04();
	}
	public static void test04() throws Exception {
		int arr[] = new int[3];
		arr[3]= 30;	
	}
	public static void main(String[] args) {
		try {
			test01();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("ok");
	}

}	
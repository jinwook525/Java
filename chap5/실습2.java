package chap5;
class People {
	private String name;
	private int age;
	private float weight;

	// 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * 교재 p198 Armor.java 참조
	 */

	// name 메소드: setter, getter 함수, 교재 p199
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	// age 메소드:setter, getter 함수 구현, 교재 p199
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setWeight(float weight){
		this.weight = weight;
	}
	public float getWeight(){
		return weight;
	}

	// weight 메소드: setter, getter 함수 구현, 교재 p199

	// 이름, 나이, 몸무게를 출력하는 show 메소드


	// 오버로딩된 show 메소드 (message를 출력)
	public void show(String msg) {
		System.out.println("메시지 = " + msg);
		// 이름, 나이, 몸무게를 출력하는 코드 작성
	}
	public void show() {
		// TODO Auto-generated method stub

	}
}
public class 실습2 {
	
		public static void main(String[] args) {

			// 객체 생성
			People p = new People();
			p.setName("홍길동");
			p.setAge(25);
			p.setWeight(62.123f);
			//다음 코드를 디버깅



			System.out.println("이름 = " +p.getName() + ", 나이 = " + p.getAge() + ", 몸무게 = " + p.getWeight());

			// 메소드 호출
			p.show();
			p.show("오버로딩");
		}
	}


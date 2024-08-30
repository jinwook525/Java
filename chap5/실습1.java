package chap5;
class Armor{
	String name;
	int height;
	int weight;
	int speed;
	public int speedup(int value) {
		speed += value;
		return speed;

	}

}
class Person {
	// 필드
	/*
	 * name은 String, age는 int, weight는 float로 필드 선언
	 */
	String name;
	int age;
	float weight;
	// 메소드

	void show() {
		System.out.println("["+name+","+age+","+weight+"]");
		/*
		 * name=**, age = **, weight = ** 형태로 출력
		 */
	}
}

public class 실습1 {
	public static void main(String[] args) {
		// 객체 생성
		Person p = new Person();
		p.name = "홍길동";
		p.age = 25;
		p.weight = 60.56f;

		// 메소드 호출
		p.show();

		Person g = new Person();
		g.name = "강감찬";
		g.age = 55;
		g.weight = 62.34f;

		g.show();




		/*
		 * [강감찬, 55, 62.34] 객체를 만들어
		 * name=**, age = **, weight = ** 형태로 출력
		 */

	}
}


package chap5;
class Human {
	private String name;
	private int age;
	private float weight;
	private String subjects[];
	private int years[];
	private int count;


	// 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * subjects을 교육과목 private 배열
	 * years을 수강 연도 private 배열
	 * count 필드를 사용하여 수강 과목 증가시마다 ++count
	 */
	// 필드

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setSubjectsYears(int size) {
		subjects= new String [size];
		years= new int[size];
		count= -1;
	}
	void addSubjectYear(String subject, int year){
		//과목, 수강연도를 매개변수로 전달받아 배열에 추가
		subjects[++count]=subject;
		years[count]=year;
	}
	// 메소드
	void show() {
		System.out.println("기본출력:name="+name+",age"+age+",weight"+weight);
		while 
		// 기본 정보 출력::name=**, age=**, weight=**로 출력

		// 교육과목 및 수강 연도 출력
		/*
		 * while 문을 사용하여 교육과목과 수강연도를 출력
		 */
	}

}

public class 실습3 {
	public static void main(String[] args) {
		// 첫 번째 객체 생성 및 초기화
		Human p1 = new Human();
		//다음 코드를 setter, addSubjectYear를 사용하여 수정
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setWeight(60.56f);
		p1.setSubjectsYears = new String[] {"Mathematics", "Science", "History"};
		p1.setSubjectsYears = new int[] {2020, 2021, 2022};

		// 메소드 호출
		p1.show();

		// 두 번째 객체 생성 및 초기화
		Human p2 = new Human();
		p2.name = "강감찬";
		p2.age = 55;
		p2.weight = 62.34f;
		p2.subjects = new String[] {"Literature", "Philosophy", "Physics"};
		p2.years = new int[] {2018, 2019, 2020};

		// 메소드 호출
		p2.show();
	}
}

}

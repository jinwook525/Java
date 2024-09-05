package chap6_2;

class Student {
	private String name;
	private int age;
	private String subjects[];
	private int scores[];
	private int passFails[];
	private int value;
	private static int numStudents;
	// 필드
	/*
	 * name, age, subjects[], scores[], passFail[], count를 private으로 선언
	 * count는 배열의  index로 사용
	 *  numberStudents를 정적 필드로 선언
	 */
	// 생성자
	/*name, age, subjects[], scores[], passFail[], count를 매개변수로 전달받는 생성자 정의
	 * 
	 */
	public Student(String name, int age, String subjects[], int scores[], int passFails[], int value) { 
		this.name= name;
		this.age= age;
		this.subjects=subjects;
		this.scores=scores;
		this.passFails=passFails;
		this.value=value;
	}


	// setter 메소드: setName(String name), setAge(int age),  setSubjects(String subjects[]), setScores(int scores[]), setCount(int num)

	// 학생 수를 반환하는 정적 메소드getNumberStudents()

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


	public String[] getSubjects() {
		return subjects;
	}


	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}


	public int[] getScores() {
		return scores;
	}


	public void setScores(int[] scores) {
		this.scores = scores;
	}


	public int[] getPassFails() {
		return passFails;
	}


	public void setPassFail(int[] passFails) {
		this.passFails = passFails;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		System.out.println("이름 ="+getName()+",나이 ="+getAge());
		for (int i=0; i<subjects.length; i++ ) {

			System.out.println(getSubjects()[i]+"="+getScores()[i]);
		}
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **
		 * 과목2 = **, 점수2 = **
		 * ... 등으로 출력
		 */
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudentInfo() {
		System.out.println("이름 ="+getName()+",나이 ="+getAge()); 
		for (int i=0; i<subjects.length; i++ ) {
			System.out.println(getSubjects()[i]+" 점수="+getScores()[i]+", 통과여부="+(passFails[i] <= scores[i]? "pass" : "fail"));
		}
		System.out.println("전체과목 통과여부="+ (isPassed()?"pass": "fail"));
		System.out.println("-".repeat(20));
	}
	/*
	 * 이름 = **, 나이 = **
	 * 과목1 = **, 점수1 = **, 통과여부=pass
	 * 과목2 = **, 점수2 = **, 통과여부=fail
	 * ... 등으로 출력
	 */


	// 통과 여부 (모든 과목을 통과했는지 확인)
	public boolean isPassed() {
		for (int j=0 ; j<subjects.length; j++) {
			if (scores[j]< passFails[j]) {
				return false;
			}

		}
		return true;
	}
	// 6.2.2 각 학생의 성적 테이블을 출력하는 정적 메소드
	public static void printAllStudents(Student[] students) {
		//학생 이름 + 과목명, 과목 점수 .... + 과목통과여부:pass or fail
		for (int i = 0; i < students.length; i++) {
			students[i].printStudentInfo();
		}
	}

	// 6.2.2 과목별 최대/최소 점수 및 해당 학생을 출력하는 정적 메소드
	public static void printSubjectStats(Student[] students) {

	}
}

public class 실습3 {
	//주어진 학생이 모든 과목 통여 여부를 반환 
	private static void showStudents(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			students[i].printStudent();
			System.out.println("-".repeat(20));
		}
	}



	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int []passFails = {40,70,60,55,80};
		Student[] students = { 
				/*
				 *  생성자를 사용하여 객체 생성*/
				new Student("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 40},passFails, -1),
				new Student("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
				new Student("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
				new Student("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
				new Student("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)

		};
		// 학생 수를 정적 메소드 호출로 처리

		// 학생 정보 출력 (예시)
//		showStudents(students);

		// 각 학생의 성적 테이블 출력
		Student.printAllStudents(students);

		//		// 과목별 최대/최소 점수 및 해당 학생 출력
		//		Student.printSubjectStats(students);
	}
}





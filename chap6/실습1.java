package chap6;

class Student {
	// 필드
	/*
	 * name, age, subjects[], scores[], count를 private으로 선언
	 * count는 배열의  index로 사용
	 */
	private String name;
	private int age;
	private String subject[];
	private int scores[];
	private int count;
	private static int numStudents;

	// setter 메소드: setName(String name), setAge(int age),  setSubjects(String subjects[]), setScores(int scores[]), setCount(int num)

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

	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	// 학생 수를 반환하는 정적 메소드
	public static int getnum() {
		return numStudents;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	//	public void printStudent() {
	//		for (int i=0; i<=numStudents ;i++) {	
	//			System.out.println("이름 ="+name+",나이 ="+age);
	//			for (int j=0; j<=count; j++ ) {
	//				System.out.println("과목"+ j+"="+subject[j]+","+"점수"+j+"="+scores[j]);

	/*
	 * 이름 = **, 나이 = **
	 * 과목1 = **, 점수1 = **
	 * 과목2 = **, 점수2 = **
	 * ... 등으로 출력
	 */


}

public class 실습1 {
	public static void showStudents(String msg, Student[] s) {
		System.out.println(msg);
		for (int i = 0; i < s.length; i++) {
			System.out.println("이름 ="+s[i].getName()+",나이 ="+s[i].getAge());
			for (int j=0; j<s[i].getSubject().length; j++ ) {
				
				System.out.println(s[i].getSubject()[j]+"="+s[i].getScores()[j]);
			
				
				//System.out.println("과목"+ j+"="+s[i].getSubject+","+"점수"+j+"="+scores[j]);
			}System.out.println("-".repeat(20));
		}
	}
	public static Student makeStudent(String name, int age, String[] subjects, int[] scores, int count) {
		Student s = new Student();
		//setter를 사용한 구현
		s.setName(name);
		s.setAge(age);
		s.setSubject(subjects);
		s.setScores(scores);
		s.setCount(count);
		return s;
	} 

	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};

		Student[] students = {
				makeStudent("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92}, 5),
				makeStudent("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, 5),
				makeStudent("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, -1),
				makeStudent("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, -1),
				makeStudent("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, -1)
		};

		// 학생 정보 출력 (예시)
		showStudents("학생", students);

	}

} 


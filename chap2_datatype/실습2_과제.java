package chap2_datatype;

import java.util.Scanner;

public class 실습2_과제 {
	public static void main(String[] args) {
//		
//		1. 학생의 이름과 과목은 문자열로 입력받고, 성적은 정수로 입력받아 console에 출력하는 프로그램 작성
//
//		2. 출력 형태는 "이름 =  ***, 과목 = ***, 성적 = **, 통과 = **". 
//
//		3. 통과여부는 문자열로 성적 점수가 60점 이상이면 "합격", 미만이면  "과락"으로 표현하며 삼항연산자를 사용한다. 
//
//		4. 입력을 위한 변수 선언과 사용은 다음과 같다.
//
		 Scanner sc = new Scanner (System.in);

		 

		String name = sc.next(); //문자열일 때\
		String sub = sc.next();
		int score = sc.nextInt(); //정수일 때
		boolean exam = score>=60;
		
		String pass= exam? "합격": "과락";
	
		System.out.println("이름="+name+" 과목="+sub+" 성적="+score+" 통과="+pass);
		
	}

}

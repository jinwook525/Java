package chap3;

import java.util.Scanner;

public class if문_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수");
		int score = sc.nextInt();
		
		
		
		
		System.out.println((score>=60)? "합격":"불합격");
	}
	


}

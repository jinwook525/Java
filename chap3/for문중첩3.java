package chap3;

import java.util.Scanner;

public class for문중첩3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			for(int j= 1; j<10; j++){
				for(int i=2; i<10; i++) {
					System.out.print(i+"*"+j+"="+(i*j)+"\t");
				}
			System.out.println();
		}
	}
}
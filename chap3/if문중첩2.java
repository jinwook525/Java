package chap3;

public class if문중첩2 {
	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i <= 100; i++)
			if ((i % 2) == 0 & ((i % 3) == 0)) {
				System.out.println(i + "은 2와 3의 공배수입니다");
				cnt++;

			}
	}
}

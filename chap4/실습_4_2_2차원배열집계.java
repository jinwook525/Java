package chap4;

public class 실습_4_2_2차원배열집계 {
	public static void main(String[] args) {


		// 2차원 배열 생성 및 초기화
		/*
		 * 2차원 행렬 [3][4]을 matrix 정수 변수로 선언하고 12개 값을 초기화
		 */
		int [][] arr= {{1,2,3,4},{4,13,6,10},{7,10,9,12}};
		int max=0;
		int min=100;
		int sum=0;
		int count=0;
		double avg=0;
		// 최대값, 최소값, 합 개수 초기화
		/*
		 * max, min, sum, count 정수 변수를 선언, 초기 값 지정
		 * for 문을 사용하여 최대, 최소, 합, 개수를 계산  
		 */
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++){
				if(max<arr[i][j]) {
					max=arr[i][j];

				}
			}	
		} System.out.println("최대값"+max);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++){
				if(min>=arr[i][j]) {
					min=arr[i][j];
				}
			}
		} System.out.println("최소값"+min);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				sum= sum+arr[i][j]; {
					if(i+1==arr.length && j+1==arr[i].length) {
						System.out.println("합계"+sum);
					}
				}
			}

		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				count= count+1;{
					if(i+1==arr.length && j+1==arr[i].length) {
						System.out.println("갯수"+count);
					}
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				avg= sum/count;{
					if(i+1==arr.length && j+1==arr[i].length) {
						System.out.println("평균"+avg);
					}
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");
//				if(j<arr[i].length-1) {
//					
//					}
				}
			 System.out.print("\n");
		}
	}	


	
}
// 평균 계산
/*
 * sum을 사용하여 평균을 avg 변수로 선언하여 저장
 */


// 결과 출력
/*
 * 2차원 배열을 행렬 형태(테이블 형태)로 출력
 * 최대, 최소, 합, 개수, 평균을 다음과 같이 출력
 * "최대=**, 최소=**, 합 = **, 갯수=**, 평균=**"
 */




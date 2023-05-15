import java.util.Scanner;

public class SW_1948 {
	public static void main(String[] args) {
		int[] lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31};
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int firstM = sc.nextInt();
			int firstD = sc.nextInt();
			int secondM = sc.nextInt();
			int secondD = sc.nextInt();
			
			int sum = 0;
			//첫번째 월 전체 ~ 두번째 월 전까지 
			for(int i = firstM; i < secondM; i++) {
				sum += lastDay[i];
			}
			//첫번째 일 전까지 제외
			sum -= firstD - 1;
			
			//두번째 월의 일 추가
			sum += secondD;
			
			System.out.println("#" + test_case + " " + sum);
			
		}
	}
}

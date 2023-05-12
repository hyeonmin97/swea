import java.util.Scanner;

public class SW_1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int fHour = sc.nextInt();
			int fSecond = sc.nextInt();
			int sHour = sc.nextInt();
			int sSecond = sc.nextInt();
			
			int sumHour = fHour + sHour;
			int sumSecond = fSecond + sSecond;
			if(sumSecond >= 60) {
				sumHour++;
				sumSecond -= 60;
			}
			if(sumHour > 12)
				sumHour -= 12;
			
			System.out.println("#" + test_case + sumHour + " " + sumSecond);
			
		}
	}
}

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SW_1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int[] answer = new int[money.length];
			
			for (int i = 0; i < money.length; i++) {
				int cnt = n / money[i];
				answer[i] = cnt;
				n = n % money[i];
			}
			System.out.println("#" + test_case);
			System.out.println(Arrays.stream(answer).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
		}

	}
}

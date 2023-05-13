import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SW_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int length = sc.nextInt();
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			System.out.println("#" + test_case + " " + Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
			
		}
	}
}

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

class SW_1945
{
	public static void main(String args []) throws Exception{
		int[] answer = new int[5];
		int[] abcde = {2, 3, 5, 7, 11};
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int inputNumber = sc.nextInt();
			for(int i = abcde.length - 1; i >= 0; i--) {
				//큰 숫자부터 시작
				int base = abcde[i];
				while(inputNumber % base == 0) {
					inputNumber /= base;
					answer[i]++;
				}
			}
			String answerStr = Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
			
			System.out.println("#" + test_case + " " + answerStr);
			Arrays.fill(answer, 0);
			
		}
		
	}
}
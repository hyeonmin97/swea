import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1959 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {

			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int max;
			if(A.length < B.length)
				max = getMaxValue(A, B);
			else
				max = getMaxValue(B, A);
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	public static int getMaxValue(int[] small, int[] big) {
		int maxValue = Integer.MIN_VALUE;
		int startIndex = 0;
		do {
			int sum = 0;
			//시작인덱스 전까지 B 원소들 더하기
//			for(int i = 0; i < startIndex; i++) {
//				sum += big[i];
//			}
			//A, B곱하기
			for(int i = 0; i < small.length; i++) {
				int a = small[i];
				int b = big[i + startIndex];
				sum += (a * b);
			}
			
			//다 곱한 이후 B원소들 더하기
//			for (int i = startIndex + small.length; i < big.length; i++) {
//				sum += big[i];
//			}
			maxValue = Math.max(maxValue, sum);
			startIndex++;
		}while(startIndex + small.length <= big.length);
		
		return maxValue;
	}
}

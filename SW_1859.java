import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1859 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			long sum = 0;

//			int max = Arrays.stream(inputArr).max().getAsInt();
//			for(int i = 0; i < inputArr.length; i++) {
//				int value = inputArr[i];
//				if(value < max) {
//					sum += (max - value);
//				}
//				else if (value == max && i + 1 < inputArr.length) {
//					//max 변경
//					int[] tempArr = new int[inputArr.length - i -1];
//					System.arraycopy(inputArr, i + 1, tempArr, 0, inputArr.length - i-1);
//					max = Arrays.stream(tempArr).max().getAsInt();
//				}
//			}
			
			//남은 것들 중 최대값을 찾음... => 뒤에서부터 최댓값을 찾는다면???
			int max = Integer.MIN_VALUE;
			for(int i = inputArr.length -1; i >= 0; i--) {
				//최댓값을 찾았다면
				if(max < inputArr[i]) {
					max = inputArr[i];
				}
				sum += (max - inputArr[i]);
			}
			System.out.println("#" + testCase + " " + sum);
		}
	}

	
}

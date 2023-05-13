import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SW_1961 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String[][] input = new String[n][n];
			String[][] answer;
			
			//배열 저장
			for (int i = 0; i < n; i++) {
				input[i] = br.readLine().split(" ");
			}
			
			answer = rotateArr(n, input);
			
			System.out.println("#" + test_case);
			for(int i = 0; i < answer.length; i++) {
				System.out.println(Arrays.stream(answer[i]).collect(Collectors.joining(" ")));
			}
		}
	}

	private static String[][] rotateArr(int n, String[][] input) {
		String[][] rotateArr;
		String[][] answer = new String[n][3];
		for(int rotate = 0; rotate < 3; rotate++) {
			rotateArr = new String[n][n];
			//돌리기
			for (int y = 0; y < input.length; y++) {
				for (int x = 0; x < rotateArr[y].length; x++) {
					rotateArr[x][n - 1 - y] = input[y][x];
				}
			}

			//저장하기
			// 90 180 270
			for(int i = 0; i < answer.length; i++) {
				answer[i][rotate] = Arrays.stream(rotateArr[i]).collect(Collectors.joining());
			}
			
			//돌린 후의 배열을 계산할 배열로 저장
			input = rotateArr;
		}
		return answer;
	}
}

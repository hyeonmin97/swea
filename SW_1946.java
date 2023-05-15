import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				//k만큼 반복
				for (int j = 0; j < Integer.parseInt(input[1]); j++) {
					sb.append(input[0]);
				}
			}
			
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < sb.length(); i++) {
				result.append(sb.charAt(i));
				if((i+1) % 10 == 0)
					result.append("\n");
			}
			
			System.out.println("#" + test_case);
			System.out.println(result.toString());
		}
	}
}

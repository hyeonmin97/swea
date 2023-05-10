import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution
{
	public static void main(String args []) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			String[] nk = br.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			
			//미로 저장
			int[][] inputMaze = new int[n][];
			for(int i = 0; i < n; i++) {
				String[] lineArr = br.readLine().split(" ");
				inputMaze[i] = Arrays.stream(lineArr).mapToInt(Integer::valueOf).toArray();
			}
			
			int[] stringLength = new int[n+1];
			
			//가로줄 검색
			for(int i = 0; i < n; i++) {
				String row = Arrays.stream(inputMaze[i]).mapToObj(Integer::toString).collect(Collectors.joining());
				saveOneLength(row, stringLength);
			}
			
			//세로줄 검색
			for(int i = 0; i < n; i++) {
				StringBuilder sBuilder = new StringBuilder();
				for(int j = 0; j < n; j++) {
					sBuilder.append(inputMaze[j][i]);
				}
				saveOneLength(sBuilder.toString(), stringLength);
			}
			
			System.out.println("#" + test_case + " " + stringLength[k]);
		}
		
	}

	private static void saveOneLength(String row, int[] stringLength) {
		String[] splitZero = row.split("0");
		for(int j = 0; j < splitZero.length; j++) {
			int length = splitZero[j].length();
			stringLength[length]++;
		}
	}
}
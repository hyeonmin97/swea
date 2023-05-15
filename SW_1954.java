import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SW_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
//			int value = 1;
//			for(int i = 0; i < n; i++) {
//				arr[0][i] = value++;
//			}
//			int nowX = n -1;
//			int nowY = 0;
//			int d = 0;
//			for(int i = n-1; i >=1; i--) {
//				d++;
//				d %= 4;
//				//첫번째
//				for(int j = 0; j < i; j++) {
//					int nextX = nowX + dx[d];
//					int nextY = nowY + dy[d];
//					arr[nextY][nextX] = value++;
//					nowX = nextX;
//					nowY = nextY;
//				}
//				d++;
//				d %= 4;
//				//두번째
//				for(int j = 0; j < i; j++) {
//					int nextX = nowX + dx[d];
//					int nextY = nowY + dy[d];
//					arr[nextY][nextX] = value++;
//					nowX = nextX;
//					nowY = nextY;
//				}
//			}
			arr[0][0] = 1;
			int nowX = 0;
			int nowY = 0;
			int value = 2;
			int d = 0;
			while(value <= n * n) {
				//끝이나 0이 아닌 값을 만나면 방향 변경
				int nextX = nowX + dx[d]; 
				int nextY = nowY + dy[d];
				//방향전환
				if(nextY < 0 || nextY >= n || nextX < 0 || nextX >= n || arr[nextY][nextX] != 0) {
					d = (d + 1) % 4;
					continue;
				}
				arr[nextY][nextX] = value++;
				nowX = nextX;
				nowY = nextY;
			}
			System.out.println("#" + test_case);
			for(int i = 0; i < n; i++) {
				System.out.println(Arrays.stream(arr[i]).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
			}
		}
	}
}

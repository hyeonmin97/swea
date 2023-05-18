import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//
//public class SW_1210 {
//	static int[] dx = {-1, 1};
//	static int[] dy = {0, 0};
//	public static void main(String[] args) throws Exception {
//		
//		//100 * 100
//		System.setIn(new FileInputStream("src/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		for(int testCase = 1; testCase <= 10; testCase++) {
//			int num = Integer.parseInt(br.readLine());
//			int[][] map = new int[100][];
//			
//			for(int i = 0; i < 100; i++)
//				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			
//			int findStart=0;
//			for (int i = 0; i < map.length; i++) {
//				if(map[0][i] == 1) {
//					//찾으면 true
//					if(findEnd(i, map)) {
//						findStart = i;
//						break;
//					}
//				}
//			}
//			
//			System.out.println("#" + testCase + " " + findStart);
//		}
//		
//	}
//	public static boolean findEnd(int startIndex, int[][]map) {
//		Queue<Node> queue = new LinkedList<>();
//		boolean[][] isVisited = new boolean[map.length][map[0].length];
//		queue.offer(new Node(startIndex, 0));
//		
//		//빌때까지
//		int cnt = 1;
//		while(!queue.isEmpty()) {
//			Node node = queue.poll();
//			isVisited[node.y][node.x] = true;
//			
//			if(node.y == map.length -1) {
//				if(map[node.y][node.x] == 2)
//					return true;
//				return false;
//			}
//			
//			//다음 좌표 가능 여부 확인
//			//아래로 내려가는게 가장 낮은 우선순위
//			boolean isMoved = false;
//			for(int d = 0 ; d < dx.length; d++) {
//				int nextX = node.x + dx[d];
//				int nextY = node.y + dy[d];
//				
//				//좌표 유효확인
//				if(nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length)
//					continue;
//				
//				//이동 가능하면
//				if(map[nextY][nextX] == 1) {
//					if(!isVisited[nextY][nextX]) {
//
//						queue.add(new Node(nextX, nextY));
//						isMoved = true;
//						break;
//					}
//				}
//			}
//			//이동하지 않았으면 아래로
//			if(!isMoved) {
//				queue.add(new Node(node.x, node.y + 1));
//			}
//			
//		}
//		
//		
//		return false;
//	}
//}
class Node{
	int x;
	int y;
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
}

public class SW_1210 {
	static int[] dx = {1, -1, 0};
	static int[] dy = {0, 0, -1};
	//뒤에서부터 하기
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int num = Integer.parseInt(br.readLine());
			int[][] map = new int[100][];
			
			int answerX = 0, answerY = 0;
			for(int i = 0; i < 100; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				if(i == 99) {
					for(int j = 0; j < 100; j++) {
						//정답 위치 저장
						if(map[i][j] == 2) {
							answerX = j;
							answerY = i;
						}
					}
				}
			}
			
			int result = findStart(answerX, answerY, map);
			
			System.out.println("#" + testCase + " " + result);
			
		}
	}
	private static int findStart(int x, int y, int[][] map) {
		boolean[][] isVisited = new boolean[map.length][map[0].length];
		while(true){
			if(y==0)
				return x;
			
			for(int d = 0; d < dx.length; d++) {
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				if(nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length)
					continue;
				
				//1이고 방문하지 않은곳
				if(map[nextY][nextX]==1 && !isVisited[nextY][nextX]) {
					isVisited[nextY][nextX] = true;
					x = nextX;
					y = nextY;
					break;
				}
			}
		}
		
		
		
	}
	
}
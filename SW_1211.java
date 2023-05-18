import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SW_1211 {
    //좌, 우, 하
    static int[] dx = {-1, 1, 0};
    static int[] dy = {0, 0, 1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //최단거리가 되는 인덱스 구하기
        for (int testCase = 1; testCase <= 10; testCase++) {
            int n = Integer.parseInt(br.readLine());
            Node min = new Node(-1, -1, -1, Integer.MAX_VALUE);
            int[][] map = new int[100][];
            //지도 저장
            for (int i = 0; i < 100; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            //경로 검사
            for (int i = 0; i < 100; i++) {
                if (map[0][i] == 1){
                    Node node = findRoute(i, map, new boolean[100][100]);
                    if(node.depth < min.depth){
                        min = node;
                    }

                }
            }

            System.out.println("#" + testCase + " " + min.startIndex);
        }

    }

    private static Node findRoute(int startIndex, int[][] map, boolean[][] isVisited) {
        Stack<Node> stack = new Stack<>();
        Node node = new Node(startIndex, 0, startIndex, 1);
        stack.push(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            isVisited[pop.y][pop.x] = true;//방문처리

            //종료조건 확인
            if (pop.y == map.length - 1) {
                return pop;
            }

            //다음 경로 확인
            for (int d = 0; d < dx.length; d++) {
                int nextX = pop.x + dx[d];
                int nextY = pop.y + dy[d];

                //불가능한 좌표인지 확인
                if(isDisable(nextX, nextY))
                    continue;

                //조건 확인
                //1이고 방문하지 않은곳
                if(map[nextY][nextX] == 1 && !isVisited[nextY][nextX]){
                    stack.push(new Node(nextX, nextY, pop.startIndex, pop.depth + 1));
                    break;
                }

            }
        }
        return null;
    }

    private static boolean isDisable(int nextX, int nextY) {
        return (nextY < 0 || nextY >= 100 || nextX < 0 || nextX >= 100);
    }


}

class Node{
    int x;
    int y;
    int startIndex;
    int depth;

    public Node(int x, int y, int startIndex, int depth) {
        this.x = x;
        this.y = y;
        this.startIndex = startIndex;
        this.depth = depth;
    }
}
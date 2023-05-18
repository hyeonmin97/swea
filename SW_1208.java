import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
            int dump = Integer.parseInt(br.readLine());
            int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            //최댓값 1증가, 최솟값 1 감소
            for (int i = 0; i < dump; i++) {
                Arrays.sort(heights);
                heights[0]++;
                heights[heights.length-1]--;
            }

            Arrays.sort(heights);
            System.out.println("#" + testCase + " " + (heights[heights.length-1] - heights[0]));


        }
    }
}

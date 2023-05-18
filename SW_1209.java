import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1209 {
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int[][] inputArr = new int[100][100];
            //입력
            for (int i = 0; i < 100; i++) {
                inputArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            //row 최대값 구하기
            for (int i = 0; i < 100; i++) {
                int sum = Arrays.stream(inputArr[i]).sum();
                max = Math.max(sum, max);
            }

            //col 최대값
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += inputArr[j][i];
                }
                max = Math.max(sum, max);
            }

            //대각선 최대값
            int diagonal1 = 0;
            int diagonal2 = 0;
            for (int i = 0; i < 100; i++) {
                diagonal1 += inputArr[i][i];
                diagonal2 += inputArr[i][99-i];
            }
            max = Math.max(diagonal1, max);
            max = Math.max(diagonal2, max);

            System.out.println("#" + testCase + " " + max);
        }
    }
}

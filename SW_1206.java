import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1206 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int testCase = 1; testCase <= 10 ; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            //2번 인덱스 검사
            for (int i = 2; i < n -2; i++) {
                int pivot = arr[i];

                //왼쪽
                if(arr[i-2] >= pivot || arr[i-1] >= pivot)
                    continue;

                //오른쪽
                if(arr[i+2] >= pivot || arr[i+1] >= pivot)
                    continue;

                //왼쪽 둘중에 큰거
                int leftCount = Math.max(arr[i-2], arr[i-1]);

                //오른쪽 둘중에 큰거
                int rightCount = Math.max(arr[i+2], arr[i+1]);

                // => 좌우 건물 중 최대높이 구하면 되는거임;
                int last = Math.max(leftCount, rightCount);
                count += pivot - last;
            }

            System.out.println("#" + testCase + " " + count);
        }

    }
}

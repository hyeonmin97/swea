import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SW_1244 {
    public static int max = 0;
    public static void main(String[] args) throws FileNotFoundException {
        //정해진 횟수만큼 교환해서 최댓값 만들기
        //어쨌든 큰 수를 앞으로
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            String money = Integer.toString(sc.nextInt());
            int chance = sc.nextInt();
            char[] moneys = money.toCharArray();

            dfs(chance, 0, 0, moneys);

            System.out.println("#" + testCase + " " + max);
            max = 0;
        }

    }
    public static void dfs(int chance, int count, int startIndex, char[] moneys){

        //종료조건
        if(chance == count){
            max = Math.max(max, Integer.parseInt(new String(moneys)));
            return;
        }

        for (int i = startIndex; i < moneys.length; i++) {
            for (int j = i + 1; j < moneys.length; j++) {
                if(moneys[i] < moneys[j]) {
                    swap(moneys, i, j);
                    dfs(chance, count + 1, i, moneys);
                    swap(moneys, j, i);
                }
            }
        }
    }
    public static void swap(char[] moneys, int i, int j) {
        char temp =  moneys[i];
        moneys[i] = moneys[j];
        moneys[j] = temp;

    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SW_1974 {
	public static void main(String[] args) {
		//겹치는게 없을경우 1, 겹칠경우 0
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] sudoku;
		for (int test_case = 1; test_case <= t; test_case++) {
			//스도쿠 판 저장
			sudoku = new int[9][9];
			for (int i = 0; i < sudoku.length; i++) {
				for (int j = 0; j < sudoku[i].length; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			//검사
			if(isAbleCol(sudoku) && isAbleRow(sudoku) && isAbleSquare(sudoku))
				System.out.println("#" + test_case + " " + 1);
			else
				System.out.println("#" + test_case + " " + 0);
		}
		
	}
	
	public static boolean isAbleSquare(int[][] sudoku) {

		Set<Integer> set;
		for(int i = 0; i < sudoku.length; i += 3) {
			for (int j = 0; j < sudoku.length; j += 3) {
				//작은 사각형의 중복 저장할 set 생성
				set = new HashSet<>();
				for (int k1 = 0; k1 < 3; k1++) {
					for (int k2 = 0; k2 < 3; k2++) {
						int num = sudoku[k1 + i][k2 + j];
						if (set.contains(num)) return false;
						set.add(num);
					}
				}
			}
		}
		
		return true;
	}
	
	public static boolean isAbleRow(int[][] sudoku) {
		Set<Integer> set;
		for(int i = 0; i < sudoku.length; i++) {
			set = new HashSet<>();
			for(int j = 0; j < sudoku[i].length; j++) {
				int num = sudoku[i][j];
				if(set.contains(num))
					return false;
				set.add(num);
			}
		}
		return true;
	}
	
	public static boolean isAbleCol(int[][] sudoku) {
		Set<Integer> set;
		for(int i = 0; i < sudoku.length; i++) {
			set = new HashSet<>();
			for(int j = 0; j < sudoku[i].length; j++) {
				int num = sudoku[j][i];
				if(set.contains(num))
					return false;
				set.add(num);
			}
		}
		return true;
	}
}

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class SW_1983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] ranks = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt(); //몇명
			int k = sc.nextInt(); //확인 인덱스
			Student[] score = new Student[n];
			for (int i = 0; i < n; i++) {
				int m = sc.nextInt();
				int e = sc.nextInt();
				int test = sc.nextInt();
				double total = m * 0.35 + e * 0.45 + test * 0.2;
				score[i] = new Student(i + 1, total);
			}
			
			//총점 내림차순
			Arrays.sort(score, (v1, v2) -> {
				double comp = v2.score - v1.score;
				if(comp < 0)
					return -1;
				else if(comp > 0)
					return 1;
				return 0;
				
			});
			
			int sameGrade = n / 10;
			for (int i = 0; i < score.length; i++) {
				Student student = score[i];
				if(student.index == k) { //찾는 인덱스이면
					int rankIndex = i / sameGrade;// 현재 인덱스 / 등급당 사람 수
					System.out.println("#" + test_case + " " + ranks[rankIndex]);
				}
			}
			
		}
		
	}
}
class Student{
	int index;
	double score;
	public Student(int index, double score) {
		super();
		this.index = index;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [index=" + index + ", score=" + score + "]";
	}
	
	
}

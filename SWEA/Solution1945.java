package SWEA;

import java.util.Scanner;

public class Solution1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int arr[] = new int[12];
			int N = s.nextInt();
			for (int i = 2; i <= N; i++) {
				while( N%i == 0) {
					arr[i]++;
					N= N/i;
				}
			}
			System.out.println("#"+t+" "+arr[2]+" "+arr[3]+" "+arr[5]+" "+arr[7]+" "+arr[11]);
		}

	}

}

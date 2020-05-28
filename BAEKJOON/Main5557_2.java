package BAEKJOON;

import java.util.Scanner;

public class Main5557_2 {
	static long dp[][];
	static long count = 0;
	static int arr[];
	static boolean check[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		arr = new int[N];
		long num = 0;
		dp = new long[N][21];
		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}
		dp[0][arr[0]] = 1;
		for (int i = 1; i < N-1; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] > 0) {
					int number = j + arr[i];
					if (number >= 0 && number <= 20)
						dp[i][number] += dp[i - 1][j];

					number = j - arr[i];
					if (number >= 0 && number <= 20)
						dp[i][number] += dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N - 2][arr[N - 1]]);

	}

}

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {
	static int Dp[], N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Dp = new int[N + 1];
		DFS(N,0);
		System.out.println(Dp[N]);
	}

	public static void DFS(int depth, int cnt) {
		if(depth ==0)
			return ;
		if (Dp[depth] != 0) {
			if(Dp[depth]>cnt) {
				Dp[depth]=cnt;
			}
			 return ;
		}
		if (depth == 1) {
			Dp[depth]=cnt;
			return ;
		} else {
				DFS(depth / 3, cnt + 1);
				DFS(depth / 2, cnt + 1);
				DFS(depth - 1, cnt + 1);
		}

	}

}

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1463 {
	static int Dp[], N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Dp = new int[N + 1];
		Arrays.fill(Dp, -1);
		Dp[0]=Dp[1]=0;
		System.out.println(DFS(N));
	}

	public static int DFS(int depth) {

		if (Dp[depth] != -1) {

			 return Dp[depth];
		}
		int min=Integer.MAX_VALUE;
			if(depth % 2 == 0)
				min=Math.min(min, DFS(depth/2));
			if(depth % 3 == 0)
				min=Math.min(min, DFS(depth/3));
			
			min=Math.min(min, DFS(depth-1));
			
			
			

		return Dp[depth]=min+1;
	}

}

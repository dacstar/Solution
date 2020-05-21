package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s  = new Scanner(System.in);
		int N=s.nextInt();
		int color[][] = new int[N+1][N];
		int dp[][] = new int[N+1][N];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<N;j++) {
				color[i][j]=s.nextInt();
			}
		}
		dp[0][0] = dp[0][1] = dp[0][2]  = 0;
		for(int i=1;i<=N;i++) {
			dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+color[i][0];
			dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+color[i][1];
			dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+color[i][2];
            
		}
	
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		
		
		
	}

}

package BAEKJOON;

import java.util.Scanner;

public class Main2240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int W = s.nextInt();
		int dp[][] = new int[W+1][T+1];
		int time[] = new int[T+1];
		for(int i=1;i<=T;i++) {
			time[i]=s.nextInt()-1;
		}
		int num=0;
		int cnt=1;
		for(int i=1;i<=T;i++) {
			if(time[i] == 0) {
			dp[0][i]=++num;
			}else {
				dp[0][i]=num;
			}
		}
		for(int i=1;i<=W;i++) {
			cnt=cnt%2;
			int n=0;
			for(int j=1;j<=T;j++) {
				if(time[j] == cnt) {
					 n=dp[i][j-1]+1;
				}
				dp[i][j]=Math.max(n, dp[i-1][j]);
			}
			cnt++;
		}

		System.out.println(dp[W][T]);

		
		
	}

}

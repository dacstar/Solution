package SWEA;

import java.util.Scanner;

public class Solution0304 {
	static int map[][];
	static int dp[][][][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int t=1;t<=T;t++) {
			int n=s.nextInt();
			int m=s.nextInt();
			map = new int[n][m];
			dp=new int[n+1][m+1][n+1][m+1];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=s.nextInt();
				}
			}
			
			System.out.println("#"+t+" "+DFS(0,0,n,m));
			
		}
	}
	
	public static int DFS(int sr,int sc,int er,int ec) {
		if(sr - er ==1 && sc - ec ==1)
			return 0;
		if(dp[sr][sc][er][ec]!=0)
			return dp[sr][sc][er][ec];
		int res=Integer.MAX_VALUE;
		int sum=0;
		for(int i=sr;i<er;i++) {
			for(int j=sc;j<ec;j++) {
				sum+=map[i][j];
			}
		}
		
		for(int i=sr+1;i<er;i++) {
			int temp=DFS(i,sc,er,ec) + DFS(sr,sc,i,ec);
			if(res > temp)
				res=temp;
		}
		
		for(int c=sc+1;c<ec;c++) {
			int temp=DFS(sr,c,er,ec) + DFS(sr,sc,er,c);
			if(res > temp)
				res=temp;
		}
		
		dp[sr][sc][er][ec]=res+sum;
		return dp[sr][sc][er][ec];
		
		
	}
	
	

}

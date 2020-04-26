package SWEA;

import java.util.Scanner;

public class Solution1954 {
	static int map[][];
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			N = s.nextInt();
			map = new int[N][N];
			map[0][0]=1;
			DFS(0,0,2,0);
			System.out.println("#"+t);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void DFS(int y,int x,int index,int dir) {
		if(index == N*N+1) {
			return ;
		}
		
		for(int i=0;i<2;i++) {
			int tmpy=y+dy[(dir+i)%4];
			int tmpx=x+dx[(dir+i)%4];
			if(check(tmpy,tmpx) && map[tmpy][tmpx]==0) {
				map[tmpy][tmpx]=index;
				DFS(tmpy,tmpx,index+1,(dir+i)%4);
			}
			
			
		}
		
		
	}
	
	public static boolean check(int y,int x) {
		if(y<0 || y>=N || x<0 || x>=N)
			return false;
		
		return true;
		
	}

}

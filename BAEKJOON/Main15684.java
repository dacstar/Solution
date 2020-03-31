package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684 {
	static int N,M,H,answer;
	static int map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map  = new int[H+1][N+1];
		int r,c;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c =  Integer.parseInt(st.nextToken());
			map[r][c]=1;
			map[r][c+1]=2;
		}
		answer=4;
		DFS(1,0);
		   System.out.println((answer != 4) ? answer : -1);
		
	}
	
	public static void DFS(int x,int count) {
		if (answer <= count) return;
		else {
			if(check()) {
				answer=count;
				return ;
			}
		}
		
		for(int i=x;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(map[i][j]==0 && map[i][j+1]==0) {
					map[i][j]=1;
					map[i][j+1]=2;
					DFS(i,count+1);
					map[i][j] = map[i][j+1] = 0;
				}
			}
		}
		
		
	}
	 private static boolean check() {
	        for (int i = 1; i <= N; i++) {
	            int x = 1, y = i;
	            for (int j = 0; j < H; j++) {
	                if (map[x][y] == 1) y++;
	                else if (map[x][y] == 2) y--;
	                x++;
	            }
	            if (y != i) return false;
	        }
	        return true;
	    }

}

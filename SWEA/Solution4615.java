package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4615 {
	static int map[][];
	static boolean check[][];
	static int dy[]= {1,-1,0,0,1,-1,1,-1};
	static int dx[]= {0,0,1,-1,1,-1,-1,1};
	static int N,M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());

			map = new int[N][N];
			map[N/2-1][N/2-1]=2;
			map[N/2-1][N/2]=1;
			map[N/2][N/2-1]=1;
			map[N/2][N/2]=2;
		
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int c=Integer.parseInt(st.nextToken())-1;
				int r=Integer.parseInt(st.nextToken())-1;
				int color=Integer.parseInt(st.nextToken());
				map[r][c]=color;
				play(r,c,color);
			}
			int block=0;
			int white=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1)
						block++;
					else if(map[i][j]==2)
						white++;

				}
			}
			print(map);
			System.out.println("#"+t+" "+block+" "+white);
		}

	}
	
	static void print(int [][]arr) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void play(int y,int x,int color) {
			for(int j=0;j<dx.length;j++) {
				int tmpy=dy[j]+y;
				int tmpx=dx[j]+x;
				boolean check=false;
				while(check(tmpy,tmpx) && map[tmpy][tmpx] !=0) {
						if(color == map[tmpy][tmpx]) {
							check=true;
							break;
						}
						tmpy+=dy[j];
						tmpx+=dx[j];
				}
				while(check) {
					if(tmpy == y && tmpx == x)
						break;
					map[tmpy][tmpx]=color;
					tmpy-=dy[j];
					tmpx-=dx[j];
				}
		}


	}

	static boolean check(int y,int x) {
		if(y<0 || y>=N || x<0 || x>=N) {
			return false;
		}

		return true;
	}

}

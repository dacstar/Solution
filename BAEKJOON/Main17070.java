package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070 {
	static int N, res;
	static int dir[][] = { { 0, 2 }, { 1, 2 }, { 0, 1, 2 } };
	static int dy[] = { 0, 1, 1 };
	static int dx[] = { 1, 0, 1 };
	static boolean[][] check;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		res = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[N][N];
		check[0][0]=true;
		check[0][1]=true;
		DFS(0,1,0);
		System.out.println(res);

	}

	public static void DFS(int r, int c,int p) {
		if (r == N - 1 && c == N - 1) {
			res++;
			return;
		}
				for (int d = 0; d < dir[p].length; d++) {
					if(dir[p][d] == 2 && !pipecheck(r,c))
						continue;
						int tmpy=dy[dir[p][d]]+r;
						int tmpx=dx[dir[p][d]]+c;
						if(check(tmpy,tmpx)) {
							check[tmpy][tmpx]=true;
							DFS(tmpy,tmpx,dir[p][d]);
							check[tmpy][tmpx]=false;
						}
				}

	}

	public static boolean check(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= N || map[y][x] == 1 || check[y][x])
			return false;

		return true;
	}
	public static boolean pipecheck(int y,int x) {
		if(!check(y+1,x) || !check(y,x+1) || !check(y+1,x+1))
			return false;
		
		return true;
	}

}

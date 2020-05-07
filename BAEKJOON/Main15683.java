package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15683 {
	static int map[][];
	static int check[];
	static int dy[] = { 0, -1, 0, 1 };
	static int dx[] = { -1, 0, 1, 0 };
	static int N, M, index, res;
	static ArrayList<XY> list;
	static int dirs[][] = { {}, { 0 }, { 0, 2 }, { 1, 2 }, { 0, 3, 2 }, { 0, 1, 2, 3, 4 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res=100000;
		list = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					index++;
					list.add(new XY(i, j, map[i][j]));
				}
			}
		}
		check = new int[index];
		DFS(0,map);
		System.out.println(res);
	}

	public static void DFS(int idx,int temp[][]) {
		if (idx == index) {
			int arr[][]=new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] =map[i][j];
				}
			}
			for (int i = 0; i < list.size(); i++) {
				XY xy=list.get(i);
				int dir=xy.dir;
				for(int d=0;d<dirs[dir].length;d++) {
					int tmpy=xy.y;
					int tmpx=xy.x;
					while(true) {
						tmpy+=dy[(dirs[dir][d]+check[i])%4];
						tmpx+=dx[(dirs[dir][d]+check[i])%4];
						if(!check(tmpy,tmpx,arr)) {
							break;
						}else {
							if(map[tmpy][tmpx]!=0 || arr[tmpy][tmpx]==7 ) {
								continue;
							}
							arr[tmpy][tmpx]=7;
						}
					}
					
				}
			}
			sum(arr);

			return;
		}

		for (int i = 0; i < 4; i++) {
			check[idx] = i;
			DFS(idx + 1,temp);
		}

	}

	public static void sum(int arr[][]) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		res = Math.min(res, cnt);
	}
	public static boolean check(int y,int x,int [][]arr) {
		if(y<0 || y>=N || x<0 || x>=M|| arr[y][x]==6)
			return false;
		
		return true;
	}
	public static void print(int [][]arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}



	public static class XY {
		int y;
		int x;
		int dir;

		XY(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

}

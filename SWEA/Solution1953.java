package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953 {
	static int N, M, R, C, L, res;
	static int map[][];
	static boolean check[][];
	static int dy[][] = { { -100 }, { 1, -1, 0, 0 }, { 1, -1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static int dx[][] = { { -100 }, { 0, 0, 1, -1 }, { 0, 0 }, { 1, -1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			if(N>M) {
				int tmp=N;
				N=M;
				N=tmp;
			}
			map = new int[N+1][M+1];
			res = 0;
			check = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
	
			BFS(R, C);
//			print();
			sum();
			System.out.println("#" + t + " " + res);

		}

	}

	public static void BFS(int y, int x) {
		Queue<XY> q = new LinkedList<>();
		check[y][x] = true;
		q.add(new XY(y, x, 1));
		while (!q.isEmpty()) {
			XY xy = q.poll();
			int dir = map[xy.y][xy.x];
			if (xy.time == L) {
				continue;
			}
			for (int d = 0; d < dy[dir].length; d++) {
				int tmpy = dy[dir][d] + xy.y;
				int tmpx = dx[dir][d] + xy.x;
				if (check(tmpy, tmpx)) {
					if (dir == 1) {
						if (d == 0 && (map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 5 || map[tmpy][tmpx] == 6)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 4 || map[tmpy][tmpx] == 7)) {
							continue;
						} else if (d == 2 && (map[tmpy][tmpx] == 2 || map[tmpy][tmpx] == 4 || map[tmpy][tmpx] == 5)) {
							continue;
						} else if (d == 3 && (map[tmpy][tmpx] == 2 || map[tmpy][tmpx] == 6 || map[tmpy][tmpx] == 7)) {
							continue;
						}
					} else if (dir == 2) {
						if (d == 0 && (map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 5 || map[tmpy][tmpx] == 6)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 4 || map[tmpy][tmpx] == 7)) {
							continue;
						}
					} else if (dir == 3) {
						if (d == 0 && (map[tmpy][tmpx] == 4 || map[tmpy][tmpx] == 5 || map[tmpy][tmpx] == 2)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 6 || map[tmpy][tmpx] == 7 || map[tmpy][tmpx] == 2)) {
							continue;
						}
					} else if (dir == 4) {
						if (d == 0 && (map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 7  || map[tmpy][tmpx] == 4)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 2 || map[tmpy][tmpx] == 5  || map[tmpy][tmpx] == 4)) {
							continue;
						}
					} else if (dir == 5) {
						if (d == 0 && (map[tmpy][tmpx] == 6 || map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 5 || map[tmpy][tmpx] == 4)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 4 || map[tmpy][tmpx] == 2 || map[tmpy][tmpx] == 5)) {
							continue;
						}
					} else if (dir == 6) {
						if (d == 0 && (map[tmpy][tmpx] == 5 || map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 6)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 2 || map[tmpy][tmpx] == 7 || map[tmpy][tmpx] == 6 )) {
							continue;
						}
					} else if (dir == 7) {
						if (d == 0 && (map[tmpy][tmpx] == 4 || map[tmpy][tmpx] == 3 || map[tmpy][tmpx] == 7)) {
							continue;
						} else if (d == 1 && (map[tmpy][tmpx] == 6 || map[tmpy][tmpx] == 2 || map[tmpy][tmpx] == 7)) {
							continue;
						}
					}
					check[tmpy][tmpx] = true;
					q.add(new XY(tmpy, tmpx, xy.time + 1));
				}
			}
		}
	}

	public static void sum() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j])
					res++;
			}
		}

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j])
					System.out.print("T" + " ");
				else
					System.out.print("F" + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public static boolean check(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= M || map[y][x] == 0 || check[y][x])
			return false;

		return true;
	}

	public static class XY {
		int y;
		int x;
		int time;

		XY(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}

}

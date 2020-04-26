package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7733 {
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int N;
	static boolean check[][];
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			StringTokenizer st;
			int max = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(map[i][j], max);
				}
			}
			int ans=0;
			for (int v = 0; v <= max; v++) {
				int res = 0;
				steal(v);
				boolean visit[][] = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!check[i][j] && !visit[i][j]) {
							res++;
							BFS(i, j, visit);
						}
					}
				}
				ans=Math.max(ans, res);
			}
			System.out.println("#"+t+" "+ans);
		}

	}

	public static boolean check(int y, int x, boolean[][] visit) {
		if (y < 0 || y >= N || x < 0 || x >= N || visit[y][x] || check[y][x]) {
			return false;

		}
		return true;
	}

	public static void BFS(int y, int x, boolean visit[][]) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(y, x));
		visit[y][x] = true;
		while (!q.isEmpty()) {
			XY xy = q.poll();
			for (int d = 0; d < 4; d++) {
				int tmpy = dy[d] + xy.y;
				int tmpx = dx[d] + xy.x;
				if (check(tmpy, tmpx, visit)) {
					visit[tmpy][tmpx] = true;
					q.add(new XY(tmpy, tmpx));
				}
			}
		}

	}

	public static void steal(int val) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j] && map[i][j] <= val)
					check[i][j] = true;
			}
		}
	}

	public static class XY {
		int y;
		int x;

		XY(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}

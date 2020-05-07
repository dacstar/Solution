package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17822 {
	static int map[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static int N, M, T;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= N; j++) {
				if (j % x == 0) {
					Move(j - 1, d, k);
				}
			}
			delete();
		}
		System.out.println(sum());
	}

	public static void delete() {
		boolean visit = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					DFS(i, j, map[i][j]);
					if (map[i][j] == 0)
						visit = true;
				}
			}
		}
		if (!visit) {
			avg();
		}
	}

	public static void avg() {
		double sum = 0;
		double count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					sum += map[i][j];
					count++;
				}
			}
		}
		double avg = sum / count;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && map[i][j] > avg) {
					map[i][j]--;
				} else if (map[i][j] != 0 && map[i][j] < avg) {
					map[i][j]++;
				}
			}
		}
	}

	public static int sum() {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}

	public static void DFS(int y, int x, int num) {

		for (int d = 0; d < 4; d++) {
			int tmpy = dy[d] + y;
			int tmpx = (dx[d] + x + M) % M;
			if (check(tmpy, tmpx)) {
				if (map[tmpy][tmpx] == num) {
					map[y][x] = 0;
					map[tmpy][tmpx] = 0;
					DFS(tmpy,tmpx,num);
				}
			}

		}

	}
	public static void print(int [][]arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean check(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= M)
			return false;

		return true;
	}

	public static void Move(int x, int d, int k) {
		int[] circleindex = new int[M];
		for (int i = 0; i < M; i++) {
			int index = idx(d, i, k);
			circleindex[index] = map[x][i];
		}
		map[x] = circleindex;
	}

	public static int idx(int d, int num, int k) {
		if (d == 0) {
			return (num + k) % M;
		} else {
			return (num - k + M) % M;
		}
	}

}

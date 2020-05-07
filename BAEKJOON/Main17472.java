package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472 {
	static int N, M;
	static int Map[][];
	static boolean visit[][];
	static int parents[];
	static boolean number[];
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];

		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 1 && !visit[i][j]) {
					BFS(i, j, cnt++);
				}
			}
		}
		parents = new int[cnt];
		number = new boolean[cnt];
		ArrayList<XY> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int tmpy = dy[d] + i;
						int tmpx = dx[d] + j;
						int count = 0;
						if (check(tmpy, tmpx) && Map[tmpy][tmpx] == 0) {
							count++;
							while (true) {
								tmpy += dy[d];
								tmpx += dx[d];
								if (check(tmpy, tmpx) && Map[tmpy][tmpx] != 0 && Map[tmpy][tmpx] != Map[i][j]) {
									if(count<2)
										break;
									XY xy = new XY(Map[i][j], Map[tmpy][tmpx]);
									xy.value = count;
									list.add(xy);
									break;
								}
								if (!check(tmpy, tmpx) || Map[tmpy][tmpx] == Map[i][j])
									break;
								if (Map[tmpy][tmpx] == 0)
									count++;
							}
						}
					}
				}
			}
		}
		Arrays.fill(parents, -1);
		Collections.sort(list);
		int answer = 0;
		int V=cnt;
		int cnt2 = 0;
		for (int i = 0; i < list.size(); i++) {
			if(V-1  == cnt2)
				break;
			XY xy = list.get(i);
			if (union(xy.x, xy.y)) {
				answer += xy.value;
				cnt2++;
			}
		}

		for(int i=1;i<cnt;i++) {
			int one=find(1);
			int two=find(i);
			if(find(1) !=find(i)) {
				System.out.println("-1");
				return ;
			}
		}

			System.out.println(answer);

	}

	public static int find(int idx) {
		if (parents[idx] < 0) {
			return idx;
		}

		return parents[idx] = find(parents[idx]);
	}

	public static boolean union(int y, int x) {
		int left = find(y);
		int right = find(x);
		if (left != right) {
			parents[right] = left;
			return true;
		}
		return false;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void BFS(int y, int x, int cnt) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(y, x));
		Map[y][x] = cnt;
		visit[y][x] = true;
		while (!q.isEmpty()) {
			XY xy = q.poll();
			for (int d = 0; d < 4; d++) {
				int tmpy = dy[d] + xy.y;
				int tmpx = dx[d] + xy.x;
				if (check(tmpy, tmpx) && !visit[tmpy][tmpx] && Map[tmpy][tmpx] == 1) {
					visit[tmpy][tmpx] = true;
					Map[tmpy][tmpx] = cnt;
					q.add(new XY(tmpy, tmpx));
				}
			}
		}

	}

	public static boolean check(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= M)
			return false;

		return true;
	}

	public static class XY implements Comparable<XY> {
		int y;
		int x;
		int value;

		XY(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(XY o) {
			// TODO Auto-generated method stub
			return this.value >o.value ? 1 : -1;
			
		}
	}

}

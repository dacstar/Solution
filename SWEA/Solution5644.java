package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5644 {
	static String map[][];
	static int dy[] = { 0, -1, 0, 1, 0 };
	static int dx[] = { 0, 0, 1, 0, -1 };
	static int M, A;
	static int user[][];
	static XY[] xy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			xy = new XY[A];
			map = new String[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = "";
				}
			}
			user = new int[2][M + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					user[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 1; j++) {
					xy[i] = new XY(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}

			make();
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					System.out.print(map[i][j].length() + " ");
//				}
//				System.out.println();
//			}
			int sum = 0;
			int r = 0;
			int c = 0;
			int r2 = 9;
			int c2 = 9;
			for (int j = 0; j <= M; j++) {
				r += dy[user[0][j]];
				c += dx[user[0][j]];
				r2 += dy[user[1][j]];
				c2 += dx[user[1][j]];
				if (map[r][c].length() == 0 && map[r2][c2].length() == 0)
					continue;

				// 둘중 하나만 0일때
				if (map[r][c].length() == 0 || map[r2][c2].length() == 0) {
					if (map[r][c].length() > 0) {
						// 만약 1개이상일때
						int nowMax = 0;
						for (int i = 0; i < map[r][c].length(); i++) {
							nowMax = Math.max(nowMax, xy[Integer.parseInt(map[r][c].charAt(i) + "")].p);
						}
						sum += nowMax;
						continue;
					} else {
						int nowMax = 0;
						for (int i = 0; i < map[r2][c2].length(); i++) {
							nowMax = Math.max(nowMax, xy[Integer.parseInt(map[r2][c2].charAt(i) + "")].p);
						}
						sum += nowMax;
						continue;
					}
				}
				// 둘다 1일때
				if (map[r][c].length() >= 1 || map[r2][c2].length() >= 1) {
					int nowMax=0;
					for (int i = 0; i < map[r][c].length(); i++) {
						for (int k = 0; k < map[r2][c2].length(); k++) {
							if((map[r][c].charAt(i)+"").equals(map[r2][c2].charAt(k)+"")) {
								int number=xy[Integer.parseInt(map[r2][c2].charAt(k) + "")].p*2;
								nowMax = Math.max(nowMax, number/2);
							}else {
								int number=xy[Integer.parseInt(map[r2][c2].charAt(k) + "")].p+xy[Integer.parseInt(map[r][c].charAt(i) + "")].p;
								nowMax= Math.max(nowMax, number);
							}
						}
					}
					sum+=nowMax;
					continue;
				}

			}

			System.out.println("#" + t + " " + sum);

		}

	}

	public static void make() {
		for (int i = 0; i < A; i++) {
			for (int a = 0; a < 10; a++) {
				for (int b = 0; b < 10; b++) {
					if (dis(xy[i].x, b, xy[i].y, a) <= xy[i].c) {
						if (map[a][b] == "") {
							map[a][b] = i + "";
						} else {
							if (map[a][b].equals(i + "")) {
								continue;
							}
							map[a][b] += i + "";
						}
					}
				}
			}
		}
	}

	public static int dis(int x1, int x2, int y1, int y2) {

		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static class XY {
		int y;
		int x;
		int c;
		int p;

		XY(int x, int y, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}

}

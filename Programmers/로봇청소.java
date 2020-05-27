package Programmers;

public class 로봇청소 {
	static int office[][] = { { 5, -1, 4 }, { 6, 3, -1 }, { 2, -1, 1 } };
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int N, M;
	static int res = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 1;
		int c = 0;
		String move[] = { "go", "go", "right", "go", "right", "go", "left", "go" };
		N = office.length;
		M = office[0].length;
		res += office[r][c];
		office[r][c] = 0;
		BFS(office, r, c, move);
		System.out.println(res);
	}

	public static void BFS(int office[][], int r, int c, String move[]) {
		int y = r;
		int x = c;
		int dir = 0;
		for (int i = 0; i < move.length; i++) {
			if (move[i].equals("go")) {
				int tmpy = y + dy[dir];
				int tmpx = x + dx[dir];
				if (check(tmpy, tmpx, office)) {
					y=tmpy;
					x=tmpx;
					res += office[y][x];
					office[y][x] = 0;
					continue;
				}
			} else if (move[i].equals("left")) {
				if(dir==0) {
					dir=3;
				}else if(dir==3) {
					dir=2;
				}else if(dir==2) {
					dir=1;
				}else {
					dir=0;
				}
			} else if (move[i].equals("right")) {
				if(dir==0) {
					dir=1;
				}else if(dir==1) {
					dir=2;
				}else if(dir==2) {
					dir=3;
				}else {
					dir=0;
				}
				continue;
			}

		}

	}

	public static boolean check(int y, int x, int map[][]) {
		if (y < 0 || y >= N || x < 0 || x >= M || map[y][x] == -1)
			return false;

		return true;

	}

	public static class XY {
		int r;
		int c;
		int dir;

		XY(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

}

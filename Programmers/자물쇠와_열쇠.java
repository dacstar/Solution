package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 자물쇠와_열쇠 {
	static int key[][] = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
	static int lock[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };
	static int N,M,NL,ML;
	static ArrayList<XY>[] list;
	static boolean res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer = true;
		list = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			list[i] = new ArrayList<>();
		}
		int cnt = 4;
		res=false;
		N=key.length;
		M=key[0].length;
		NL=lock.length;
		ML=lock[0].length;
		int map[][] = new int[NL * 2][lock[0].length * 2];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = lock[i % NL][j % lock[i % NL].length];
			}
		}
		while (cnt-- > 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < key[i].length; j++) {
					if (key[i][j] != 0) {
						list[cnt].add(new XY(i, j, map[i][j]));
					}
				}
			}
			key = rotate(key);

		}
		for (int i = 0; i < 4; i++) {
			find(list[i], map);
			if(res)
				break;
		}
		System.out.println(res);

	}

	public static void find(ArrayList<XY> list, int map[][]) {
		Queue<ArrayList<XY>> q = new LinkedList<>();
		q.add(list);
		while (!q.isEmpty()) {
			ArrayList<XY> xy = q.poll();

			fill(xy,map);
			if(check(map)) {
				res=true;
				return ;
			}
			fillout(xy,map);
		
			for (int d = 0; d < 4; d++) {
				ArrayList<XY> tmp = new ArrayList<>();
				for (int i = 0; i < xy.size(); i++) {
					int tmpy = xy.get(i).y + dy[d];
					int tmpx = xy.get(i).x + dx[d];
					if (isPos(tmpy, tmpx)) {
						tmp.add(new XY(tmpy, tmpx, map[tmpy][tmpx]));
					} else {
						break;
					}
				}
				if (tmp.size() == xy.size()) {
					q.add(tmp);
				}
			}

		}

	}

	public static boolean isPos(int y, int x) {

		if (y >= N * 2 || y < 0 || x >= M * 2 || x < 0)
			return false;

		return true;

	}

	public static int[][] rotate(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] rotate = new int[m][n];
		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = arr[n - 1 - j][i];
			}
		}

		return rotate;
	}

	public static boolean check(int map[][]) {
		boolean check = false;

		for (int i = 0; i < NL; i++) {
			for (int j = 0; j < lock[i].length; j++) {
				if (map[i][j] == 0) {
					check = true;
					break;
				}
			}
		}

		if (!check)
			return true;
		check = false;
		for (int i = 0; i < NL; i++) {
			for (int j = lock[i].length; j < map.length; j++) {
				if (map[i][j] == 0) {
					check = true;
					break;
				}
			}
		}

		if (!check)
			return true;
		check = false;
		for (int i = NL; i < map.length; i++) {
			for (int j = lock[i].length; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					check = true;
					break;
				}
			}
		}

		if (!check)
			return true;
		check = false;
		for (int i = NL; i < map.length; i++) {
			for (int j = 0; j < lock[i].length; j++) {
				if (map[i][j] == 0) {
					check = true;
					break;
				}
			}
		}

		if (!check)
			return true;

		return false;
	}

	public static void print(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void fill(ArrayList<XY> xy,int map[][]) {
		for (int i = 0; i < xy.size(); i++) {
			if(xy.get(i).val == 0) {
				map[xy.get(i).y][xy.get(i).x]=1;
			}
		}
		
	}
	
	
	public static void fillout(ArrayList<XY> xy,int map[][]) {
		for (int i = 0; i < xy.size(); i++) {
			if(xy.get(i).val == 0) {
				map[xy.get(i).y][xy.get(i).x]=0;
			}
		}

		
	}

	public static class XY {
		int y;
		int x;
		int val;

		XY(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
	}

}

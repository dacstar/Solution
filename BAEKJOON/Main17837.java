package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17837 {

	static int r, c, k;
	static int A[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = new int[3][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		if (r < A.length && A[0].length > c) {
			if (A[r][c] == k) {
				System.out.println(result);
				return ;
			}
		}
		while (true) {
			if (result == 100) {
				result = -1;
				break;
			}
			if (A.length >= A[0].length) {
				R();
				result++;
				if (r < A.length && A[0].length > c) {
					if (A[r][c] == k) {
						break;
					}
				}
			} else {
				C();
				result++;
				if (r < A.length && A[0].length > c) {
					if (A[r][c] == k) {
						break;
					}
				}
			}
		}
		System.out.println(result);

	}

	public static void R() {
		ArrayList<Integer> list[] = new ArrayList[A.length];
		PriorityQueue<XY> q = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int C = -1;
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < A.length; i++) {
			map = new HashMap<Integer, Integer>();
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != 0) {
					if (map.containsKey(A[i][j])) {
						int value = map.get(A[i][j]);
						map.put(A[i][j], value + 1);
					} else {
						map.put(A[i][j], 1);
					}
				}
			}
			for (int key : map.keySet()) {
				q.add(new XY(key, map.get(key)));
			}
			
			while (!q.isEmpty()) {
				XY xy = q.poll();
				list[i].add(xy.number);
				list[i].add(xy.cnt);
			}
			
			C = Math.max(C, list[i].size());
		}
		int R = A.length;
		A = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < 100; j++) {
				if (j >= list[i].size())
					break;
				A[i][j] = list[i].get(j);
			}
		}
	}

	public static void C() {
		ArrayList<Integer> list[] = new ArrayList[A[0].length];
		PriorityQueue<XY> q = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int R = -1;
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int len=A[0].length;
		for (int i = 0; i < len; i++) {
			map = new HashMap<Integer, Integer>();
			for (int j = 0; j < A.length; j++) {
				if (A[j][i] != 0) {
					if (map.containsKey(A[j][i])) {
						int value = map.get(A[j][i]);
						map.put(A[j][i], value + 1);
					} else {
						map.put(A[j][i], 1);
					}
				}
			}
			for (int key : map.keySet()) {
				q.add(new XY(key, map.get(key)));
			}
			
			while (!q.isEmpty()) {
				XY xy = q.poll();
				list[i].add(xy.number);
				list[i].add(xy.cnt);
			}
			
			R = Math.max(R, list[i].size());
		}
		int C = len;
		A = new int[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < 100; j++) {
				if (j >= list[i].size())
					break;
				A[j][i] = list[i].get(j);
			}
		}

	}

	public static class XY implements Comparable<XY> {
		int number;
		int cnt;

		XY(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(XY o) {
			if (this.cnt == o.cnt) {
				return this.number < o.number ? -1 : 1;
			}
			// TODO Auto-generated method stub
			return this.cnt < o.cnt ? -1 : 1;
		}
	}

}

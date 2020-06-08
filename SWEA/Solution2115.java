package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution2115 {
	static int N, M, C, res;
	static int[][] map;
	static boolean check[][];
	static ArrayList<XY> one[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			res = 0;
			one = new ArrayList[2];
			one[0] = new ArrayList<>();
			one[1] = new ArrayList<>();
			map = new int[N][N];
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			DFS(0);
			System.out.println("#" + t + " " + res);

		}
	}

	public static void DFS(int depth) {
		if (depth == 2) {
			cal();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					if (possible(i, j)) {
						fill(i, j, depth);
						DFS(depth + 1);
						fill2(i, j, depth);
					}
				}
			}
		}

	}

	public static void cal() {
		ArrayList<Integer> list[];
		list = new ArrayList[3];
		list[0] = new ArrayList<>();
		list[1] = new ArrayList<>();
		list[2] = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < M; j++) {
				list[i].add((map[one[i].get(j).y][one[i].get(j).x]));
			}
		}
		Collections.sort(list[0]);
		Collections.sort(list[1]);
		
		DFS(0,list[0],list[1],new boolean[M]);

	}
	
	
	
	public static void DFS(int depth,ArrayList<Integer> list,ArrayList<Integer> list2,boolean []check2) {
		if(depth == M) {
			int ch=0;
			int ch2=0;
			for(int i=0;i<M;i++) {
				if(check2[i]) {
					ch+=list.get(i);
					ch2+=list.get(i)*list.get(i);
				}
			}
			if(ch>C)
				return ;
			DFS2(0,list2,new boolean[M],ch2);
			
			return ;
		}
	
		
			check2[depth]=true;
			DFS(depth+1,list,list2,check2);
			check2[depth]=false;
			DFS(depth+1,list,list2,check2);
		}
	
	
	
	public static void DFS2(int depth,ArrayList<Integer> list,boolean []check3,int res3) {
		if(depth == M) {
			int ch=0;
			int ch2=0;
			for(int i=0;i<M;i++) {
				if(check3[i]) {
					ch+=list.get(i);
					ch2+=list.get(i)*list.get(i);
				}
			}
			if(ch>C)
				return ;
			else {
				res=Math.max(res, ch2+res3);
				return ;
			}
			
		}
	
		
		check3[depth]=true;
			DFS2(depth+1,list,check3,res3);
			check3[depth]=false;
			DFS2(depth+1,list,check3,res3);
	}

	public static boolean possible(int idy, int idx) {

		for (int i = idx; i < idx + M; i++) {
			if (!edge(i, idy))
				return false;
		}

		return true;
	}


	



	public static void fill(int idy, int idx, int depth) {
		int num = 0;
		for (int i = idx; i < idx + M; i++) {
			one[depth].add(new XY(idy, i));
			check[idy][i] = true;
		}

	}

	public static void fill2(int idy, int idx, int depth) {
		int num = 0;
		for (int i = idx; i < idx + M; i++) {
			check[idy][i] = false;
		}
		one[depth] = new ArrayList<>();
	}

	public static boolean edge(int idx, int idy) {
		if (idx < 0 || idx >= N || check[idy][idx])
			return false;

		return true;
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

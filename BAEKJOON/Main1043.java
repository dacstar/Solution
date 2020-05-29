package BAEKJOON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1043 {
	static int parents[];
	static boolean[][] isAble;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int H = s.nextInt();
		if (H == 0) {
			System.out.println(M);
			return;
		} else {
			parents = new int[N+1];
			isAble = new boolean[M][H];
			Arrays.fill(parents, -1);
			ArrayList<Integer> Fact = new ArrayList<Integer>();
			for (int i = 0; i < H; i++) {
				Fact.add(s.nextInt());
			}
			String team[] = new String[M];
			for (int i = 0; i < M; i++) {
				s.nextInt();
				team[i] = s.nextLine().trim();
			}
			int res=0;
			String people[];
			for (String str : team) {
				people = str.split(" ");
				for (int i = 1; i < people.length; i++) {
					union(Integer.parseInt(people[i - 1]), Integer.parseInt(people[i]));
				}
			}
			boolean able;

			for (int i = 0; i < H; i++) {
				int parents = find(Fact.get(i));
				for (int j = 0; j < M; j++) {
					able=true;
					people = team[j].split(" ");
					for(String str : people) {
						if(parents == find(Integer.parseInt(str)))
							able=false;
					}
					isAble[j][i]=able;
				}
			}
			
			
			for(int i=0;i<M;i++) {
				boolean is=true;
				for(int j=0;j<H;j++) {
					is&=isAble[i][j];
				}
				if(is)
					res++;
			}
			System.out.println(res);

		}

	}

	public static int find(int idx) {
		if (parents[idx] < 0)
			return idx;

		return parents[idx] = find(parents[idx]);
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}

	}

}

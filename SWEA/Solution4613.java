package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4613 {
	static int N, M, res;
	static char[][] map;
	static int arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[3];
			map = new char[N][M];
			res = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			DFS(0,0);
			System.out.println("#"+t+" "+res);
		}
	}

	public static void DFS(int depth, int sum) {
		if (sum > N) {
			return;
		}
			if(depth>=3) {
				if(sum==N) {
			
			int result = 0;
			for (int i = 0; i < arr[0]; i++)
				result += cal('W', map[i]);
			for (int i = arr[0]; i < arr[0]+arr[1]; i++)
				result += cal('B', map[i]);
			for (int i = arr[0] + arr[1]; i < N; i++)
				result += cal('R', map[i]);
			 res=Math.min(result, res);
				}
				return ;
			}
		for (int i = 1; i < N - 1; i++) {
			arr[depth] = i;
			DFS(depth + 1, sum + i);
		}
	}

	public static int cal(char word, char ch[]) {
		int count = 0;
		for (int i = 0; i < M; i++)
			if (word == ch[i])
				count++;

		return M - count;
	}

}

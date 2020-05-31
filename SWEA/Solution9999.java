package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9999 {
	static int L, N, result,sum,x,y;
	static boolean check[] = new boolean[100000000];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		for (int t = 1; t <= T; t++) {
			L = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			result = 0;
			x = 0;
			y = 0;
		
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for(int start=x;start<y;start++) {
					check[start]=true;
				}
			}
			 sum=0;
			for(int i=0;i<L;i++) {
				sum+=(check[i] ? 1 : 0);
			}
			result=sum;
			int start=0;
			for(int end=L;end<y;end++) {
				sum-=(check[start++] ? 1 : 0);
				sum+=(check[end] ? 1 : 0);
				result=Math.max(result, sum);
			}
			System.out.println("#" + t + " " + result);
			for (int i = 0; i < y; i++) {
				check[i] = false;
			}
		}
	}
}

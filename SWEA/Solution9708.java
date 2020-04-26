package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9708 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A[] = new int[N];
			int len[] = new int[1000001];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				len[A[i]] = 1;
			}
			Arrays.sort(A);
			for (int i = 0; i < N; i++) {
				int value = A[i];
				for (int j = 2;j*value<=A[N-1]; j++) {
					if(len[value*j]!=0 && len[value]<=len[value*j]) {
						len[j*value]=len[value]+1;
					}
				}
			}
			int res=0;
			for(int i=0;i<len.length;i++) {
				res=Math.max(len[i], res);
			}
			System.out.println("#"+t+" "+res);
		}
	}

}

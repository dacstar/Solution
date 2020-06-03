package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9942_2{
	static int A[];
	static int N,K,res;
	static boolean checkA[], checkB[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			res=0;
			A = new int[N];
			int max=0;
			int d=1;
			int min=0;
			for (int i = 1; i <= N; i++) {
				A[i - 1] = i;
				min+=A[i-1];
				d*=i;
			}
			d=(int)Math.pow(d,2);
			int cnt=1;
			for(int i=N;i>=1;i--,cnt++) {
				max+=Math.max(i, cnt);
			}
			if(K<=min) {
				System.out.println("#"+t+" "+d);
			}else if(K>min && K<=max) {
				int index=(K-min)+1;
				
		
				System.out.println("#"+t+" "+res);
			}else {
				System.out.println("#"+t+" "+0);
			}
			
		}
	}

}

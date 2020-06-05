package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9942 {
	static int A[];
	static int N,K;
	static long res;
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
			for (int i = 1; i <= N; i++) {
				A[i - 1] = i;
			}
			checkA = new boolean[N];
			checkB = new boolean[N];
			DFSA(0,new int[N]);
			long mul=1;
			for(int i=N;i>=1;i--) {
				mul*=i;
			}
			System.out.println("#"+t+" "+res*mul);
		}
	}

	public static void DFSA(int depth,int arr[]) {
		if(depth == N) {
			cal(arr,A);
			return ;
		}
		
		for(int i=0;i<N;i++) {
			if(checkA[i])
				continue;
			checkA[i]=true;
			arr[depth]=A[i];
			DFSA(depth+1,arr);
			checkA[i]=false;
		}

	}

	
	public static void cal(int arr[],int arr2[]) {
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=Math.max(arr[i], arr2[i]);
		}
		if(sum>=K)
			res++;
			
	}

}

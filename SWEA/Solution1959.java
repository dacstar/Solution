package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1959 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int A[] = new int[N];
			int B[] = new int[M];
			if(N>M) {
				int tmp=M;
				M=N;
				N=tmp;
			}
				
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<=M-N;i++) {
				int sum=0;
				for(int j=0;j<N;j++) {
					int value=B[i+j]*A[j];
					sum+=value;
				}
				max=Math.max(sum, max);
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}

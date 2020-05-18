package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		int preSum[] = new int[N+1];
		int res=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		preSum[0]=A[0];
		for(int i=1;i<N;i++) {
			preSum[i]=Math.max(A[i], preSum[i-1]+A[i]);
			res=Math.max(preSum[i], res);
		}
		
		System.out.println(res);
		
	}

}

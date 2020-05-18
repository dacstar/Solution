package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main2512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long num[] = new long[N];
		for (int i = 0; i < N; i++) {
			num[i]=s.nextLong();
		}
		long max=s.nextLong();
		Arrays.sort(num);
		long left=0;
		long ans=0;
		long right=max;
		while(left<=right) {
			long mid=(left+right)/2;
			long sum=0;
			for(int i=0;i<N;i++) {
				if(num[i]<=mid)
					sum+=num[i];
				else
					sum+=mid;
			}
			if(sum<=max) {
				if(mid > num[N-1]) {
					right=mid-1;
					continue;
				}
				ans=mid;
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(ans);
		
		
	}

}

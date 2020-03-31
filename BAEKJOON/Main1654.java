package BAEKJOON;

import java.util.Scanner;

public class Main1654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int M=s.nextInt();
		long len[] = new long[N];
		long max=0;
		for(int i=0;i<N;i++) {
			len[i]=s.nextInt();
			if(max<len[i])
				max=len[i];
		}
		long left=1;
		long res=0;
		long right=max;
		while(left<=right) {
			long mid=(left+right)/2;
				int count=0;
				for(int i=0;i<N;i++) {
					count+=(len[i]/mid);
				}
				if(count>=M) {
					left=mid+1;
					res=mid;
				}else {
					right=mid-1;
				}
		}
		System.out.println(res);
		
		
	}

}

package BAEKJOON;

import java.util.Scanner;

public class Main2343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int M=s.nextInt();
		int sum=0;
		int A[] = new int[N];
		for(int i=0;i<N;i++) {
			A[i]=s.nextInt();
			sum+=A[i];
		}
		int left=A[N-1];
		int res=0;
		int right=sum;
		while(left<=right) {
			int mid=(left+right)/2;
			int len=0;
			int m=0;
			for(int i=0;i<N;i++) {
				if(len+A[i]>mid) {
					m++;
					len=0;
				}
				len+=A[i];
			}
			if(len !=0) m++;
			if(m<=M) {
				right=mid-1;
				res=mid;
			}else{
				left=mid+1;
			}
		}
		System.out.println(res);
		
	}

}

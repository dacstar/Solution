package BAEKJOON;

import java.util.Scanner;

public class Main2850 {
	//백준 나무자르기 -> 이분탐색
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		long M=s.nextInt();
		long arr[] = new long[N];
		long max=0;
		for(int i=0;i<N;i++) {
			arr[i]=s.nextInt();
			if(max<arr[i])
				max=arr[i];
		}
		long left=0;
		long height=0;
		long right=max;
		while(left<=right){
			long mid=(left+right)/2;
			long count=0;
			for(int i=0;i<N;i++) {
				if(arr[i]>mid) {
					count+=(arr[i]-mid);
				}
			}
			if(count>=M) {
				height=mid;
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(height);
	}

}

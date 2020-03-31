package BAEKJOON;

import java.util.Scanner;

public class Main3079 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		long M=s.nextInt();
		int arr[] = new int[N];
		long max=0;
		for(int i=0;i<N;i++) {
			arr[i]=s.nextInt();
			if(max<arr[i])
				max=arr[i];
		}
		long left=1;
		long res=0;
		long right=max*M;
		while(left<=right) {
			long mid=(left+right)/2;
			int people=0;
			for(int i=0;i<arr.length;i++) {
				people+=(mid/arr[i]);
			}
			if(people>=M) {
				res=mid;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		System.out.println(res);
	}

}

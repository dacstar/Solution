package SWEA;

import java.util.Scanner;

public class Solution1285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = s.nextInt();
			int sum=0;
			int arr[] = new int[100001];
			for (int i = 0; i < N; i++) {
				int num=s.nextInt();
				sum=Math.abs(num-0);
				arr[sum]++;
			}
			for(int i=0;i<arr.length;i++) {
				if(arr[i]!=0) {
				System.out.println("#"+t+" "+i+" "+arr[i]);
				break;
				}
			}
		}
	}

}

package SWEA;

import java.util.Scanner;

public class Solution9778 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int arr[] = new int[12];
			int N=s.nextInt();
			for(int i=2;i<=9;i++) {
				arr[i]=4;
			}
			arr[11]=4;
			arr[10]=16;
			int sum=0;
			for(int i=0;i<N;i++) {
				int value=s.nextInt();
				arr[value]--;
				sum+=value;
			}
			int val=Math.abs(21-sum);
			int min=0;
			int max=0;
			for(int i=0;i<arr.length;i++) {
				if(val<i) {
					max+=arr[i];
				}else {
					min+=arr[i];
				}
			}
			if(max>=min) {
				System.out.println("#"+t+" "+"STOP");
			}else {
				System.out.println("#"+t+" "+"GAZUA");
			}
			
		}
	}

}

package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main2229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int num[] = new int[N];
		for(int i=0;i<N;i++) {
			num[i]=s.nextInt();
		}
		int left=0;
		int right=N-1;
		int sum=0;
		Arrays.sort(num);
		
		while(left<right) {
			sum+=num[right]-num[left];
			left++;
			right--;
		}
		System.out.println(sum);
	}

}

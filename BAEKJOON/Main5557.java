package BAEKJOON;

import java.util.Scanner;

public class Main5557 {
	static long arr[];
	static long count=0;
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		arr = new long[N];
		long num=0;
		
		for(int i=0;i<N;i++) {
			num=s.nextLong();
			arr[i]=num;
		}
		check = new boolean[N-1];
		DFS(0,N,0,num);
		System.out.println(count);
	}
	
	public static void DFS(int depth,long N,long sum,long number) {
		
		if(depth == N-1) {
			if(number == sum) {
				count++;
			}
			return ;
		}
		if(sum <0 || sum >20) {
			return ;
		}
				DFS(depth+1,N,sum+arr[depth],number);
				DFS(depth+1,N,sum-arr[depth],number);
		}
	}



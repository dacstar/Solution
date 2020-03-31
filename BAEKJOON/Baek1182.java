package BAEKJOON;

import java.util.Scanner;

public class Baek1182 {
	static boolean visit[];
	static int N,S,res;
	static int arr[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		S=s.nextInt();
		res=0;
		arr = new int[N];
		visit= new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i]=s.nextInt();
		}
		int cnt=0;
		powerset(0,N);
		cnt=res;
		res=0;
		powerset(N/2,N);
		cnt+=res;
		System.out.println(cnt);
	}
	
	public static void powerset(int depth,int n) {
		if(depth == n) {
			int sum=0;
			boolean flge=false;
			for(int i=0;i<depth;i++) {
				if(visit[i]) {
					sum+=arr[i];
					flge=true;
				}
			}
			if(flge && sum ==S)
				res++;
			
			return ;
		}
		
		
		visit[depth]=false;
		powerset(depth+1,n);
		visit[depth]=true;
		powerset(depth+1,n);
	}
	
	

}

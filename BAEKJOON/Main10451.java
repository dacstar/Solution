package BAEKJOON;

import java.util.Scanner;

public class Main10451 {
	static int N;
	static int arr[];
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int t=1;t<=T;t++) {
			N=s.nextInt();
			arr = new int[N+1];
			check  = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				arr[i]=s.nextInt();
			}
			int cnt=0;
			for(int i=1;i<=N;i++) {
				if(!check[i]) {
					cnt++;
					DFS(i);
				}
			}
			System.out.println(cnt);
			
		}
	}
	
	public static void DFS(int depth) {
		if(check[depth])
			return ;
		else {
			check[depth]=true;
			DFS(arr[depth]);
		}
		
	}

}

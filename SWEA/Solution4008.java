package SWEA;

import java.util.Scanner;

public class Solution4008 {
	static int N, max, min;
	static int arr[], num[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			N = s.nextInt();
			arr = new int[4];
			num = new int[N];
			for (int i = 0; i < 4; i++) {
				arr[i] = s.nextInt();
			}
			for (int i = 0; i < N; i++) {
				num[i] = s.nextInt();
			}
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			DFS(1,num[0]);
			System.out.println("#"+t+" "+(max-min));
		}
	}

	public static void DFS(int depth, int value) {
		if (depth == N) {
			max = Math.max(value, max);
			min = Math.min(value, min);
			return ;
		}
		
		if(arr[0] >0) {
			arr[0]--;
			DFS(depth+1,value+num[depth]);
			arr[0]++;
		}if(arr[1] >0) {
			arr[1]--;
			DFS(depth+1,value-num[depth]);
			arr[1]++;
			
		} if(arr[2] >0) {
			arr[2]--;
			DFS(depth+1,value*num[depth]);
			arr[2]++;
			
		}if(arr[3] >0) {
			arr[3]--;
			DFS(depth+1,value/num[depth]);
			arr[3]++;
			
		}

	}

}

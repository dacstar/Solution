package BAEKJOON;

import java.util.Scanner;

public class Main3020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int H = s.nextInt();
		int top[] = new int[H + 1];
		int bot[] = new int[H + 1];
		int handle[] = new int[H+1];
		for (int i = 0; i < N / 2; i++) {
			bot[s.nextInt()]++;
			top[H - s.nextInt() + 1]++;
		}
		for (int i = 1; i < top.length-1; i++) {
			top[i+1]+=top[i];
		}
		for(int i=bot.length-1;i>=1;i--) {
			bot[i-1]+=bot[i];
		}
		for (int i = 1; i <= H; i++) {
			handle[i]=top[i]+bot[i];
		}
		int res=Integer.MAX_VALUE;
		for(int i=1;i<handle.length;i++) {
			res=Math.min(res, handle[i]);
			
		}
		int count=0;
		for(int i=1;i<handle.length;i++) {
			if(res == handle[i])
				count++;
		}
		System.out.println(res+" "+count);
		
		
		
		

	}
}

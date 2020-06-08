package SWEA;

import java.util.Scanner;

public class Solution2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		System.out.print("1"+" ");
		for(int i=1;i<=N;i++) {
			System.out.print((int)Math.pow(2, i)+" ");
		}
	}

}

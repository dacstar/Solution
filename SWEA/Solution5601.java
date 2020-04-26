package SWEA;

import java.util.Scanner;

public class Solution5601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=s.nextInt();
			System.out.print("#"+t+" ");
			for(int i=0;i<N;i++) {
				System.out.print(1+"/"+N+" ");
			}
			System.out.println();
		}
	}

}

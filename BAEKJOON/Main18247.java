package BAEKJOON;

import java.util.Scanner;

public class Main18247 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++) {
			int N=s.nextInt();
			int M=s.nextInt();
			if(N<12 || M<4) {
				System.out.println("-1");
				continue;
			}
			int sum=(11*M)+4;
			System.out.println(sum);
			
			
			
		}
	}

}

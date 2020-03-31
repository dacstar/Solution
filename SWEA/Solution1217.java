package SWEA;

import java.util.Scanner;

public class Solution1217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int N=s.nextInt();
			int num=s.nextInt();
			int mul=s.nextInt();
			System.out.println("#"+t+" "+(int)Math.pow(num, mul));
			
		}
	}

}

package SWEA;

import java.util.Scanner;

public class Solution1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			long P=s.nextInt();
			long Q=s.nextInt();
			long R=s.nextLong();
			long S=s.nextLong();
			long W=s.nextLong();
			long sum1=P*W;
			long sum2=0;
			if(W<=R) {
				sum2=Q;
			}else {
				long r=W-R;
				sum2+=Q;
				sum2+=S*r;
			}
			long min=0;
			min=Math.min(sum1, sum2);
			System.out.println("#"+t+" "+min);
			
		}
	}

}

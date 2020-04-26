package SWEA;

import java.util.Scanner;

public class Solution8382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			int dis1 = Math.abs(x2 - x1);
			int dis2 = Math.abs(y2 - y1);
			int min = Math.min(dis1, dis2);
			int max = Math.max(dis1, dis2);
			int res = 0;
			if (dis1 == dis2)
				res = 2 * dis2;
			else {
				if (dis1 > dis2)
					res = 2 * dis2;
				else
					res = 2 * dis1;

				int line = max - min;
				if (line % 2 == 0)
					res += 2 * line;
				else
					res += 2 * line - 1;
			}
			System.out.println("#"+t+" "+res);
		}

	}

}

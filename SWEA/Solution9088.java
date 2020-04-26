package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution9088 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = s.nextInt();
			int K = s.nextInt();
			int Dia[] = new int[N];
			int res = -11111;
			for (int i = 0; i < N; i++) {
				Dia[i] = s.nextInt();
			}
			Arrays.sort(Dia);
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(Dia[i]);
				for (int j = i+1; j < N; j++) {
					if (Math.abs(Dia[i] - Dia[j]) <= K) {
						boolean check = false;
						for (int k = 0; k < list.size(); k++) {
							if (Math.abs(list.get(k) - Dia[j]) <= K) {
								check = true;
							} else {
								check = false;
								break;
							}
						}
						if (check)
							list.add(Dia[j]);
					}
				}
				res = Math.max(res, list.size());
			}
			System.out.println("#" + t + " " + res);
		}

	}
}

package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5603 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = s.nextInt();
			int arr[] = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = s.nextInt();
				sum += arr[i];
			}
			int res = 100000;
			int avg = sum / N;
			for (int i = 0; i < N; i++) {
				res += (Math.abs(arr[i] - avg));
			}
			System.out.println("#" + t + " " + (res / 2));
		}
	}

}

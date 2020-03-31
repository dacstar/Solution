package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main1475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[11];
		Scanner s = new Scanner(System.in);
		String str= s.next();
		str=str.replace("9", "6");
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)-'0']++;
		}
		arr[6]=arr[6]/2 +arr[6]%2;
		Arrays.sort(arr);
		System.out.println(arr[10]);
	}

}

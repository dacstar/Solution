package BAEKJOON;

import java.util.Scanner;

public class Main1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int work[] = new int[26];
		Scanner s = new Scanner(System.in);
		String str=s.next().toUpperCase();
		int max=0;
		char result='?';
		for(int i=0;i<str.length();i++) {
			work[str.charAt(i)-65]++;
			if(max<work[str.charAt(i)-65]) {
				max=work[str.charAt(i)-65];
				result=str.charAt(i);
			}else if(max == work[str.charAt(i)-65]) {
				result='?';
			}
		}
		System.out.println(result);

	}

}

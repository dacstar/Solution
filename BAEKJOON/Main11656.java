package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str=s.next();
		String str2[] = new String[str.length()];
		for(int i=0;i<str.length();i++) {
			str2[i]=str.substring(i,str.length());
		}
		Arrays.sort(str2);
		for(int i=0;i<str.length();i++) {
			System.out.println(str2[i]);
		}
		
	}

}

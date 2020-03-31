package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int al[] = new int['z'-'0'+1];
		Scanner s = new Scanner(System.in);
		Arrays.fill(al, -1);
		String str=s.next();
		for(int i=0;i<str.length();i++) {
			if(al[str.charAt(i)-'0'] == -1) {
				al[str.charAt(i)-'0']=i;
			}
		}
		
		for(int i='a'-'0';i<='z'-'0';i++) {
			System.out.print(al[i]+" ");
		}
		
	}

}

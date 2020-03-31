package BAEKJOON;

import java.util.Scanner;

public class Main1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A=s.next();
		int res=1000;
		String B=s.next();
		for(int i=0;i<=B.length()-A.length();i++) {
			int cnt=0;
			for(int j=0;j<A.length();j++) {
				if(B.charAt(i+j) != A.charAt(j))
					cnt++;
			}
			res=Math.min(cnt, res);
		}
		System.out.println(res);
		
	}

}

package BAEKJOON;

import java.util.Scanner;

public class Main3986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int M=s.nextInt();
		String str=s.next();
		String A="IOI";
		int res=0;
		int cnt=0;
		for(int i=1;i<M-1;i++) {
			if(str.charAt(i-1) == 'I' && str.charAt(i)=='O' && str.charAt(i+1)== 'I') {
				cnt++;
				if(cnt==N) {
					res++;
					cnt--;
				}
				i++;
			}else {
				cnt=0;
			}
	
		}
		System.out.println(res);
	}

}

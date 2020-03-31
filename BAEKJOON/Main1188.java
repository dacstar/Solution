package BAEKJOON;

import java.util.Scanner;

public class Main1188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N =s.nextInt();
		int M=s.nextInt();
		System.out.println(M-gcd(N,M));
	}
	
	public static int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	        int tmp = a;
	        a = b;
	        b = tmp%b;
	    }
	    return a;
	}

}

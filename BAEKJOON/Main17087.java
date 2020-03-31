package BAEKJOON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main17087 {
	
	static int N,S,MAX,MAX2;
	static int A[];
	static boolean B[];
	static int cnt;
	static TreeSet<Integer> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		S=s.nextInt();
		A = new int[N];
	
	
		 map = new TreeSet<Integer>();
		for(int i=0;i<N;i++) {
			A[i]=Math.abs(S-s.nextInt());
		}
		MAX=A[0];
		for(int i=0;i<N;i++) {
			MAX=gcd(MAX,A[i]);
		}
	
		

		System.out.println(MAX);
	}
	
	static int gcd(int a,int b) {
		
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
		
	}

}

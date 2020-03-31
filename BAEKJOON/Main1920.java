package BAEKJOON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main1920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		HashSet<Integer> hash = new HashSet<Integer>();
		int N=s.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			hash.add(s.nextInt());
		}
		int M=s.nextInt();
		for(int i=0;i<M;i++) {
			if(hash.contains(s.nextInt())) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
	}

}

package BAEKJOON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main10815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i=0;i<N;i++) {
		hash.add(s.nextInt());	
		}
		int M=s.nextInt();
		for(int i=0;i<M;i++) {
			if(hash.contains(s.nextInt())) {
				System.out.print("1"+" ");
			}else {
				System.out.print("0"+" ");
			}
		}
	
		
		
	}

}

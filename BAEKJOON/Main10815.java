package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer,Integer> hash = new HashMap<>();
		for(int i=0;i<N;i++) {
			int value=Integer.parseInt(st.nextToken());
			if(hash.containsKey(value)) {
				int idx=hash.get(value);
				hash.put(value, idx+1);
			}else {
				hash.put(value, 1);
			}
		}
		int M=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int value=Integer.parseInt(st.nextToken());
			if(hash.containsKey(value)) {
				System.out.print(hash.get(value)+" ");
			}else {
				System.out.print("0"+" ");
			}
		}
		
	
		
		
	}

}

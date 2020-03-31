package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1221 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			int N=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				String str=st.nextToken();
				if(str.contains("ZRO")) {
					list2.add(0);
				}else if(str.contains("ONE")) {
					list2.add(1);
				}else if(str.contains("TWO")) {
					list2.add(2);
				}else if(str.contains("FOR")) {
					list2.add(4);
				}else if(str.contains("FIV")) {
					list2.add(5);
				}else if(str.contains("SIX")) {
					list2.add(6);
				}else if(str.contains("SVN")) {
					list2.add(7);
				}else if(str.contains("EGT")) {
					list2.add(8);
				}else if(str.contains("NIN")) {
					list2.add(9);
				}else {
					list2.add(3);
				}
			}
			
			
			Collections.sort(list2);
			int space=list2.get(0);
			System.out.print("#"+t+" ");
			for(int i=0;i<list2.size();i++) {
				if(space!=list2.get(i)) {
					System.out.println();
					space=list2.get(i);
				}
				if(list2.get(i)==0) {
					System.out.print("ZRO"+" ");
				}else if(list2.get(i)==1){
					System.out.print("ONE"+" ");
				}else if(list2.get(i)==2){
					System.out.print("TWO"+" ");
				}else if(list2.get(i)==3){
					System.out.print("THR"+" ");
				}else if(list2.get(i)==4){
					System.out.print("FOR"+" ");
				}else if(list2.get(i)==5){
					System.out.print("FIV"+" ");
				}else if(list2.get(i)==6){
					System.out.print("SIX"+" ");
				}else if(list2.get(i)==7){
					System.out.print("SVN"+" ");
				}else if(list2.get(i)==8){
					System.out.print("EGT"+" ");
				}else if(list2.get(i)==9){
					System.out.print("NIN"+" ");
				}
			}
				
		}
	}

}

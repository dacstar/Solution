package BAEKJOON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main10816 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>(); 
		for(int i=0;i<N;i++) {
		list.add(s.nextInt());	
		}
		Collections.sort(list);
		int M=s.nextInt();
		for(int i=0;i<M;i++) {
			list2.add(s.nextInt());
		}
		for(int i=0;i<M;i++) {
			int left=0;
			int res=0;
			int find=list2.get(i);
			int right=list.size()-1;
			while(left<=right) {
				int mid=(left+right)/2;
				if(list.get(mid)<find) {
					left=mid+1;
				}else if(list.get(mid)==find) {
					res=find;
					break;
				}else {
					right=mid-1;
				}
			}
			if(res!=0) {
				System.out.print("1"+" ");
			}else {
				System.out.print("0"+" ");
			}
		}
	}
	

}

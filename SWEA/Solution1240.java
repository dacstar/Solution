package SWEA;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution1240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T  = s.nextInt();
		for(int t=1;t<=T;t++) {
			PriorityQueue<Jc> pq = new PriorityQueue<>();
			int N=s.nextInt();
			HashSet<String> st = new HashSet<String>();
			for(int i=0;i<N;i++) {
				st.add(s.next());
			}
			for(String str : st) {
				pq.add(new Jc(str));
			}
			System.out.println("#"+t);
			while(!pq.isEmpty()) {
				System.out.println(pq.poll().str);
				
			}
			
		}
	}
	
	static class Jc implements Comparable<Jc> {
		String str;
			Jc(String str){
				this.str=str;
			}
			@Override
			public int compareTo(Jc o) {
				if(this.str.length() == o.str.length()) {
						
					return this.str.compareTo(o.str);
					
				}
				// TODO Auto-generated method stub
				return this.str.length() > o.str.length() ? 1 : -1;
			}
	}

}

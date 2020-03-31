package SWEA;

import java.util.Scanner;

public class Solution1213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int T = s.nextInt();
			String word=s.next();
			String str=s.next();
			int total=0;
			int start=0;
			while(start<str.length()){
				int find=str.indexOf(word, start);
				if(find!=-1) {
					start=find+1;
					total++;
				}else
					break;
			}
			System.out.println("#"+t+" "+total);
		}
	}
}

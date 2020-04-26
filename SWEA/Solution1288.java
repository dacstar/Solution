package SWEA;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution1288 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = s.nextInt();
			int result=0;
			TreeSet<Integer> tree = new TreeSet<Integer>(); 
			while(true) {
				if(tree.size()==10)
					break;
				result++;
				String str=(result*N)+"";
				for(int i=0;i<str.length();i++) {
					tree.add(str.charAt(i)-'0');
				}
			}
			System.out.println("#"+t+" "+result*N);
		}
	}

}

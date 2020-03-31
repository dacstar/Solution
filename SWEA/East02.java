package SWEA;

import java.util.Arrays;
import java.util.HashMap;

public class East02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[] A = { 12, 21, 34, 999999991, 199999999 };
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int max=0;
		for(int i=0;i<A.length;i++) {
			int N=A[i];
			int number=makeDigit(N);
			if(map.containsKey(number)) {
				max=Math.max(map.get(number)+A[i], max);
				if(map.get(number) < A[i]) {
					map.put(number, A[i]);
				}
			}else {
				map.put(number, A[i]);
			}
		}
		System.out.println(max);
	}
	  public static int makeDigit(int N) {
	      int res = 0;
	      String str = N+"";
	      for(int i = 0;i<str.length();i++) {
	         res += str.charAt(i) - '0';
	      }
	      return res;
	   }

}

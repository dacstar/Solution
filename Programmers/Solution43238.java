package Programmers;

import java.util.Arrays;

public class Solution43238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int times[]= {7,10};
		int N=6;
		long left=0;
		Arrays.sort(times);
        long right=(long)times[times.length-1]*(long)N;
        long res=0;
		while(left<=right) {
			int cnt=0;
			long mid=(right+left)/2;
			for(int i=0;i<times.length;i++) {
				cnt+=(mid)/times[i];
			}
			if(cnt<N) {
				left=mid+1;
			}else {
				res=mid;
				right=mid-1;
			}
		}
		System.out.println(res);
	}

}

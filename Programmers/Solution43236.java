package Programmers;

import java.util.Arrays;

public class Solution43236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int distance=25;
		int rocks[]= {2,14,11,21,17};
		int dis[]= new int[rocks.length+1];
		int left=1;
		int answer=0;
		int right=25;
		Arrays.sort(rocks);
		while(left<=right) {
			int mid=(left+right)/2;
			if(makedistance(mid,rocks,2)>2) {
				answer=mid;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	static int makedistance(int distance,int []rocks,int n) {
		int cnt=0;
		int last=0;
		for(int i=0;i<rocks.length;i++) {
			int gap= (i !=rocks.length-1 ? rocks[i] -last : distance-rocks[i]);
			if(gap <distance) {
				cnt++;
			}else {
				last=rocks[i];
			}
		}
		return cnt;
	}

}

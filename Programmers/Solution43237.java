package Programmers;

import java.util.Arrays;

public class Solution43237 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int budgets[] = {120,110,140,150};
		int M=485;
		int ans=0;
		Arrays.sort(budgets);
		int right=budgets[budgets.length-1];
		int left=0;
		while(left<=right) {
			int answer=0;
			int mid=(left+right)/2;
			for(int value : budgets) {
				if( value<mid) {
					answer+=value;
				}else {
					answer+=mid;
				}
			}
			
			if(answer>M) {
				right=mid-1;
			}else {
				ans=answer;
				left=mid+1;
			}
		}
		
	}

}

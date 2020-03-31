package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution0305 {
	static int x,N;
	static int res;
	static int []dp;
	static int []button;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  =Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			button = new int[10];
			StringTokenizer st = new  StringTokenizer(br.readLine());
			   for (int i = 0; i < 10; i++) {
				   button[i] = Integer.parseInt(st.nextToken());
	            }
			x=Integer.parseInt(br.readLine());
			dp = new int[x+10];
			   for (int i = 0; i < 10; i++) {
	                if(button[i] == 1) {
	                    dp[i] = 1;
	                }
	            }
			res=sol(x);
			System.out.print("#"+t+" ");
			if(Integer.MAX_VALUE == res)
				System.out.print("-1");
			else
				System.out.println(res);
		}
	}
	
	static int sol(int num) {
		 if(dp[num] != 0) return dp[num];
		 dp[num] = cal(num);
		for(int i=1;i<=(int)Math.sqrt(num);i++) {
			if(num%i==0) {
				int num1=sol(i);
				int num2=sol(num/i);
				dp[num]=Math.min(dp[num], num1 == Integer.MAX_VALUE || num2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : num1+num2+1);
			}
			
		}
		
		
		return dp[num];
	}
	
	
	static int cal(int num) {
		int cnt=0;
		while(num>0) {
			int temp=num%10;
			if(button[temp] ==0) return Integer.MAX_VALUE;
		     
            num /= 10;
			cnt++;
		}
		
		
		
		return cnt;
	}

	



}

package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main1106 {
   static int C, N;
   static int[] dp = new int[1001];
   
   
   
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      C=s.nextInt();
      N=s.nextInt();
      Arrays.fill(dp,Integer.MAX_VALUE);
      for(int i=0;i<N;i++) {
    	  int money=s.nextInt();
    	  int people=s.nextInt();
    	  dp[people]=money;
      }
      
      for(int i=1;i<=1000;i++) {
    	  int sum=Integer.MAX_VALUE;
    	  for(int j=1;j<=i/2;j++) {
    		  if(dp[j] == Integer.MAX_VALUE || dp[i-j] == Integer.MAX_VALUE)
    			  continue;
    		  sum=Math.min(sum, dp[j]+dp[i-j]);
    	  }
    	  dp[i]=Math.min(dp[i], sum);
      }
      
      int result = Integer.MAX_VALUE;
      for (int i = C; i < dp.length; i++) {
         result = Math.min(dp[i], result);
      }
      System.out.println(result);

   }

}
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N=Integer.parseInt(br.readLine());
			int str[] = new int[N];
			long max=-1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				str[i]=Integer.parseInt(st.nextToken());
			}
			int end=1;
			String sum;
			boolean check=false;
			
			for(int i=0;i<N-1;i++) {
				sum="";
				
				for(int j=i+1;j<N;j++) {
					sum=(str[i]*str[j])+"";
					for(int len=0;len<sum.length()-1;len++) {
						check=false;
						int num1=sum.charAt(len)-'0';
						int num2=sum.charAt(len+1)-'0';
						if(num1 != num2-1) {
							check=true;
							break;
						}
					}
					if(check) {
						continue;
					}else {
						max = Math.max(max, Integer.parseInt(sum));
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}

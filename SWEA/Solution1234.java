package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1234 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str=st.nextToken();
			while(true) {
				boolean check=false;
				for(int i=0;i<str.length()-1;i++) {
					if(str.charAt(i) == str.charAt(i+1)) {
						check=true;
						str=str.substring(0,i) + str.substring(i+2,str.length());
					}
				}
				if(!check)
					break;
			}
			System.out.println("#"+t+" "+str);
		}

	}
}


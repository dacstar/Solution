package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			HashMap<String,Integer> hash = new HashMap<String, Integer>();
			int N=Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str=st.nextToken();
				String str2=st.nextToken();
				if(hash.containsKey(str2)) {
					hash.put(str2, hash.get(str2)+1);
				}else {
					hash.put(str2, 1);
				}
			}
			int res=1;
			for(int value : hash.values()) {
				res*=(value+1);
			}
			System.out.println(res-1);
		}
	}

}

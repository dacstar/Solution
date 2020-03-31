package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution9480 {
	static boolean al[];
	static boolean check[];
	static ArrayList<String> str;
	static HashSet<Character> hash;
	static int N,res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {	
			 N=Integer.parseInt(br.readLine());
			 hash = new HashSet<>();
			al =new boolean['z'+1];
			check = new boolean[N];
			 res=0;
			int cnt=0;
			str = new ArrayList<>();
			for(int i=0;i<N;i++) {
				str.add(br.readLine());
			}

			DFS(0,0,"");
			System.out.println("#"+t+" "+res);
		}

	}
	
	static void DFS(int idx,int depth,String str2) {

		if(str2.length() !=0) {
			for(int i=0;i<str2.length();i++) {
				hash.add(str2.charAt(i));
				if(hash.size()==26) {
					 res++;
					 hash = new HashSet<>();
					 return ;
				}
			}
			 hash = new HashSet<>();
		}
		
		if(depth ==N) {
			for(int i=0;i<str2.length();i++) {
				hash.add(str2.charAt(i));
				if(hash.size()==26) {
					 res++;
					 hash = new HashSet<>();
					 return ;
				}
			}
			 hash = new HashSet<>();
			return ;
		}
		
		
		for(int i=idx;i<N;i++) {
			if(check[i])
				continue;
			check[i]=true;
			String str3=str2;
			DFS(i,depth+1,str3+=str.get(i));
			check[i]=false;
		}
		
	}

}

package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class Main15686 {
	static ArrayList<XY> home;
	static ArrayList<XY> ch;
	static int map[][];
	static boolean visit[];
	static int M,N,res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		res=10000000;
		home =new ArrayList<>();
		visit = new boolean[13];
		ch =new ArrayList<>();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int num=s.nextInt();
				if(num==1)
					home.add(new XY(i+1,j+1,0));
				else if(num==2)
					ch.add(new XY(i+1,j+1,0));
				map[i][j]=num;
			}
		}
		
		
			DFS(0,0);
		
		System.out.println(res);
		
		
		
		
	}
	
	public static void DFS(int depth,int idx) {
		if(depth == M) {
			for(int i=0;i<home.size();i++) {
				int sum=1000;
				for(int j=0;j<ch.size();j++) {
					if(visit[j])
					sum=Math.min(sum, Distance(i, j));
				}
				home.get(i).cnt=sum;
			}
			int cnt=0;
			for(int i=0;i<home.size();i++) {
				cnt+=home.get(i).cnt;
			}
			res=Math.min(cnt, res);
			
			return ;
		}
		
		for(int i=idx;i<ch.size();i++) {
			if(visit[i])
				continue;
			visit[i]=true;
			DFS(depth+1,i);
			visit[i]=false;
		}
		
		
	}
	
	
	static class XY{
		int r;
		int c;
		int cnt;
		XY(int r,int c,int cnt){
				this.r=r;
				this.c=c;
				this.cnt=cnt;
			}
	}
	
	static int Distance(int home1,int ch1) {
		
		return Math.abs(home.get(home1).r - ch.get(ch1).r) + Math.abs(home.get(home1).c - ch.get(ch1).c);
	}

}

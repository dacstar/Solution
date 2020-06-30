package Programmers;

import java.util.Arrays;

public class 카카오_외벽점검 {
	static boolean visit[];
	static int choice[];
	static int N,res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=12;
		N=n;
		res=Integer.MAX_VALUE;
		int weak[]= {1,3,4,9,10};
		int dist[]= {3,5,7};
		visit = new boolean[dist.length];
		choice = new int[dist.length];
		DFS(0,dist,weak);
		System.out.println(res);
		
	}
	
	public static void DFS(int depth,int dist[],int weak[]) {
		if(depth == visit.length) {
			wallcheck(dist,weak);
			return ;
		}
		
		for(int i=0;i<visit.length;i++) {
			if(visit[i])
				continue;
			visit[i]=true;
			choice[depth]=dist[i];
			DFS(depth+1,dist,weak);
			visit[i]=false;
		}
	}
	
	public static void wallcheck(int dist[],int weak[]) {
		int line[] = new int[weak.length];
	
		for(int j=0;j<weak.length;j++) {
			line = rotate(j,weak);
			int cnt=0;
			int start=0;
			boolean check[] = new boolean[weak.length];
			for(int i=0;i<choice.length;i++) {
				int dis=0;
				if(start == line.length)
					break;
				for(int k=0;k<line.length;k++) {
					if(check[k])
						continue;
				
					
					if(dis == 0) {
						dis=line[k];
						check[k]=true;
						cnt++;
						start++;
					}else {
						if(dis+choice[i] >=line[k]) {
							check[k]=true;
							start++;
						}else {
							break;
						}
					}
				}
			}
			res=Math.min(cnt, res);
		}
	}
	
	public static int []rotate(int idx,int weak[]) {
		int line[] = new int[weak.length];
		line[0]=weak[idx];
		
		for(int i=1;i<line.length;i++) {
			if(i == idx) {
				if(  weak[0] - weak[idx] <0) {
					line[idx]=weak[0]+N;
				}else {
					line[idx]=weak[0];
				}
				continue;
			}
			
			if(weak[i] - weak[idx] <0) {
				line[i]=weak[i]+N;
			}else {
				line[i]=weak[i];
			}
		}
		Arrays.sort(line);
		return line;
	}

}

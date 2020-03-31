package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18809 {
	static int N,M,G,R,flower;
	static int map[][];
	static int color[];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		color = new int[2];
		flower=0;
		G=Integer.parseInt(st.nextToken());
		color[0]=G;
		R=Integer.parseInt(st.nextToken());
		color[1]=R;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,0);
		System.out.println(flower);
	}
	
	static void DFS(int depth,int idx) {
		if(depth == G+R) {
			BFS();
			//print();
			return ;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					for(int c=idx;c<2;c++) {
						if(color[c]>0) {
							color[c]--;
							map[i][j]=c+3;
							DFS(depth+1,c);
							map[i][j]=2;
							color[c]++;
						}
					}
				}
			}
		}
	}
	
	static void BFS() {
		int temp[][] = new int[N][M];
		int visit[][] = new int[N][M];
		Queue<Air> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j]=map[i][j];
				if(temp[i][j]==3 || temp[i][j]==4)
					q.add(new Air(i,j,temp[i][j],0));
			}
		}
		int cnt=0;
		while(!q.isEmpty()) {
			Air air=q.poll();
			for(int d=0;d<4;d++) {
				int tmpy=dy[d]+air.y;
				int tmpx=dx[d]+air.x;
				if(check(tmpy,tmpx) && temp[tmpy][tmpx] !=0) {
					if(air.cnt != visit[tmpy][tmpx] && temp[tmpy][tmpx]>2 && air.color != temp[tmpy][tmpx]) {
						if(visit[tmpy][tmpx] ==air.cnt+1 ) {
							temp[tmpy][tmpx]=-1;
							visit[tmpy][tmpx]=-1;
							cnt++;
							continue;
						}
					}else if(temp[tmpy][tmpx]==1) {
							temp[tmpy][tmpx]=air.color;
							visit[tmpy][tmpx]=air.cnt+1;
							q.add(new Air(tmpy,tmpx,air.color,air.cnt+1));
					}
					
				}
			}
		}
	
		
		
		flower=Math.max(cnt, flower);
		
	}
	
	public static boolean check(int y,int x){
		if(y<0 || y>=N || x<0 || x>=M)
			return false;
		
		return true;
	}
	
	
	public static class Air{
		int y;
		int x;
		int color;
		int cnt;
			Air(int y,int x,int color,int cnt){
				this.y=y;
				this.x=x;
				this.color=color;
				this.cnt=cnt;
			}
		
		
	}
	
	
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

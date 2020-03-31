package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {

	static int N,M,MAX;
	static int map[][];
	static int temp[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		MAX=0;
		for(int i = 0 ; i< N ; i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< M ; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		DFS(0);
		System.out.println(MAX);
		
		
	}
	
	static void DFS(int depth) {
		if(depth == 3) {
			BFS();
			MAX=Math.max(sum(), MAX);
			return ;
		}
		
		for(int i = 0 ; i < N ;i++) {
			for(int  j = 0 ; j< M ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	
	static void BFS() {
		temp = new int[N][M];
		Queue<XY> q =new LinkedList<>(); 
		for(int i = 0 ; i < N ;i++) {
			for(int  j = 0 ; j< M ; j++) {
				temp[i][j]=map[i][j];
				if(temp[i][j]==2)
					q.add(new XY(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			XY xy=q.poll();
			for(int d=0;d<4;d++) {
				int tmpy=xy.y+dy[d];
				int tmpx=xy.x+dx[d];
				if(check(tmpy,tmpx) && temp[tmpy][tmpx]==0) {
					temp[tmpy][tmpx]=2;
					q.add(new XY(tmpy,tmpx));
				}
			}
		}
		
	
		
	}
	
	static boolean check(int y,int x) {
		if(y>=N || y<0 || x>=M || x<0)
			return false;
		
		
		return true;
	}
	
	static int sum() {
		int sum=0;
		for(int i = 0 ; i < N ;i++) {
			for(int  j = 0 ; j< M ; j++) {
				if(temp[i][j] == 0) {
					sum++;
				}
			}
		}
		
		return sum;
		
	}
	static void print() {
		for(int a=0;a<N;a++) {
			for(int b=0;b<M;b++) {
				System.out.print(map[a][b]+" ");
			}
			System.out.println();
		}
	}
	
	static class XY{
		int y;
		int x;
			XY(int y,int x){
				this.y=y;
				this.x=x;
			}
	}
	
	
	

}

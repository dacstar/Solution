package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17142 {
	static int N,M,res;
	static int map[][];
	static boolean check[];
	static ArrayList<XY> list;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][N];

		list = new ArrayList<>();

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					list.add(new XY(i,j,0));
			}
		}
		check  = new boolean[list.size()];
		res=10000000;
		DFS(0,0);
		if(res==10000000)
			System.out.println("-1");
		else
			System.out.println(res);

	}

	public static void DFS(int depth,int idx) {
		if(depth == M) {
			BFS();
			return ;
		}


		for(int i=idx;i<check.length;i++) {
			if(check[i])
				continue;
			check[i]=true;
			DFS(depth+1,i);
			check[i]=false;
		}
	}

	public static void BFS() {
		int temp[][] = new int[N][N];
		Queue<XY> q = new LinkedList<>();
		for(int i=0;i<check.length;i++) {
			if(check[i]) {
				temp[list.get(i).y][list.get(i).x]=-1;
				q.add(new XY(list.get(i).y,list.get(i).x,0));
			}
		}

		while(!q.isEmpty()) {
			XY xy = q.poll();

			for(int d=0;d<4;d++) {
				int tmpy=xy.y+dy[d];
				int tmpx=xy.x+dx[d];
				if(check(tmpy, tmpx) && map[tmpy][tmpx]==0 && temp[tmpy][tmpx]==0) {
					temp[tmpy][tmpx]=xy.cnt+1;
					q.add(new XY(tmpy,tmpx,xy.cnt+1));
				}else if(check(tmpy, tmpx) && map[tmpy][tmpx]==2 && temp[tmpy][tmpx]==0) {
					temp[tmpy][tmpx]=xy.cnt+1;
					q.add(new XY(tmpy,tmpx,xy.cnt+1));
				}
			}
		}
		int cnt=0;
		//print(temp);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0 && temp[i][j]==0)
					return ;
				if(map[i][j]==0 && temp[i][j]!=0)
					cnt=Math.max(cnt, temp[i][j]);
			}
		}
		
		res=Math.min(res, cnt);

	}





	public static boolean check(int y,int x){
		if(y<0 || y>=N || x<0 || x>=N)
			return false;

		return true;
	}

	static class XY{
		int y;
		int x;
		int cnt;
		XY(int y,int x,int cnt){
			this.y=y;
			this.x=x;
			this.cnt=cnt;
		}
	}
	static void print(int [][]arr) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

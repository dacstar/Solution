package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gaaaaaarden {
	static int N,M,G,R,res;
	static int map[][];
	static ArrayList<XY> list;
	static boolean Green[],Red[];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		map = new int[N][M];
		res=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					list.add(new XY(i,j));
			}
		}
		List<RC> red= new ArrayList<>();
		List<RC> green= new ArrayList<>();
		RDFS(0,red,green);
		System.out.println(res);
		
	}
	
	public static void RDFS(int depth,List<RC> red,List<RC> green) {
		if(red.size() == R && green.size() == G) {
			res=Math.max(BFS(red,green),res);
			return ;
		}
		
		if(depth == list.size() || red.size() >R || green.size() > G) {
			return ;
		}
		RC rc = new RC(list.get(depth).y,list.get(depth).x,3,0);
		red.add(rc);
		RDFS(depth+1,red,green);
		red.remove(rc);
		rc = new RC(list.get(depth).y,list.get(depth).x,4,0);
		green.add(rc);
		RDFS(depth+1,red,green);
		green.remove(rc);
		
		RDFS(depth+1,red,green);
	}
	

	
	public static int BFS(List<RC> red,List<RC> green) {
		Queue<RC> q = new LinkedList<>();
		int sum=0;
		int temp[][] = new int[N][M];
		int visit[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j]=map[i][j];
			}
		}
		for(int i=0;i<red.size();i++) {
			q.add(new RC(red.get(i).y,red.get(i).x,3,0));
			temp[red.get(i).y][red.get(i).x]=3;
		}
		for(int i=0;i<green.size();i++) {
			q.add(new RC(green.get(i).y,green.get(i).x,4,0));
			temp[green.get(i).y][green.get(i).x]=4;
		}
		
		while(!q.isEmpty()) {
			RC rc=q.poll();
			
			if(temp[rc.y][rc.x] == -5)
				continue;
			for(int d=0;d<4;d++) {
				int tmpy=dy[d]+rc.y;
				int tmpx=dx[d]+rc.x;
				if(check(tmpy,tmpx,temp) && temp[tmpy][tmpx] != rc.color) {
				
					if(temp[tmpy][tmpx] ==1 || temp[tmpy][tmpx]==2) {
						temp[tmpy][tmpx]=rc.color;
						visit[tmpy][tmpx]=rc.dir+1;
						q.add(new RC(tmpy,tmpx,rc.color,rc.dir+1));
						continue;
					}else{
						if(visit[tmpy][tmpx] == rc.dir+1) {
							temp[tmpy][tmpx]=-5;
							visit[tmpy][tmpx]=-5;
							sum++;
							continue;
						}
					}
				}
				
			}
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(temp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("Á¤´ä:"+sum);
		return sum;
		
	}
	
	public static boolean check(int y,int x,int temp[][]) {
		if(x<0 || y>=N || y<0 || x>=M || map[y][x]==0 || temp[y][x]==-5)
			return false;
		
		return true;
	}
	
	
	public static class XY{
		int y;
		int x;
		
			XY(int y,int x){
				this.y=y;
				this.x=x;
			}
	}
	
	public static class RC{
		int y;
		int x;
		int color;
		int dir;
			RC(int y,int x,int color,int dir){
				this.y=y;
				this.x=x;
				this.color=color;
				this.dir=dir;
			}
	}

}

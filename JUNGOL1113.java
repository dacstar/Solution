import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class JUNGOL1113{
	static int N,M;
	static int map[][];
	static boolean check[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		map = new int[N][M];
		check =new boolean[N][M];
		int y=s.nextInt();
		int x=s.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=s.nextInt();
			}
		}
		int sum=1111110;
		PriorityQueue<RC> q = new PriorityQueue<>();
		q.add(new RC(0,0,0,-1));
		while(!q.isEmpty()) {
			RC rc=q.poll();
			check[rc.r][rc.c]=true;
			if(rc.r==y && rc.c==x) {
				sum=Math.min(sum, rc.edge);
			}
			
			for(int d=0;d<4;d++) {
				int tmpr=dy[d]+rc.r;
				int tmpc=dx[d]+rc.c;
				if(checkedge(tmpr, tmpc)) {
					if(!check[tmpr][tmpc]) {
						check[tmpr][tmpc]=true;
						if(rc.dir==-1 || rc.dir==d) {
							q.add(new RC(tmpr,tmpc,rc.edge,d));
						}else {
							q.add(new RC(tmpr,tmpc,rc.edge+1,d));
						}
						
					}
				}

			}
		}
		System.out.println(sum);
	}


	static class RC implements Comparable<RC> {
		int r;
		int c;
		int edge;
		int dir;
		RC(int r,int c,int edge,int dir){
			this.r=r;
			this.c=c;
			this.edge=edge;
			this.dir=dir;
		}
		@Override
		public int compareTo(RC o) {
			// TODO Auto-generated method stub
			return o.edge > this.edge ? -1 : 1;
		}

	}

	static boolean checkedge(int r,int c) {
		if(r<0 || r>=N || c<0 || c>=M || map[r][c]==0) {
			return false;
		}
		return true;
	}

}

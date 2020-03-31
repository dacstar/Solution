import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution14503 {
	static int N,M;
	static int cnt;
	static int map[][];
	static int dy[]= {-1,0,1,0};
	static int dx[]= {0,1,0,-1};
	static ArrayList<RC> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		map = new int[N][M];
		list = new ArrayList<>();
		list.add(new RC(s.nextInt(),s.nextInt(),s.nextInt()));
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=s.nextInt();
			}
		}
		cnt=0;

			map[list.get(0).r][list.get(0).c]=-1;

		BFS(list.get(0).r,list.get(0).c,list.get(0).d);

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==-1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void BFS(int r,int c,int d) {

		Queue<RC> q = new LinkedList<>();
		q.add(new RC(r,c,d));
		while(!q.isEmpty()) {
			RC rc = q.poll();
			int tmpc=0;
			int tmpr=0;
			int dir=rc.d;
			boolean wall=true;
			for(int i=0;i<4;i++) {
				dir=(dir+3)%4;
				tmpc=rc.c+dx[dir];
				tmpr=rc.r+dy[dir];
				if(check(tmpr,tmpc)) {
					map[tmpr][tmpc]=-1;
					q.add(new RC(tmpr,tmpc,dir));
					wall=false;
					break;
				}else {
					continue;
				}
			}
			if(wall) {
				int dirc=(dir+2)%4;
				tmpr=rc.r+dy[dirc];
				tmpc=rc.c+dx[dirc];
				if(!backcheck(tmpr, tmpc)) {
					return ;
				}else {
					q.add(new RC(tmpr,tmpc,dir));
				}
			}
		}


	}



	static boolean check(int r,int c) {
		if(r <0 || r>=N || c<0 ||c>=M || map[r][c]==1 || map[r][c]==-1)
			return false;

		return true;
	}

	static boolean backcheck(int r,int c) {
		if(r <0 || r>=N || c<0 ||c>=M || map[r][c]==1)
			return false;

		return true;
	}

	static class RC{
		int r;
		int c;
		int d;
		RC(int r,int c,int d){
			this.r=r;
			this.c=c;
			this.d=d;
		}
	}

}

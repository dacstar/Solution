import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1938 {
	static int map[][];
	static boolean check[][][];
	static int N,res;
	static int dy[]= {0,1,0,-1};
	static int dx[]= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N][2];
		res=1000000;
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j)=='B')
					map[i][j]=3;
				else if(str.charAt(j)=='E')
					map[i][j]=2;
				else
					map[i][j]=str.charAt(j)-'0';
			}
		}
		int count=0;
		boolean visit=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				if(!visit &&map[i][j]==3 && count==1) {
					if(check(i,j+1) && check(i,j-1) && map[i][j+1]==3 && map[i][j-1]==3) {
						BFS(i,j,0);
						visit=true;
						break;
					}
					else if(check(i-1,j) && check(i+1,j) && map[i+1][j]==3 && map[i-1][j]==3) {
						BFS(i,j,1);
						visit=true;
					}
					break;
				}else if(map[i][j]==3 && count==0) {
					count++;
				}

			}
		}
		if(res==1000000)
			System.out.println("0");
		else
			System.out.println(res);


	}

	static void BFS(int r,int c,int d) {
		Queue<RC> q = new LinkedList<>();
		q.add(new RC(r,c,0,d));

		while(!q.isEmpty()) {
			RC rc = q.poll();
			if(!checkre(rc.r,rc.c,rc.d)) {
				
				continue;
			}
					//	System.out.println(rc.r+" "+rc.c+" "+rc.d+" "+rc.cnt);
			if(rc.d==0 && checkre(rc.r,rc.c,rc.d) && map[rc.r][rc.c]==2 && map[rc.r][rc.c+1]==2 && map[rc.r][rc.c-1]==2) {
				res=Math.min(rc.cnt, res);
				break;
			}else if(rc.d==1 && checkre(rc.r,rc.c,rc.d) && map[rc.r][rc.c]==2 && map[rc.r+1][rc.c]==2 && map[rc.r-1][rc.c]==2) {
				res=Math.min(rc.cnt, res);
				break;
			}

			for(int i=0;i<4;i++) {
				int tmpr=dy[i]+rc.r;
				int tmpc=dx[i]+rc.c;
				if(checkre(tmpr,tmpc,rc.d) && !check[tmpr][tmpc][rc.d]) {
					check[tmpr][tmpc][rc.d]=true;
					q.add(new RC(tmpr,tmpc,rc.cnt+1,rc.d));
				}else if(checkd(tmpr,tmpc,(rc.d+1)%2) && !check[tmpr][tmpc][(rc.d+1)%2]) {
					q.add(new RC(rc.r,rc.c,rc.cnt+1,(rc.d+1)%2));
				}
			}

		}
	}

	static boolean check(int y,int x) {

		if(y<0 || y>=N  || x<0 || x>=N || map[y][x]==1)
			return false;

		return true;
	}
	
	static boolean checkre(int y,int x,int d) {

		if(d==0 && (y<0 || y>=N  || x<0 || x>=N || x-1 <0 || x+1>=N || map[y][x]==1 || map[y][x-1]==1 || map[y][x+1]==1)) 
			return false;
		else if(d==1 && (y<0 || y>=N  || x<0 || x>=N || y-1 <0 || y+1>=N ||map[y][x]==1 ||map[y-1][x]==1 || map[y+1][x]==1)) 
			return false;

		return true;
	}

	static boolean checkd(int y,int x,int d) {

		if(d==0 && ((x - 1 < 0 && x + 1 < N) ||(y - 1 < 0 && y + 1 < N) || map[y][x]==1 || map[y-1][x-1]==1 || map[y-1][x]==1 || map[y-1][x+1]==1 || map[y+1][x-1]==1 || map[y+1][x]==1 || map[y+1][x+1]==1)) 
			return false;
		else if(d==1 && ((x - 1 < 0 && x + 1 < N) ||(y - 1 < 0 && y + 1 < N) ||map[y][x]==1 ||map[y-1][x-1]==1 || map[y-1][x+1]==1 || map[y][x-1]==1 || map[y][x+1]==1 || map[y+1][x-1]==1 || map[y+1][x+1]==1)) 
			return false;

		return true;
	}

	static class RC{
		int r;
		int c;
		int cnt;
		int d;
		RC(int r,int c,int cnt,int d){
			this.r=r;
			this.c=c;
			this.cnt=cnt;
			this.d=d;
		}
	}
}

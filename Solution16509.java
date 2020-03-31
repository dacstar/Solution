import java.util.Scanner;

public class Solution16509 {

	static int map[][];
	static int sum;
	static  boolean visit[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int gy[] = {-1,-1,1,1};
	static int gx[]=  {-1,1,1,-1};
	static int ar;
	static int ac;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		sum=Integer.MAX_VALUE;
		map = new int[10][9];
		visit = new boolean[10][9];
		int r=s.nextInt();
		int c=s.nextInt();

		ar=s.nextInt();
		ac=s.nextInt();
		map[ar][ac]=1;
		DFS(r,c,0);
		if(sum==Integer.MAX_VALUE)
			sum=-1;
		System.out.println(sum);
	}


	static void DFS(int r,int c,int cnt) {

		if( r == ar && c == ac) {
			sum = Math.min(sum, cnt);
			return ;
		}
		if(10 <=cnt) {
			return ;
		}
		int kr = 0;
		int kc = 0;
		for(int d=0;d<4;d++) {
			int tmpr=r+dy[d];
			int tmpc=c+dx[d];
			if(checkmap(tmpr, tmpc) && !visit[tmpr][tmpc]) {
				visit[tmpr][tmpc]=true;
				for(int dir=0;dir<2;dir++) {
					kr=tmpr;
					kc=tmpc;
					int flge=0;
					for(int i=0;i<2;i++) {
						kr=kr+gy[(dir+d)%4];
						kc=kc+gx[(dir+d)%4];
						if(!checkmap(kr,kc)) {
							flge=1;
							break;
						}else {
							if(i != 1 && map[kr][kc]==1) {
								flge=1;
								break;
							}
						}
					}
					if(flge==0) {
						visit[kr][kc]=true;
						DFS(kr,kc,cnt+1);
						visit[kr][kc]=false;
					}
				}
				visit[tmpr][tmpc]=false;
			}
		}

	}





	static boolean checkmap(int r,int c) {
		if(r<0 || r>=10 || c<0 || c>=9) {
			return false;
		}


		return true;
	}

	static class RC{
		int r;
		int c;
	}









}

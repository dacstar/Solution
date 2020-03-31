import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Back2583 {
	static int N,M,K;
	static int map[][];
	static boolean check[][];
	static int count;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1,};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		K=s.nextInt();
		count=1;
		map = new int[N][M];
		check =new boolean[N][M];
		for(int i=0;i<K;i++) {
			int ix=s.nextInt();
			int ij=s.nextInt();
			int jx=s.nextInt();
			int jy=s.nextInt();
			createmaxtix(ij,ix,jy,jx);
		}

		ArrayList<Integer>list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0 && !check[i][j]) {
					DFS(i,j);
					list.add(count);
					count=1;	
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
	
		
		
	}
	
	static void createmaxtix(int iy,int ix,int jy,int jx) {
		
		for(int i=iy;i<jy;i++) {
			for(int j=ix;j<jx;j++) {
				map[i][j]=1;
			}
		}
	}
	
	static void DFS(int i,int j) {
		check[i][j]=true;
		for(int d=0;d<4;d++) {
			int tmpy=dy[d]+i;
			int tmpx=dx[d]+j;
			if(checkmap(tmpy,tmpx)) {
				count++;
				DFS(tmpy,tmpx);
			}
		}
	}
	
	static  boolean checkmap(int y,int x) {
		
		if(y>=N || y<0 || x>=M || x<0 || map[y][x]==1 || check[y][x])
			return false;
		
		return true;
	}

}

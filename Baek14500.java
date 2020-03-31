import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek14500 {
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	static int M,N,max;
	static boolean visit[][];
	static int map[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		max=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visit[i][j]=true;
				DFS(i,j,0,0);
				visit[i][j]=false;
				another(i,j);
			}
		}
		System.out.println(max);
	}
	
	static void DFS(int y,int x,int depth,int sum) {
		if(depth ==4) {
			max=Math.max(max, sum);
			return ;
			
		}
		
		
		for(int d=0;d<4;d++) {
			int r=dy[d]+y;
			int c=dx[d]+x;
			if(check(r, c)) {
				visit[r][c]=true;
				DFS(r,c,depth+1,sum+map[r][c]);
				visit[r][c]=false;
			}
			
		}
		
		
	}
	
	static boolean check(int y,int x) {
		if(y>=N || y<0 || x>=M || x<0 || visit[y][x])
			return false;
		
		return true;
	}
	static void another(int x, int y) {
        // 1. 맵의 꼭지점일때는 ㅗ 모양 불가능
        if((x == 0 || x == N-1) && (y == 0 || y == M-1)) return;
        
        int sum = map[x][y];
 
        // 2. 맵의 테두리일때는 모양이 하나
        if(x == 0)
            sum += map[x][y-1] + map[x][y+1] + map[x+1][y];
        else if(x == N-1)
            sum += map[x][y-1] + map[x][y+1] + map[x-1][y];
        else if(y == 0)
            sum += map[x-1][y] + map[x+1][y] + map[x][y+1];
        else if(y == M-1) 
            sum += map[x-1][y] + map[x+1][y] + map[x][y-1];
        // 3. 맵의 테두리가 아닐 때는 4 개의 모양을 비교
        else {
            sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x][y-1] + map[x][y+1]);
            sum = Math.max(sum, map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1]);
            sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x-1][y] + map[x+1][y]);
            sum = Math.max(sum, map[x][y] + map[x][y-1] + map[x-1][y] + map[x+1][y]);
        }
 
        max = Math.max(max, sum);        
    }

}

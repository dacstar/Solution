package LeetCode;

import java.util.*;

class Main {
	static int map[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		//{{0,0,0,0},{1,0,1,0},{0,0,0,0},{0,0,1,0}};
		
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int N,ans;

	public static void main(String[] args) {
		N = 3;
		ans = -1;
		DFS(0);
		System.out.println(ans);
	}

	static void DFS(int depth){
    
    if(depth ==1){
      BFS();
      return ;
    }
    
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
    	  if((i==0 && j==1) || (i==1 && j==0))
    		  continue;
        if(map[i][j]== 0){
        	for(int d=3;d<=6;d++) {
            map[i][j]=d;
            DFS(depth+1);
        	}
        	map[i][j]=0;
        }
      }
    }
  
  }

	static void BFS() {
		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}

		copy[0][0] = 1;
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(0, 0));
		while (!q.isEmpty()) {
			XY xy = q.poll();

			for (int d = 0; d < 4; d++) {
				int tmpy = dy[d] + xy.y;
				int tmpx = dx[d] + xy.x;
				if (check(tmpy, tmpx) && copy[tmpy][tmpx] == 0) {
					copy[tmpy][tmpx] = 2;
					q.add(new XY(tmpy, tmpx));
				}else if(check(tmpy,tmpx) && copy[tmpy][tmpx] >2 && copy[tmpy][tmpx] != (d+3)) {
					q.add(new XY(tmpy, tmpx));
				}
			}
		}
		print(copy);
		ans = Math.max(ans, zerocheck(copy));

	}

	static int zerocheck(int copy[][]) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void print(int [][]copy) {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean check(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}
		return true;
	}

	static class XY {

		int y;
		int x;

		XY(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
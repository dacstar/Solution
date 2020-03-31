import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1260 {
	static int N,M,V;
	static int map[][];
	static boolean check[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		V=s.nextInt();
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int i=0;i<M;i++) {
			int a=s.nextInt();
			int b=s.nextInt();
			map[a][b]=map[b][a]=1;
		}
	
		DFS(V);
		System.out.println();
		BFS(V);
	}
	
	static void DFS(int depth) {
		System.out.print(depth+" ");
		check[depth]=true;
		
		for(int i=1;i<=N;i++) {
			if(map[depth][i]==1 && map[i][depth]==1) {
				if(!check[i]) {
					DFS(i);
				}
			}
		}
	}
	static void BFS(int depth) {
	Queue<Integer> q =new LinkedList<>();	
	check = new boolean[N+1];
	check[depth]=true;
	q.add(depth);
	while(!q.isEmpty()) {
		int dep=q.poll();
		System.out.print(dep+" ");
		for(int i=1;i<=N;i++) {
			if(map[dep][i]==1 && map[i][dep]==1) {
				if(!check[i]) {
					check[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	
		
	}

}

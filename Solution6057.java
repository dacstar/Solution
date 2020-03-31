import java.util.Scanner;
import java.util.Stack;

public class Solution6057 {
	static boolean check[];
	static int map[][];
	static int N,cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++) {
			N=s.nextInt();
			Stack<Integer> st =new Stack<Integer>(); 
			cnt=0;
			int M=s.nextInt();
			map = new int[N][M];
			check = new boolean[N];
			for(int i=0;i<M;i++) {
				int a=s.nextInt();
				int b=s.nextInt();
				map[a-1][b-1]= map[b-1][a-1]=1;
			}
			
			for(int i=0;i<N;i++){
				if(!check[i]){
					cnt++;
					DFS(i);
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
	
	static void DFS(int depth) {
		check[depth]=true;
		
		for(int i=0;i<N;i++) {
			if(map[depth][i]==1 && !check[i]) {
				check[i]=true;
				DFS(i);
			}
		}
		
	}

}

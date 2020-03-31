import java.util.Scanner;

public class Back11724 {
	static int N,M;
	static int arr[][];
	static boolean visit[];
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		count=0;
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0;i<M;i++) {
			int a=s.nextInt();
			int b=s.nextInt();
			arr[a][b]=arr[b][a]=1;
		}
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				count++;
			DFS(i);
			}
		}
		System.out.println(count);
	}
	static void DFS(int depth) {
		if(visit[depth])
			return ;
		
		visit[depth]=true;
		
		for(int i=1;i<=N;i++) {
			if(arr[depth][i]==1)
				DFS(i);
		}
		
	}
	
	

}

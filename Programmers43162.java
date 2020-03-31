
public class Programmers43162 {
	static int N;
	static boolean check[];
	static int ans;
	static int map[][]= {{1,1,0},{1,1,0},{0,0,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=3;
		ans=0;
		check = new boolean[N];
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				DFS(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	static void DFS(int depth) {
		check[depth]=true;
		
		
		for(int i=0;i<N;i++) {
			if(map[depth][i]==1 && !check[i])
				DFS(i);
		}
	}

}

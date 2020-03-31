import java.util.Scanner;

public class Solution11403 {
	static int N;
	static int[][] map;
	static int[][] arr;
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		map = new int[N][N];
		check = new boolean[N];
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=s.nextInt();
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j) {
					check = new boolean[N];
					DFS(-1,j,i);
				}else {
					check = new boolean[N];
					DFS(i,j,i);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

	static void DFS(int start, int end,int depth) {
		if(start == end) {
			arr[depth][end]=1;
			return ;
		}
		
		if(start ==-1)
			start=end;
		
		for(int i=0;i<N;i++) {
			if(check[i])
				continue;
			if(map[start][i]==1 && !check[i]) {
				check[i]=true;
				DFS(i,end,depth);
				check[i]=false;
			}
		}
	}

}

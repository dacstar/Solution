import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back17406 {
	static boolean check[];
	static int map[][];
	static int arr[][];
	static int N,M,K,res;
	static int r[],c[],s[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		res=Integer.MAX_VALUE;
		r= new int[K];
		c=new int[K];
		s=new int[K];
		check = new boolean[K];
		map = new int[N+1][M+1];
		arr = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				arr[i][j]=map[i][j];
			}
		}
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			r[k]=Integer.parseInt(st.nextToken());
			c[k]=Integer.parseInt(st.nextToken());
			s[k]=Integer.parseInt(st.nextToken());
		}

		DFS(0,map);

		System.out.println(res);

	}
	static int[][] move(int topr,int topc,int r,int c,int mtx[][]) {
		int mtopr=topr;
		int mtopc=topc;
		int mr=r;
		int mc=c;
		int tarr[][];
		int tarr2[][];
		tarr= new int[N+1][M+1];
		tarr2= new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				tarr[i][j]=mtx[i][j];
			}
		}
		
		while(true) {
			if(mtopr == mr && mtopc == mc)
				break ;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					tarr2[i][j]=tarr[i][j];
				}
			}
			for(int i=mtopc;i<mc;i++) {
				tarr[mtopr][i+1]=tarr2[mtopr][i];
			}
			for(int i=mtopr;i<mr;i++) {
				tarr[i+1][mc]=tarr2[i][mc];
			}
			for(int i=mc;i>mtopc;i--) {
				tarr[mr][i-1]=tarr2[mr][i];
			}
			for(int i=mr;i>mtopr;i--) {
				tarr[i-1][mtopc]=tarr2[i][mtopc];
			}
			mtopr++;
			mtopc++;
			mr--;
			mc--;
		}
		
		return tarr;
		

	}
	static void sum(int [][]mtx) {
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=M;j++) {
				sum+=mtx[i][j];
			}
			res=Math.min(sum,res);
		}
	}

	static void DFS(int depth,int [][]mtx) {

		if(depth == K) {
			sum(mtx);
			return ;
		}

		for(int i=0;i<K;i++) {
			if(check[i])
				continue;
			check[i]=true;
			int jc[][]=move(r[i]-s[i],c[i]-s[i],r[i]+s[i],c[i]+s[i],mtx);
			DFS(depth+1,jc);
			check[i]=false;
		}

	}

	static void print() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

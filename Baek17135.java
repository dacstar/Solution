import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek17135 {
	static int N,M,D,MAX;
	static int map[][];
	static PriorityQueue<Dir> pq = new PriorityQueue<>();
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		MAX=-1;
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		DFS(0);
		System.out.println(MAX);
	}


	static void DFS(int depth) {
		if(depth ==3) {
			attack();
			return ;
		}


		for(int i=0;i<M;i++) {
			if(map[N][i]!=2) {
				map[N][i]=2;
				DFS(depth+1);
				map[N][i]=0;
			}
		}
	}

	static void attack() {
		int sum=0;
		int cmap[][] =new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cmap[i][j]=map[i][j];
			}
		}
		ArrayList<Dir> list = new ArrayList<>();

		for(int i=0;i<M;i++) {
			if(map[N][i]==2) {
				list.add(new Dir(N,i,0));
			}
		}
		while(true) {
			for(int d=0;d<list.size();d++) {
				for(int i=N-1;i>=0;i--) {
					for(int j=0;j<M;j++) {
						if(cmap[i][j]==1) {
							int value=Math.abs(list.get(d).r-i)+Math.abs(list.get(d).c-j);
							if(value<=D) {
								pq.add(new Dir(i,j,value));
							}
						}
					}
				}
				Dir dir=pq.poll();
				if(dir==null)
					continue;
				visit[dir.r][dir.c]=true;
				while(!pq.isEmpty())
					pq.poll();
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visit[i][j]) {
						visit[i][j]=false;
						sum++;
					    cmap[i][j]=0;
					}
				}
			}
			if(check(cmap))
				break;
			move(cmap);
		}
		MAX=Math.max(sum, MAX);
	}
	static void move(int [][]arr) {
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					if(i+1>=N) {
						arr[i][j]=0;
					}else {
						arr[i][j]=0;
						arr[i+1][j]=1;
					}
				}
			}
		}
	}
	static boolean check(int arr[][]){
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1)
					return false;
			}
		}
		return true;
	}



	static class Dir implements Comparable<Dir> {
		int r;
		int c;
		int d;
		Dir(int r,int c,int d){
			this.r=r;
			this.c=c;
			this.d=d;
		}
		@Override
		public int compareTo(Dir o) {
			// TODO Auto-generated method stub
			if(this.d==o.d) {
				return this.c > o.c ? 1 : -1 ;
			}
			return this.d > o.d ? 1 : -1;
		}
	}




}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16973 {

	static int N,M,H,W,Sr,Sc,Fr,Fc,result;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static int[][]map;
	static int[][]arr;
	static boolean[][]check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map= new int[N][M];
		arr= new int[N][M];
		result=100;
		check = new boolean[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()); 
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				arr[i][j]=1000;
			}
		}
		st = new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		Sr=Integer.parseInt(st.nextToken());
		Sc=Integer.parseInt(st.nextToken());
		Fr=Integer.parseInt(st.nextToken());
		Fc=Integer.parseInt(st.nextToken());
		DFS(Sr-1,Sc-1,0);
		if(result==100)
			result=-1;
		System.out.println(result);
	}

	static void DFS(int i,int j,int cnt) {


		check[i][j]=true;
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(i,j,0));


		while(!q.isEmpty()) {
			XY xy=q.poll();
			if(xy.y == Fr-1 && xy.x ==Fc-1) {
				result=Math.min(xy.cnt, result);
				return ;
			}
			for(int d=0;d<4;d++) {
				int tmpy=dy[d]+xy.y;
				int tmpx=dx[d]+xy.x;
				if(checkedge(tmpy, tmpx) && !check[tmpy][tmpx]) {
					if(check(tmpy,tmpx)) {
						check[tmpy][tmpx]=true;
						q.add(new XY(tmpy,tmpx,xy.cnt+1));
					}
				}
			}
		}
	}

	static boolean checkedge(int y,int x) {
		if(y>=N || y<0 || x>=M || x<0 || map[y][x]==1)
			return false;

		return true;
	}

	static class XY{
		int y;
		int x;
		int cnt;
		XY(int y,int x,int cnt){
			this.y=y;
			this.x=x;
			this.cnt=cnt;
		}
	}

	static boolean check(int i,int j) {

		if(i+H>N || j+W>M) {
			return false;
		}

		for(int h=i;h<i+H;h++) {
			for(int w=j;w<j+W;w++) {
				if(map[h][w]==1)
					return false;
			}
		}


		return true;

	}

}

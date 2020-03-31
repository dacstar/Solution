import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution16234 {
	static int N,L,R;
	static boolean start;
	static int result;
	static int country[][];
	static boolean check[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		country = new int[N][N];
		result=0;
		start=false;
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				country[i][j]=Integer.parseInt(st.nextToken());

			}
		}
		while(true) {
			check = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!check[i][j])
						BFS(i,j);
				}
			}
			if(start) {
				start=false;
				result++;
				
			}else if(!start) {
				break;
			}
		}
		System.out.println(result);
	}

	static void BFS(int i,int j) {
		boolean sumcheck[][] = new boolean[N][N];
		boolean visit=false;
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(i,j));
		int sum=0;
		int size=1;
		while(!q.isEmpty()) {
			XY xy = q.poll();
			for(int d=0;d<4;d++) {
				int tmpy=xy.y+dy[d];
				int tmpx=xy.x+dx[d];
				if(checkbound(tmpy, tmpx)) {
					int sub=Math.abs(country[xy.y][xy.x]-country[tmpy][tmpx]);
					if(sub >=L && sub<=R) {
						if(sum==0)
							sum+=country[xy.y][xy.x];
						check[tmpy][tmpx]=true;
						check[xy.y][xy.x]=true;
						sumcheck[tmpy][tmpx]=true;
						sumcheck[xy.y][xy.x]=true;
						size++;
						visit=true;
						start=true;
						sum+=country[tmpy][tmpx];
						q.add(new XY(tmpy,tmpx));
					}
				}
			}
		}
		if(visit) {
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(sumcheck[a][b])
						country[a][b]=sum/size;
				}
			}

		}


	}

	static boolean checkbound(int y,int x) {
		if(y>=N || y<0 || x>=N || x<0 || check[y][x]) {
			return false;
		}
		return true;

	}

	static class XY{
		int y;
		int x;
		XY(int y,int x){
			this.y=y;
			this.x=x;
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2105 {
	static int dy[]= {1,1,-1,-1};
	static int dx[]= {1,-1,-1,1};
	static int N,res,ay,ax;
	static int map[][];
	static boolean visit[][];
	static boolean check[];
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			N=Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			res=-1;
			check = new boolean[101];
			list = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N-2;i++) {
				for(int j=1;j<N-1;j++) {
					ay=i;
					ax=j;
					check[map[i][j]]=true;
					BFS(i,j,1,0);
					check[map[i][j]]=false;
				}
			}
			System.out.println(res);
		}
	}

	static void BFS(int y,int x,int cnt,int dir) {
		
		for(int d=0;d<2;d++) {
			if(dir==3 && d==1)
				break;
			int tmpy=dy[d+dir]+y;
			int tmpx=dx[d+dir]+x;
			if(checkedge(tmpy, tmpx)) {
				if(ay==tmpy && ax==tmpx) {
					res=Math.max(res, cnt);
					return ;
				}
				if(!check[map[tmpy][tmpx]]) {
					check[map[tmpy][tmpx]]=true;
					BFS(tmpy,tmpx,cnt+1,dir+d);
					check[map[tmpy][tmpx]]=false;
				}
			}

		}
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

	static boolean checkedge(int y,int x) {
		if(y>=N || y<0 || x>=N || x<0) {
			return false;
		}
		return true;
	}
}

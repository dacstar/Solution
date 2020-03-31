import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656 {
	static int N,W,H,res;
	static int[][]map;
	static int num[];
	static int[][]cmap;
	static int D[];
	static boolean visit[];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++){
			StringTokenizer st =new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			map = new int[H][W];
			res=999999;
			num = new int[N];
			D = new int[2];
			cmap = new int[H][W];
			for(int i=0;i<H;i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					cmap[i][j]=map[i][j];
				}
			}
			DFS(0);
			System.out.println("#"+test_case+" "+res);
		}

	}


	static void crush(int r,int c) {
		Queue<XY> q= new LinkedList<>();
		q.add(new XY(r,c,cmap[r][c]));
		while(!q.isEmpty()) {
			XY xy = q.poll();
			cmap[xy.y][xy.x]=0;
			int tmpy=xy.y;
			int tmpx=xy.x;
			for(int d=0;d<4;d++) {
				for(int i=0;i<xy.value-1;i++) {
					tmpy+=dy[d];
					tmpx+=dx[d];
					if(checkedge(tmpy, tmpx)) {
						if(cmap[tmpy][tmpx]!=0 && cmap[tmpy][tmpx]!=1)
							q.add(new XY(tmpy,tmpx,cmap[tmpy][tmpx]));
						cmap[tmpy][tmpx]=0;
					}
				}
				tmpy=xy.y;
				tmpx=xy.x;
			}
		}
	}

	static void DFS(int depth) {
		if(N==depth) {
			for(int i=0;i<N;i++) {
				for(int k=0;k<H;k++) {
					if(cmap[k][num[i]]!=0) {
						crush(k, num[i]);
						move();
						sum();
						break;
					}
				}
			}
			copy();
			return ;


		}


		for(int i=0;i<W;i++) {
			num[depth]=i;
			DFS(depth+1);

		}


	}


	static void sum() {
		int sum=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(cmap[i][j]!=0)
					sum++;
			}
		}

		res=Math.min(sum, res);


	}

	static void print() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(cmap[i][j]+" ");
			}
			System.out.println();
		}

	}

	static void move() {
		for(int i=H-1;i>=0;i--){
			for(int j=0;j<W;j++) {
				if(cmap[i][j]==0)
					continue;
				int ny=i;
				int color=cmap[i][j];
				while(true) {
					if(!checkedge(ny+1, j) || cmap[ny+1][j] !=0)
						break;
					ny++;
				}
				cmap[i][j]=0;
				cmap[ny][j]=color;
			}
		}
	}

	static boolean checkedge(int r,int c) {

		if(r >=H || r<0 || c>=W || c<0)
			return false;

		return true;

	}

	static void copy() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				cmap[i][j]=map[i][j];
			}
		}
	}

	static int findmax() {
		int sum=0;
		int max=-1;
		for(int i=0;i<W;i++) {
			for(int j=0;j<H;j++) {
				if(cmap[j][i]!=0) {
					if(max<cmap[j][i]) {
						max=cmap[j][i];
						D[0]=j;
						D[1]=i;
					}
					break;
				}
			}
		}

		return sum;

	}

	static class XY{
		int y;
		int x;
		int value;
		XY(int y,int x,int value){
			this.y=y;
			this.x=x;
			this.value=value;
		}
	}

}

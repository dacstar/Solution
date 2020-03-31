import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice17144 {
	static int R,C,T,answer;
	static ArrayList<XY> list;
	static int Air[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		answer=0;
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		Air = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				Air[i][j]=Integer.parseInt(st.nextToken());
				if(Air[i][j]==-1)
					list.add(new XY(i,j));
			}
		}
		while(T --> 0) {
			Spread();
			clean();
		}
		answer();
		System.out.println(answer);
	}
	
	public static void Spread() {
		int temp[][] = new int[R][C];
		for(int i = 0;i < R;i++) {
			for(int j = 0;j < C;j++) {
				if(Air[i][j] != -1 && Air[i][j] != 0) {
					int cnt=0;
						for(int d = 0;d < 4;d++) {
							int tmpy = dy[d] + i;
							int tmpx = dx[d] + j;
							if(check(tmpy,tmpx)) {
								temp[tmpy][tmpx] += (Air[i][j] / 5);
								cnt++;
							}
						}
					Air[i][j]=Air[i][j]-(Air[i][j]/5)*cnt;
				}
			}
		}
		copyarr(temp);
	}
	
	
	public static void clean() {
		int air=list.get(0).y;
		int airx=list.get(0).x;
			//왼쪽
			for(int r=air-2;r>=0;r--) {
				Air[r+1][0]=Air[r][0];
			}
			//위쪽
			for(int c=1;c<C;c++) {
				Air[0][c-1]=Air[0][c];
			}
			//오른쪽
			for(int r=1;r<=air;r++) {
				Air[r-1][C-1]=Air[r][C-1];
			}
			//정면
			for(int c=C-1;c>=airx+2;c--) {
				Air[air][c]=Air[air][c-1];
			}
			Air[air][airx+1]=0;
			air=list.get(1).y;
			airx=list.get(1).x;	
			for(int r=air+2;r<R;r++) {
				Air[r-1][0]=Air[r][0];
			}
			//위쪽
			for(int c=1;c<C;c++) {
				Air[R-1][c-1]=Air[R-1][c];
			}
			//오른쪽
			for(int r=R-2;r>=air;r--) {
				Air[r+1][C-1]=Air[r][C-1];
			}
			for(int c=C-1;c>=airx+2;c--) {
				Air[air][c]=Air[air][c-1];
			}
			Air[air][airx+1]=0;
		
	}
	
	public static void answer() {
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(Air[i][j]>0)
					answer+=Air[i][j];
			}
		}
	}
	
	public static class XY{
		int y;
		int x;
				XY(int y, int x){
					this.y=y;
					this.x=x;
				}
	}
	
	
	public static boolean check(int y,int x) {
		if(y>=R || y<0 || x>=C || x<0 || Air[y][x] ==-1) {
			return false;
			
		}
		
		return true;
		
	}
	
	public static void copyarr(int arr[][]) {
		
		for(int i = 0 ; i < R ; i++) {
			for(int  j = 0 ; j < C ; j++) {
				Air[i][j]+=arr[i][j];
			}
		}
	}
	
	static void print() {
		for(int a=0;a<R;a++) {
			for(int b=0;b<C;b++) {
				System.out.print(Air[a][b]+" ");
			}
			System.out.println();
		}
	}
	
	

}

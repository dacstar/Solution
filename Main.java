import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int R,C,T;
	static int dust[][],air[][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static ArrayList<RC> Air;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		dust = new int[R][C];
		Air = new ArrayList<>();
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				dust[i][j]=Integer.parseInt(st.nextToken());
				if(dust[i][j] == -1)
					Air.add(new RC(i,j));
			}
		}


		for(int i=0;i<T;i++) {
			spread();
			Refresh();
			print();
			System.out.println("*청소*");
//			System.out.println("******");
		}
		sum();
	}
	
	static void print() {
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(dust[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void sum() {
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(dust[i][j] !=-1)
					sum+=dust[i][j];
			}
		}
		System.out.println(sum);
		
	}
	static void Refresh() {
		for(int a=0;a<Air.size();a++) {
			RC rc=Air.get(a);
			if(a==0) {
				//아래쪽
				for(int i=rc.r-1;i>0;i--) {
					dust[i][0] = dust[i-1][0];
				}
				//왼쪽
				for(int i=0;i<C-1;i++) {
					dust[0][i] = dust[0][i+1];
				}
				//위쪽
				for(int i=0;i<rc.r;i++) {
					dust[i][C-1] = dust[i+1][C-1];
				}
				//오른쪽
				for(int i=C-1;i>0;i--) {
					dust[rc.r][i] = dust[rc.r][i-1];
				}
				dust[rc.r][1]=0;
			}
			else {
				//위쪽
				for(int i=rc.r+1;i<R-1;i++) {
					dust[i][rc.c]=dust[i+1][rc.c];
				}
				//왼쪽
				for(int i=0;i<C-1;i++) {
					dust[R-1][i] = dust[R-1][i+1];
				}
				//아래쪽
				for(int i=R-1;i>rc.r;i--) {
					dust[i][C-1] = dust[i-1][C-1];
				}
				//오른쪽
				for(int i=C-1;i>rc.c;i--) {
					dust[rc.r][i] = dust[rc.r][i-1];
				}
				
				dust[rc.r][1]=0;
			}
		}
		
	}
	
	static void print1() {
		for(int a=0;a<R;a++) {
			for(int b=0;b<C;b++) {
				System.out.print(dust[a][b]+" ");
			}
			System.out.println();
		}
	}

	static void spread() {
		int count=0;
		int mul=0;
		air = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(dust[i][j] != -1 && dust[i][j] !=0) {
					count=BFS(i,j);
					mul=(dust[i][j]/5)*count;
					dust[i][j]-=mul;
				}
			}
		}


		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				dust[i][j]+=air[i][j];
			}
		}
	}

	static int BFS(int i,int j) {

		int count=0;

		for(int d=0;d<4;d++) {
			int tmpy=dy[d]+i;
			int tmpx=dx[d]+j;
			if(checkedge(tmpy,tmpx) &&dust[tmpy][tmpx] != -1 ) {
				air[tmpy][tmpx]+=dust[i][j]/5;
				count++;
			}
		}

		return count;

	}

	static class RC{
		int r;
		int c;
		RC(int r,int c){
			this.r=r;
			this.c=c;
		}
	}

	static boolean checkedge(int r,int c) {
		if(r<0 || r>=R ||c<0 || c>=C) {
			return false;
		}

		return true;
	}

}

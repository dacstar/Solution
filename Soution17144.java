import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Soution17144 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static ArrayList<XY> list;
	static int R,C,T;
	static int map[][],air[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		list= new ArrayList<>();
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					list.add(new XY(i,j));
				}
			}
		}
		int cnt=0;
		for(int i=0;i<T;i++){
			spread();
			Refresh();
			System.out.println("****");
			print();
		}

		int sum = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}


		System.out.println(sum);
	}

	static void print() {

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}


	static int findmove(int r,int c) {
		int cnt=0;
		for(int d=0;d<4;d++) {
			int tmpy=dy[d]+r;
			int tmpx=dx[d]+c;
			if(checkmap(tmpy, tmpx) && map[tmpy][tmpx] != -1) {
				cnt++;
				air[tmpy][tmpx] +=(map[r][c]/5);
			}
		}
		return cnt;
	}



	static void spread(){
		air = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					int cnt = findmove(i,j);
					int mul = (map[i][j]/5)*cnt;
					map[i][j]-=mul;
				}
			}
		}

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=air[i][j];
			}
		}
	}

	static void Refresh() {
		for(int a=0;a<list.size();a++) {
			XY xy=list.get(a);
			if(a==0) {
				//아래쪽
				for(int i=xy.y-1;i>0;i--) {
					map[i][0] = map[i-1][0];
				}
				//왼쪽
				for(int i=0;i<C-1;i++) {
					map[0][i] = map[0][i+1];
				}
				//위쪽
				for(int i=0;i<xy.y;i++) {
					map[i][C-1] = map[i+1][C-1];
				}
				//오른쪽
				for(int i=C-1;i>0;i--) {
					map[xy.y][i] = map[xy.y][i-1];
				}
				map[xy.y][1]=0;
			}
			else {
				//위쪽
				for(int i=xy.y+1;i<R-1;i++) {
					map[i][xy.x]=map[i+1][xy.x];
				}
				//왼쪽
				for(int i=0;i<C-1;i++) {
					map[R-1][i] = map[R-1][i+1];
				}
				//아래쪽
				for(int i=R-1;i>xy.y;i--) {
					map[i][C-1] = map[i-1][C-1];
				}
				//오른쪽
				for(int i=C-1;i>xy.x;i--) {
					map[xy.y][i] = map[xy.y][i-1];
				}

				map[xy.y][1]=0;
			}
		}

	}

	static boolean checkmap(int y,int x) {
		if(y<0 || y>=R || x<0 || x>=C) {
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

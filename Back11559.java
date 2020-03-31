import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11559 {
	static int map[][];
	static boolean visit[][];
	static boolean count;
	static boolean asd;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1,};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		map = new int[12][6];
		visit = new boolean[12][6];
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<12;i++) {
			String str=br.readLine();
			for(int j=0;j<6;j++) {
				if(str.charAt(j)=='R') {
					map[i][j]=1;
				}else if(str.charAt(j)=='G') {
					map[i][j]=2;
				}else if(str.charAt(j)=='B') {
					map[i][j]=3;
				}else if(str.charAt(j)=='P') {
					map[i][j]=4;
				}else if(str.charAt(j)=='Y') {
					map[i][j]=5;
				}
			}
		}
		int result;
		result=0;
		int q=0;
		while(true) {
//			print();
//			System.out.println();
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(!visit[i][j] && map[i][j]!=0) {
						DFS(i,j,map[i][j],1);
						if(count) {
							result++;
							count=false;
							asd=true;
							delete(map[i][j]);
//							System.out.println("***delete****");
//							print();
//							System.out.println();
						}else {
							visit = new boolean[12][6];
						}
					}
				}
			}
			if(asd) {
				move();
//				System.out.println("****move****");
//				print();
//				System.out.println();
				asd=false;
			}else {
				break;
			}
		}
		System.out.println(result);
	}

	static void DFS(int i,int j,int color,int cnt) {
		visit[i][j]=true;
		if(cnt>=4) {
			count=true;
		}
		for(int d=0;d<4;d++) {
			int tmpy=dy[d]+i;
			int tmpx=dx[d]+j;
			if(check(tmpy,tmpx) && map[tmpy][tmpx] !=0) {
				if(map[tmpy][tmpx]==color) {
					cnt++;
					DFS(tmpy,tmpx,color,cnt);
				}
			}
		}
	}

	static void print() {
		for(int a=0;a<12;a++) {
			for(int b=0;b<6;b++) {
				System.out.print(map[a][b]+" ");
			}
			System.out.println();
		}
	}

	static void move() {
		for(int i=11;i>=0;i--){
			for(int j=0;j<6;j++) {
				if(map[i][j]==0)
					continue;
				int ny=i;
				int color=map[i][j];
				while(true) {
					if(!check(ny+1, j) || map[ny+1][j] !=0)
						break;
					ny++;
				}
				map[i][j]=0;
				map[ny][j]=color;
			}
		}
	}

	static void delete(int color) {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(visit[i][j])
					map[i][j]=0;
			}
		}
		
		visit = new boolean[12][6];

	}



	static boolean check(int y,int x) {

		if(y>=12 || y<0 || x>=6 || x<0 || visit[y][x])
			return false;

		return true;
	}

}
